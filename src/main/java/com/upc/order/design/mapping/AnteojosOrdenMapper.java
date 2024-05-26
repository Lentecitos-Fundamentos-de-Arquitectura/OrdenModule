package com.upc.order.design.mapping;

import com.upc.order.design.domain.model.AnteojosOrden;
import com.upc.order.design.resource.AnteojosOrdenResource;
import com.upc.order.design.resource.CreateAnteojosOrdenResource;
import com.upc.order.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class AnteojosOrdenMapper implements Serializable {

    @Autowired
    EnhancedModelMapper modelMapper;

    public AnteojosOrden toEntity(CreateAnteojosOrdenResource resource){
        return modelMapper.map(resource, AnteojosOrden.class);
    }

    public AnteojosOrdenResource toResource(AnteojosOrden entity){
        return modelMapper.map(entity, AnteojosOrdenResource.class);
    }

}
