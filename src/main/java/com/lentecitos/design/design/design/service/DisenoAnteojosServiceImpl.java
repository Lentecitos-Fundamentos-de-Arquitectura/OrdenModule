package com.lentecitos.design.design.design.service;

import com.lentecitos.design.design.design.domain.model.entities.DisenoAnteojos;
import com.lentecitos.design.design.design.domain.persistence.DisenoAnteojosRepository;
import com.lentecitos.design.design.design.domain.service.DisenoAnteojosService;
import com.lentecitos.design.design.shared.exception.FetchIdNotFoundException;
import com.lentecitos.design.design.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class DisenoAnteojosServiceImpl implements DisenoAnteojosService {

    private final DisenoAnteojosRepository disenoAnteojosRepository;
    private final Validator validator;

    @Override
    public DisenoAnteojos save(DisenoAnteojos disenoAnteojos) {
        Set<ConstraintViolation<DisenoAnteojos>> violations = validator.validate(disenoAnteojos);
        if(violations.isEmpty()) {
            return disenoAnteojosRepository.save(disenoAnteojos);
        }
        throw new ResourceValidationException("DisenoAnteojos", violations);
    }

    @Override
    public DisenoAnteojos update(DisenoAnteojos disenoAnteojos) {
        DisenoAnteojos existingDisenoAnteojos = findById(disenoAnteojos.getCodigo());
        if(existingDisenoAnteojos != null){
            existingDisenoAnteojos.setCodigoCreador(disenoAnteojos.getCodigoCreador());
            existingDisenoAnteojos.setCodigoPatasAnteojos(disenoAnteojos.getCodigoPatasAnteojos());
            existingDisenoAnteojos.setCodigoMarcosAnteojos(disenoAnteojos.getCodigoMarcosAnteojos());
            existingDisenoAnteojos.setCodigoColorMarco(disenoAnteojos.getCodigoColorMarco());
            existingDisenoAnteojos.setCodigoColorLunas(disenoAnteojos.getCodigoColorLunas());
            existingDisenoAnteojos.setGrosorAnteojos(disenoAnteojos.getGrosorAnteojos());
            existingDisenoAnteojos.setAnchoMarco(disenoAnteojos.getAnchoMarco());
            existingDisenoAnteojos.setAltoMarco(disenoAnteojos.getAltoMarco());
            existingDisenoAnteojos.setCodigoMaterialFabricacionMontura(disenoAnteojos.getCodigoMaterialFabricacionMontura());
            existingDisenoAnteojos.setCodigoMaterialFabricacionLuna(disenoAnteojos.getCodigoMaterialFabricacionLuna());
            existingDisenoAnteojos.setSoftErrased(disenoAnteojos.getSoftErrased());
            existingDisenoAnteojos.setUpdatedAt(disenoAnteojos.getUpdatedAt());

            return disenoAnteojosRepository.save(existingDisenoAnteojos);

    }else{
        throw new FetchIdNotFoundException("DisenoAnteojos", disenoAnteojos.getCodigo().intValue());
        }
    }

    @Override
    public DisenoAnteojos findById(Long id) {
        if(disenoAnteojosRepository.existsById(id.intValue())){
            return disenoAnteojosRepository.findById(id.intValue()).orElseThrow();
        }
        throw new FetchIdNotFoundException("DisenoAnteojos", id.intValue());
    }

    @Override
    public boolean deleteById(Long id) {
        if(disenoAnteojosRepository.existsById(id.intValue())){
            disenoAnteojosRepository.deleteById(id.intValue());
            if(disenoAnteojosRepository.existsById(id.intValue())){
                return false;
            }
            return true;
        }
        throw new FetchIdNotFoundException("DisenoAnteojos", id.intValue());
    }

    @Override
    public List<DisenoAnteojos> findAll() {
        return disenoAnteojosRepository.findAll();
    }
}
