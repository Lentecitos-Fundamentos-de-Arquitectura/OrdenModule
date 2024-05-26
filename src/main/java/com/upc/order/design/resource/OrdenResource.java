package com.upc.order.design.resource;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class OrdenResource {
    private Long codigo;
    private Long codigoUsuario;
    private double precioTotal;
    private String direccionReparto;
    private Long codigoEstadoOrden;
}
