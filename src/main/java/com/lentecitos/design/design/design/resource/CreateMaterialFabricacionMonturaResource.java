package com.lentecitos.design.design.design.resource;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateMaterialFabricacionMonturaResource {
    private Long codigo;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "disponible")
    private Boolean disponible;
}
