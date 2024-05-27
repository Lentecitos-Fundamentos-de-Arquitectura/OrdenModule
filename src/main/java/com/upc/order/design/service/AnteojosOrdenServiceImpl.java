package com.upc.order.design.service;

import com.upc.order.design.domain.model.AnteojosOrden;
import com.upc.order.design.domain.persistence.AnteojosOrdenRepository;
import com.upc.order.design.domain.service.AnteojosOrdenService;
import com.upc.order.shared.exception.FetchIdNotFoundException;
import com.upc.order.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class AnteojosOrdenServiceImpl implements AnteojosOrdenService {
    private final AnteojosOrdenRepository anteojosOrdenRepository;
    private final Validator validator;

    @Override
    public AnteojosOrden save(AnteojosOrden anteojosOrden) {
        Set<ConstraintViolation<AnteojosOrden>> violations = validator.validate(anteojosOrden);
        if(violations.isEmpty()) {
            return anteojosOrdenRepository.save(anteojosOrden);
        }
        throw new ResourceValidationException("AnteojosOrden", violations);
    }

    @Override
    public AnteojosOrden update(AnteojosOrden anteojosOrden) {
        AnteojosOrden existingAnteojosOrden = findById(anteojosOrden.getCodigo());

        if(existingAnteojosOrden != null){
            existingAnteojosOrden.setCodigoOrden(anteojosOrden.getCodigoOrden());
            existingAnteojosOrden.setCodigoDisenoAnteojos(anteojosOrden.getCodigoDisenoAnteojos());
            existingAnteojosOrden.setPrecioBase(anteojosOrden.getPrecioBase());
            existingAnteojosOrden.setPrecioFinal(anteojosOrden.getPrecioFinal());
            existingAnteojosOrden.setCodigoDescuento(anteojosOrden.getCodigoDescuento());

            return anteojosOrdenRepository.save(existingAnteojosOrden);
        }else {
            throw new FetchIdNotFoundException("AnteojosOrden", anteojosOrden.getCodigo().intValue());
        }
    }

    @Override
    public AnteojosOrden findById(Long id) {
        if(anteojosOrdenRepository.existsById(id.intValue())){
            return anteojosOrdenRepository.findById(id.intValue()).orElseThrow();
        }
        throw new FetchIdNotFoundException("AnteojosOrden", id.intValue());
    }

    @Override
    public boolean deleteById(Long id) {
        if (anteojosOrdenRepository.existsById(id.intValue())) {
            anteojosOrdenRepository.deleteById(id.intValue());
            if (anteojosOrdenRepository.existsById(id.intValue()))
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("AnteojosOrden", id.intValue());
    }

   
}
