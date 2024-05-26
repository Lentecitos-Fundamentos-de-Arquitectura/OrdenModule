package com.lentecitos.design.design.design.service;

import com.lentecitos.design.design.design.domain.model.entities.Color;
import com.lentecitos.design.design.design.domain.persistence.ColorRepository;
import com.lentecitos.design.design.design.domain.service.ColorService;
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
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;
    private final Validator validator;

    @Override
    public Color save(Color color) {
        Set<ConstraintViolation<Color>> violations = validator.validate(color);
        if(violations.isEmpty()) {
            return colorRepository.save(color);
        }
        throw new ResourceValidationException("Color", violations);
    }

    @Override
    public Color update(Color color) {
        Color existingColor = findById(color.getCodigo());

        if(existingColor != null){
            existingColor.setNombre(color.getNombre());
            existingColor.setB(color.getB());
            existingColor.setR(color.getR());
            existingColor.setG(color.getG());

            return colorRepository.save(existingColor);

        }else {
            throw new FetchIdNotFoundException("Color", color.getCodigo().intValue());
        }
    }

    @Override
    public Color findById(Long id) {
        if(colorRepository.existsById(id.intValue())){
            return colorRepository.findById(id.intValue()).orElseThrow();
        }
        throw new FetchIdNotFoundException("Color", id.intValue());
    }

    @Override
    public boolean deleteById(Long id) {
        if(colorRepository.existsById(id.intValue())){
            colorRepository.deleteById(id.intValue());
            if(colorRepository.existsById(id.intValue()))
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("Color", id.intValue());
    }

    @Override
    public List<Color> findAll() {
        return colorRepository.findAll();
    }

}
