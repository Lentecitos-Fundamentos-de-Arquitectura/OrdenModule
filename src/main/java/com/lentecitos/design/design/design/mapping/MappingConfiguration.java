package com.lentecitos.design.design.design.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("MappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ColorMapper colorMapper() {
        return new ColorMapper();
    }

    @Bean
    public DisenoAnteojosMapper disenoAnteojosMapper() {
        return new DisenoAnteojosMapper();
    }

    @Bean
    public MarcoAnteojosMapper marcoAnteojosMapper() {
        return new MarcoAnteojosMapper();
    }

    @Bean
    public MaterialFabricacionMonturaMapper materialFabricacionMonturaMapper() {
        return new MaterialFabricacionMonturaMapper();
    }

    @Bean
    public MaterialFabricaLunaMapper materialFabricaLunaMapper() {
        return new MaterialFabricaLunaMapper();
    }

    @Bean
    public PatasAnteojosMapper patasAnteojosMapper() {
        return new PatasAnteojosMapper();
    }
}
