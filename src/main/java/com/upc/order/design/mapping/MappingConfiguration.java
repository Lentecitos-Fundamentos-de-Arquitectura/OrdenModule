package com.upc.order.design.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("MappingConfiguration")
public class MappingConfiguration {

    @Bean
    public OrdenMapper ordenMapper() {
        return new OrdenMapper();
    }

    @Bean
    public EstadoOrdenMapper estadoOrdenMapper() {
        return new EstadoOrdenMapper();
    }

    @Bean
    public DescuentoMapper descuentoMapper() {
        return new DescuentoMapper();
    }

    @Bean
    public AnteojosOrdenMapper anteojosOrdenMapper() {
        return new AnteojosOrdenMapper();
    }
}
