package com.lentecitos.design.design.design.domain.model.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "material_fabricacion_luna")
public class MaterialFabricaLuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "disponible")
    private Boolean disponible;
}
