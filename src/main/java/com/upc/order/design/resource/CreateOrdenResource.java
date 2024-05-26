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
public class CreateOrdenResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "codigo_usuario")
    private Long codigoUsuario;

    @Column(name = "precio_total")
    private double precioTotal;

    @Column(name = "direccion_reparto")
    private String direccionReparto;

    @Column(name = "codigo_estado_orden")
    private Long codigoEstadoOrden;
}
