package com.lentecitos.design.design.design.mapping;

import com.lentecitos.design.design.design.domain.model.entities.DisenoAnteojos;
import com.lentecitos.design.design.design.resource.CreateDisenoAnteojosResource;
import com.lentecitos.design.design.design.resource.DisenoAnteojosResource;
import com.lentecitos.design.design.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class DisenoAnteojosMapper implements Serializable {

    @Autowired
    EnhancedModelMapper modelMapper;

    public DisenoAnteojos toEntity(CreateDisenoAnteojosResource resource){
        return modelMapper.map(resource, DisenoAnteojos.class);
    }

    public DisenoAnteojosResource toResource(DisenoAnteojos entity){
        return modelMapper.map(entity, DisenoAnteojosResource.class);
    }
}
