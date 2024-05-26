package com.upc.order.design.mapping;

import com.upc.order.design.domain.model.Orden;
import com.upc.order.design.resource.CreateOrdenResource;
import com.upc.order.design.resource.OrdenResource;
import com.upc.order.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class OrdenMapper implements Serializable {

    @Autowired
    EnhancedModelMapper modelMapper;

    public Orden toEntity(CreateOrdenResource resource){
        return modelMapper.map(resource, Orden.class);
    }

    public OrdenResource toResource(Orden entity){
        return modelMapper.map(entity, OrdenResource.class);
    }
}
