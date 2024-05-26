package com.upc.order.design.service;

import com.upc.order.design.domain.model.Orden;
import com.upc.order.design.domain.persistence.OrdenRepository;
import com.upc.order.design.domain.service.OrdenService;
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
public class OrdenServiceImpl implements OrdenService {

    private final OrdenRepository ordenRepository;
    private final Validator validator;

    @Override
    public Orden save(Orden orden) {
        Set<ConstraintViolation<Orden>> violations = validator.validate(orden);
        if(violations.isEmpty()) {
            return ordenRepository.save(orden);
        }
        throw new ResourceValidationException("Orden", violations);
    }

    @Override
    public Orden update(Orden orden) {
        Orden existingOrden = findById(orden.getCodigo());

        if(existingOrden != null){
            existingOrden.setCodigoEstadoOrden(orden.getCodigoEstadoOrden());
            existingOrden.setCodigoUsuario(orden.getCodigoUsuario());
            existingOrden.setPrecioTotal(orden.getPrecioTotal());
            existingOrden.setDireccionReparto(orden.getDireccionReparto());

            return ordenRepository.save(existingOrden);

        }else {
            throw new FetchIdNotFoundException("Orden", orden.getCodigo().intValue());
        }
    }

    @Override
    public Orden findById(Long id) {
        if(ordenRepository.existsById(id.intValue())){
            return ordenRepository.findById(id.intValue()).orElseThrow();
        }
        throw new FetchIdNotFoundException("Orden", id.intValue());
    }

    @Override
    public boolean deleteById(Long id) {
        if(ordenRepository.existsById(id.intValue())){
            ordenRepository.deleteById(id.intValue());
            return true;
        }
        throw new FetchIdNotFoundException("Orden", id.intValue());
    }

    @Override
    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }
}
