package com.lentecitos.design.design.design.service;

import com.lentecitos.design.design.design.domain.model.entities.MaterialFabricacionMontura;
import com.lentecitos.design.design.design.domain.persistence.MaterialFabricacionMonturaRepository;
import com.lentecitos.design.design.design.domain.service.MaterialFabricacionMonturaService;
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
public class MaterialFabricacionMonturaServiceImpl implements MaterialFabricacionMonturaService {

    private final MaterialFabricacionMonturaRepository materialFabricacionMonturaRepository;
    private final Validator validator;

    @Override
    public MaterialFabricacionMontura save(MaterialFabricacionMontura materialFabricacionMontura) {
        Set<ConstraintViolation<MaterialFabricacionMontura>> violations = validator.validate(materialFabricacionMontura);
        if(violations.isEmpty()) {
            return materialFabricacionMonturaRepository.save(materialFabricacionMontura);
        }
        throw new ResourceValidationException("MaterialFabricacionMontura", violations);
    }

    @Override
public MaterialFabricacionMontura update(MaterialFabricacionMontura materialFabricacionMontura) {
        MaterialFabricacionMontura existingMaterialFabricacionMontura = findById(materialFabricacionMontura.getCodigo());
        if(existingMaterialFabricacionMontura != null){
            existingMaterialFabricacionMontura.setNombre(materialFabricacionMontura.getNombre());
            existingMaterialFabricacionMontura.setPrecio(materialFabricacionMontura.getPrecio());
            existingMaterialFabricacionMontura.setDisponible(materialFabricacionMontura.getDisponible());

            return materialFabricacionMonturaRepository.save(existingMaterialFabricacionMontura);
        }
        throw new FetchIdNotFoundException("MaterialFabricacionMontura", materialFabricacionMontura.getCodigo().intValue());
    }

    @Override
    public MaterialFabricacionMontura findById(Long id) {
        if (materialFabricacionMonturaRepository.existsById(id.intValue())) {
            return materialFabricacionMonturaRepository.findById(id.intValue()).orElseThrow();
        }
        throw new FetchIdNotFoundException("MaterialFabricacionMontura", id.intValue());
    }

    @Override
    public boolean deleteById(Long id) {
        if (materialFabricacionMonturaRepository.existsById(id.intValue())) {
            materialFabricacionMonturaRepository.deleteById(id.intValue());
            return !materialFabricacionMonturaRepository.existsById(id.intValue());
        }
        throw new FetchIdNotFoundException("MaterialFabricacionMontura", id.intValue());
    }

    @Override
    public List<MaterialFabricacionMontura> findAll() {
        return materialFabricacionMonturaRepository.findAll();
    }

}
