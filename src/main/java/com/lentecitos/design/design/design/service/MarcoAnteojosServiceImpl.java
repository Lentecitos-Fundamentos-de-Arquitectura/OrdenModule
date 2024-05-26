package com.lentecitos.design.design.design.service;

import com.lentecitos.design.design.design.domain.model.entities.MarcoAnteojos;
import com.lentecitos.design.design.design.domain.persistence.MarcoAnteojosRepository;
import com.lentecitos.design.design.design.domain.service.MarcoAnteojosService;
import com.lentecitos.design.design.shared.exception.FetchIdNotFoundException;
import com.lentecitos.design.design.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class MarcoAnteojosServiceImpl implements MarcoAnteojosService {

    private final MarcoAnteojosRepository marcoAnteojosRepository;
    private final Validator validator;

    @Override
    public MarcoAnteojos save(MarcoAnteojos marcoAnteojos) {
        Set<ConstraintViolation<MarcoAnteojos>> violations = validator.validate(marcoAnteojos);
        if(violations.isEmpty()) {
            return marcoAnteojosRepository.save(marcoAnteojos);
        }
        throw new ResourceValidationException("MarcoAnteojos", violations);
    }

    @Override
    public MarcoAnteojos update(MarcoAnteojos marcoAnteojos) {
        MarcoAnteojos existingMarcoAnteojos = findById(marcoAnteojos.getCodigo());
        if(existingMarcoAnteojos != null){
            existingMarcoAnteojos.setNombre(marcoAnteojos.getNombre());
            existingMarcoAnteojos.setRutaArchivoChiquito(marcoAnteojos.getRutaArchivoChiquito());
            existingMarcoAnteojos.setRutaArchivoMediano(marcoAnteojos.getRutaArchivoMediano());
            existingMarcoAnteojos.setRutaArchivoGrande(marcoAnteojos.getRutaArchivoGrande());
            existingMarcoAnteojos.setAumentoPrecio(marcoAnteojos.getAumentoPrecio());
            existingMarcoAnteojos.setDisponible(marcoAnteojos.getDisponible());

            return marcoAnteojosRepository.save(existingMarcoAnteojos);
        }
        throw new FetchIdNotFoundException("MarcoAnteojos", marcoAnteojos.getCodigo().intValue());
    }

    @Override
    public MarcoAnteojos findById(Long id) {
        if (marcoAnteojosRepository.existsById(id.intValue())) {
            return marcoAnteojosRepository.findById(id.intValue()).orElseThrow();
        }
        throw new FetchIdNotFoundException("MarcoAnteojos", id.intValue());
    }

    @Override
    public boolean deleteById(Long id) {
        if (marcoAnteojosRepository.existsById(id.intValue())) {
            marcoAnteojosRepository.deleteById(id.intValue());
            return !marcoAnteojosRepository.existsById(id.intValue());
        }
        throw new FetchIdNotFoundException("MarcoAnteojos", id.intValue());
    }

    @Override
    public List<MarcoAnteojos> findAll() {
        return marcoAnteojosRepository.findAll();
    }

}
