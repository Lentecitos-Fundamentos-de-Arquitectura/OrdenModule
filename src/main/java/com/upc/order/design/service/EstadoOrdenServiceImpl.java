package com.upc.order.design.service;

import com.upc.order.design.domain.model.EstadoOrden;
import com.upc.order.design.domain.persistence.EstadoOrdenRepository;
import com.upc.order.design.domain.service.EstadoOrdenService;
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
public class EstadoOrdenServiceImpl implements EstadoOrdenService {
    private final EstadoOrdenRepository estadoOrdenRepository;
    private final Validator validator;

    @Override
    public EstadoOrden save(EstadoOrden estadoOrden) {
        Set<ConstraintViolation<EstadoOrden>> violations = validator.validate(estadoOrden);
        if(violations.isEmpty()) {
            return estadoOrdenRepository.save(estadoOrden);
        }
        throw new ResourceValidationException("EstadoOrden", violations);
    }

    @Override
    public EstadoOrden update(EstadoOrden estadoOrden) {
        EstadoOrden existingEstadoOrden = findById(estadoOrden.getCodigo());

        if(existingEstadoOrden != null){
            existingEstadoOrden.setNombre(estadoOrden.getNombre());
            existingEstadoOrden.setDescripcion(estadoOrden.getDescripcion());
            existingEstadoOrden.setRutaImagen(estadoOrden.getRutaImagen());

            return estadoOrdenRepository.save(existingEstadoOrden);
        }else {
            throw new FetchIdNotFoundException("EstadoOrden", estadoOrden.getCodigo().intValue());
        }
    }

    @Override
    public EstadoOrden findById(Long id) {
        if (estadoOrdenRepository.existsById(id.intValue())) {
            return estadoOrdenRepository.findById(id.intValue()).orElseThrow();
        }
        throw new FetchIdNotFoundException("EstadoOrden", id.intValue());
    }

    @Override
    public boolean deleteById(Long id) {
        if (estadoOrdenRepository.existsById(id.intValue())) {
            estadoOrdenRepository.deleteById(id.intValue());
            if(estadoOrdenRepository.existsById(id.intValue()))
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("EstadoOrden", id.intValue());
    }

    @Override
    public List<EstadoOrden> findAll() {
        return estadoOrdenRepository.findAll();
    }
}
