package com.upc.order.design.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "anteojos_orden")
public class AnteojosOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "codigo_diseno_anteojos")
    private Long codigoDisenoAnteojos;

    @Column(name = "codigo_orden")
    private Long codigoOrden;

    @Column(name = "codigo_descuento")
    private Long codigoDescuento;

    @Column(name = "precio_base")
    private double precioBase;

    @Column(name = "precio_final")
    private double precioFinal;
}
