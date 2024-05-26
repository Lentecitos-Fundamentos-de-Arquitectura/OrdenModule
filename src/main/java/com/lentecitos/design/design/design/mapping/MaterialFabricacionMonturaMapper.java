package com.lentecitos.design.design.design.mapping;

import com.lentecitos.design.design.design.domain.model.entities.MaterialFabricacionMontura;
import com.lentecitos.design.design.design.resource.CreateMaterialFabricacionMonturaResource;
import com.lentecitos.design.design.design.resource.MaterialFabricacionMonturaResource;
import com.lentecitos.design.design.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class MaterialFabricacionMonturaMapper implements Serializable {
    @Autowired
    EnhancedModelMapper modelMapper;

    public MaterialFabricacionMontura toEntity(CreateMaterialFabricacionMonturaResource resource){
        return modelMapper.map(resource, MaterialFabricacionMontura.class);
    }

    public MaterialFabricacionMonturaResource toResource(MaterialFabricacionMontura entity){
        return modelMapper.map(entity, MaterialFabricacionMonturaResource.class);
    }
}
