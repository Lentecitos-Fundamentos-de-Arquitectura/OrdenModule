package com.lentecitos.design.design.design.mapping;

import com.lentecitos.design.design.design.domain.model.entities.MarcoAnteojos;
import com.lentecitos.design.design.design.resource.CreateMarcoAnteojosResource;
import com.lentecitos.design.design.design.resource.MarcoAnteojosResource;
import com.lentecitos.design.design.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class MarcoAnteojosMapper implements Serializable {
    @Autowired
    EnhancedModelMapper modelMapper;

    public MarcoAnteojos toEntity(CreateMarcoAnteojosResource resource){
        return modelMapper.map(resource, MarcoAnteojos.class);
    }

    public MarcoAnteojosResource toResource(MarcoAnteojos entity){
        return modelMapper.map(entity, MarcoAnteojosResource.class);
    }
}
