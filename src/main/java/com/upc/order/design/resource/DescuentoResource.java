package com.upc.order.design.resource;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class DescuentoResource {
    private Long codigo;
    private String nombre;
    private String descripcion;
    private Date caducidad;
    private double porcentajeDescuento;
}
