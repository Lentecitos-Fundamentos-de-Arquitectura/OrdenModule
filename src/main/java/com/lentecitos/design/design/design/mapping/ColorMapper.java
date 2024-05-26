package com.lentecitos.design.design.design.mapping;

import com.lentecitos.design.design.design.domain.model.entities.Color;
import com.lentecitos.design.design.design.resource.ColorResource;
import com.lentecitos.design.design.design.resource.CreateColorResource;
import com.lentecitos.design.design.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ColorMapper implements Serializable {
    @Autowired
    EnhancedModelMapper modelMapper;

    public Color toEntity(CreateColorResource resource){
        return modelMapper.map(resource, Color.class);
    }

    public ColorResource toResource(Color entity){
        return modelMapper.map(entity, ColorResource.class);
    }
}
