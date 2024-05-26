package com.lentecitos.design.design.design.resource;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class MaterialFabricacionMonturaResource {
    private Long codigo;
    private String nombre;
    private BigDecimal precio;
    private Boolean disponible;
}
