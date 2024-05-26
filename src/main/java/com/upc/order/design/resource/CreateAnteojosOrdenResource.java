package com.upc.order.design.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateAnteojosOrdenResource {
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
