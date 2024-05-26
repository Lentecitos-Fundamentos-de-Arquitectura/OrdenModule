package com.lentecitos.design.design.design.mapping;

import com.lentecitos.design.design.design.domain.model.entities.MaterialFabricaLuna;
import com.lentecitos.design.design.design.resource.CreateMaterialFabricaLunaResource;
import com.lentecitos.design.design.design.resource.MaterialFabricaLunaResource;
import com.lentecitos.design.design.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class MaterialFabricaLunaMapper implements Serializable {
    @Autowired
    EnhancedModelMapper modelMapper;

    public MaterialFabricaLuna toEntity(CreateMaterialFabricaLunaResource resource){
        return modelMapper.map(resource, MaterialFabricaLuna.class);
    }

    public MaterialFabricaLunaResource toResource(MaterialFabricaLuna entity){
        return modelMapper.map(entity, MaterialFabricaLunaResource.class);
    }

}
