package com.lentecitos.design.design.design.mapping;

import com.lentecitos.design.design.design.domain.model.entities.PatasAnteojos;
import com.lentecitos.design.design.design.resource.CreatePatasAnteojosResource;
import com.lentecitos.design.design.design.resource.PatasAnteojosResource;
import com.lentecitos.design.design.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class PatasAnteojosMapper implements Serializable {
    @Autowired
    EnhancedModelMapper modelMapper;

    public PatasAnteojos toEntity(CreatePatasAnteojosResource resource){
        return modelMapper.map(resource, PatasAnteojos.class);
    }

    public PatasAnteojosResource toResource(PatasAnteojos entity){
        return modelMapper.map(entity, PatasAnteojosResource.class);
    }
}
