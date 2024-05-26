package com.upc.order.design.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orden")
public class Orden {

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
