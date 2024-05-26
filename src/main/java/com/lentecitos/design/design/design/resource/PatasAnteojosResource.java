package com.lentecitos.design.design.design.resource;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class PatasAnteojosResource {
    private Long codigo;
    private String nombre;
    private String ruta_archivo_chiquito;
    private String ruta_archivo_mediano;
    private String ruta_archivo_grande;
    private BigDecimal aumento_precio;
    private Boolean disponible;
}
