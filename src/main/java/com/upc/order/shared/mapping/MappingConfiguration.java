package com.upc.order.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("mappingConfiguration")
public class MappingConfiguration {

    @Bean
    public EnhancedModelMapper enhancedModelMapper() {
        return new EnhancedModelMapper();
    }
}
