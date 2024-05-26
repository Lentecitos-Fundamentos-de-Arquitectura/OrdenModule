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
public class CreateEstadoOrdenResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nombre", length = 250)
    private String nombre;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @Column(name = "ruta_imagen")
    private String rutaImagen;
}
