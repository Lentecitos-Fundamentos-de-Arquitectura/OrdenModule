package com.lentecitos.design.design.design.service;

import com.lentecitos.design.design.design.domain.model.entities.PatasAnteojos;
import com.lentecitos.design.design.design.domain.persistence.PatasAnteojosRepository;
import com.lentecitos.design.design.design.domain.service.PatasAnteojosService;
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
public class PatasAnteojosServiceImpl implements PatasAnteojosService {

    private final PatasAnteojosRepository patasAnteojosRepository;
    private final Validator validator;

    @Override
    public PatasAnteojos save(PatasAnteojos patasAnteojos) {
        Set<ConstraintViolation<PatasAnteojos>> violations = validator.validate(patasAnteojos);
        if(violations.isEmpty()) {
            return patasAnteojosRepository.save(patasAnteojos);
        }
        throw new ResourceValidationException("PatasAnteojos", violations);
    }

    @Override
    public PatasAnteojos update(PatasAnteojos patasAnteojos) {
        PatasAnteojos existingPatasAnteojos = findById(patasAnteojos.getCodigo());
        if(existingPatasAnteojos != null){
            existingPatasAnteojos.setNombre(patasAnteojos.getNombre());
            existingPatasAnteojos.setAumento_precio(patasAnteojos.getAumento_precio());
            existingPatasAnteojos.setRuta_archivo_grande(patasAnteojos.getRuta_archivo_grande());
            existingPatasAnteojos.setRuta_archivo_mediano(patasAnteojos.getRuta_archivo_mediano());
            existingPatasAnteojos.setRuta_archivo_chiquito(patasAnteojos.getRuta_archivo_chiquito());
            existingPatasAnteojos.setDisponible(patasAnteojos.getDisponible());

            return patasAnteojosRepository.save(existingPatasAnteojos);
        }
        throw new FetchIdNotFoundException("PatasAnteojos", patasAnteojos.getCodigo().intValue());
    }

    @Override
    public PatasAnteojos findById(Long id) {
        if (patasAnteojosRepository.existsById(id.intValue())) {
            return patasAnteojosRepository.findById(id.intValue()).orElseThrow();
        }
        throw new FetchIdNotFoundException("PatasAnteojos", id.intValue());
    }

    @Override
    public boolean deleteById(Long id) {
        if (patasAnteojosRepository.existsById(id.intValue())) {
            patasAnteojosRepository.deleteById(id.intValue());
            return !patasAnteojosRepository.existsById(id.intValue());
        }
        throw new FetchIdNotFoundException("PatasAnteojos", id.intValue());
    }

    @Override
    public List<PatasAnteojos> findAll() {
        return patasAnteojosRepository.findAll();
    }
}
