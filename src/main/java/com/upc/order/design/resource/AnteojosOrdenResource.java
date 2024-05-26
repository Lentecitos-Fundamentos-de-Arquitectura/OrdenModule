package com.upc.order.design.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class AnteojosOrdenResource {
    private Long codigo;
    private Long codigoDisenoAnteojos;
    private Long codigoOrden;
    private Long codigoDescuento;
    private double precioBase;
    private double precioFinal;
}
