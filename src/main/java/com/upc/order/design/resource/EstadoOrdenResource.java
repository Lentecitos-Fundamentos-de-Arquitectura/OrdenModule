package com.upc.order.design.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class EstadoOrdenResource {
    private Long codigo;
    private String nombre;
    private String descripcion;
    private String rutaImagen;
}
