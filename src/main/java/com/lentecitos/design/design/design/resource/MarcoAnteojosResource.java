package com.lentecitos.design.design.design.resource;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class MarcoAnteojosResource {
    private Long codigo;
    private String nombre;
    private String rutaArchivoChiquito;
    private String rutaArchivoMediano;
    private String rutaArchivoGrande;
    private BigDecimal aumentoPrecio;
    private Boolean disponible;
}
