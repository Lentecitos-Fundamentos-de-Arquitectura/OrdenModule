package com.upc.order.design.mapping;

import com.upc.order.design.domain.model.EstadoOrden;
import com.upc.order.design.resource.CreateEstadoOrdenResource;
import com.upc.order.design.resource.EstadoOrdenResource;
import com.upc.order.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class EstadoOrdenMapper implements Serializable {

    @Autowired
    EnhancedModelMapper modelMapper;

    public EstadoOrden toEntity(CreateEstadoOrdenResource resource){
        return modelMapper.map(resource, EstadoOrden.class);
    }

    public EstadoOrdenResource toResource(EstadoOrden entity){
        return modelMapper.map(entity, EstadoOrdenResource.class);
    }
}
