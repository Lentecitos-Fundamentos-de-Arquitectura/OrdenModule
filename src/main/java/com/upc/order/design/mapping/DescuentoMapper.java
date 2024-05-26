package com.upc.order.design.mapping;

import com.upc.order.design.domain.model.Descuento;
import com.upc.order.design.resource.CreateDescuentoResource;
import com.upc.order.design.resource.DescuentoResource;
import com.upc.order.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class DescuentoMapper implements Serializable {
    @Autowired
    EnhancedModelMapper modelMapper;

    public Descuento toEntity(CreateDescuentoResource resource){
        return modelMapper.map(resource, Descuento.class);
    }

    public DescuentoResource toResource(Descuento entity){
        return modelMapper.map(entity, DescuentoResource.class);
    }
}
