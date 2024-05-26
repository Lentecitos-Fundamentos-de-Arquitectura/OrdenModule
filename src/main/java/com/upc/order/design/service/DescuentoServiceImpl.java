package com.upc.order.design.service;

import com.upc.order.design.domain.model.Descuento;
import com.upc.order.design.domain.persistence.DescuentoRepository;
import com.upc.order.design.domain.service.DescuentoService;
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
public class DescuentoServiceImpl implements DescuentoService {

    private final DescuentoRepository descuentoRepository;
    private final Validator validator;

    @Override
    public Descuento save(Descuento descuento) {
        Set<ConstraintViolation<Descuento>> violations = validator.validate(descuento);
        if(violations.isEmpty()) {
            return descuentoRepository.save(descuento);
        }
        throw new ResourceValidationException("Descuento", violations);
    }

    @Override
    public Descuento update(Descuento descuento) {
        Descuento existingDescuento = findById(descuento.getCodigo());

        if(existingDescuento != null){
            existingDescuento.setNombre(descuento.getNombre());
            existingDescuento.setDescripcion(descuento.getDescripcion());
            existingDescuento.setPorcentajeDescuento(descuento.getPorcentajeDescuento());
            existingDescuento.setCaducidad(descuento.getCaducidad());

            return descuentoRepository.save(existingDescuento);
        }else {
            throw new FetchIdNotFoundException("Descuento", descuento.getCodigo().intValue());
        }
    }

    @Override
    public Descuento findById(Long id) {
        if (descuentoRepository.existsById(id.intValue())) {
            return descuentoRepository.findById(id.intValue()).orElseThrow();}
        throw new FetchIdNotFoundException("Descuento", id.intValue());
    }

    @Override
    public boolean deleteById(Long id) {
        if (descuentoRepository.existsById(id.intValue())) {
            descuentoRepository.deleteById(id.intValue());
            if (descuentoRepository.existsById(id.intValue()))
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("Descuento", id.intValue());
    }

    @Override
    public List<Descuento> findAll() {
        return descuentoRepository.findAll();
    }
}
