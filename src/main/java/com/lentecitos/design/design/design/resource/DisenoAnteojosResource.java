package com.lentecitos.design.design.design.resource;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class DisenoAnteojosResource {
    private Long codigo;
    private Long codigoCreador;
    private Long codigoPatasAnteojos;
    private Long codigoMarcosAnteojos;
    private Long codigoColorMarco;
    private Long codigoColorLunas;
    private Long grosorAnteojos;
    private Long anchoMarco;
    private Long altoMarco;
    private Long codigoMaterialFabricacionMontura;
    private Long codigoMaterialFabricacionLuna;
    private Boolean softErrased;
    private Date createdAt;
    private Date updatedAt;
}
