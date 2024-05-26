package com.lentecitos.design.design.design.service;

import com.lentecitos.design.design.design.domain.model.entities.MaterialFabricaLuna;
import com.lentecitos.design.design.design.domain.persistence.MaterialFabricaLunaRepository;
import com.lentecitos.design.design.design.domain.service.MaterialFabricaLunaService;
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
public class MaterialFabricaLunaServiceImpl implements MaterialFabricaLunaService {

    private final MaterialFabricaLunaRepository materialFabricaLunaRepository;
    private final Validator validator;

    @Override
    public MaterialFabricaLuna save(MaterialFabricaLuna materialFabricaLuna) {
        Set<ConstraintViolation<MaterialFabricaLuna>> violations = validator.validate(materialFabricaLuna);
        if(violations.isEmpty()) {
            return materialFabricaLunaRepository.save(materialFabricaLuna);
        }
        throw new ResourceValidationException("MaterialFabricaLuna", violations);
    }

    @Override
    public MaterialFabricaLuna update(MaterialFabricaLuna materialFabricaLuna) {
        MaterialFabricaLuna existingMaterialFabricaLuna = findById(materialFabricaLuna.getCodigo());
        if(existingMaterialFabricaLuna != null){
            existingMaterialFabricaLuna.setNombre(materialFabricaLuna.getNombre());
            existingMaterialFabricaLuna.setPrecio(materialFabricaLuna.getPrecio());
            existingMaterialFabricaLuna.setDisponible(materialFabricaLuna.getDisponible());

            return materialFabricaLunaRepository.save(existingMaterialFabricaLuna);
        }
        throw new FetchIdNotFoundException("MaterialFabricaLuna", materialFabricaLuna.getCodigo().intValue());
    }

    @Override
    public MaterialFabricaLuna findById(Long id) {
        if (materialFabricaLunaRepository.existsById(id.intValue())) {
            return materialFabricaLunaRepository.findById(id.intValue()).orElseThrow();
        }
        throw new FetchIdNotFoundException("MaterialFabricaLuna", id.intValue());
    }

    @Override
    public boolean deleteById(Long id) {
        if (materialFabricaLunaRepository.existsById(id.intValue())) {
            materialFabricaLunaRepository.deleteById(id.intValue());
            return !materialFabricaLunaRepository.existsById(id.intValue());
        }
        throw new FetchIdNotFoundException("MaterialFabricaLuna", id.intValue());
    }

    @Override
    public List<MaterialFabricaLuna> findAll() {
        return materialFabricaLunaRepository.findAll();
    }
}
