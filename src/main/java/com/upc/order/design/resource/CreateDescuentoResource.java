package com.upc.order.design.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateDescuentoResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nombre", length = 250)
    private String nombre;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @Column(name = "caducidad")
    private Date caducidad;

    @Column(name = "porcentaje_descuento")
    private double porcentajeDescuento;
}
