package com.lentecitos.design.design.design.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "diseno_anteojos")
public class DisenoAnteojos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "codigo_creador")
    private Long codigoCreador;

    @Column(name = "codigo_patas_anteojos")
    private Long codigoPatasAnteojos;

    @Column(name = "codigo_marcos_anteojos")
    private Long codigoMarcosAnteojos;

    @Column(name = "codigo_color_marco")
    private Long codigoColorMarco;

    @Column(name = "codigo_color_lunas")
    private Long codigoColorLunas;

    @Column(name = "grosor_anteojos")
    private Long grosorAnteojos;

    @Column(name = "ancho_marco")
    private Long anchoMarco;

    @Column(name = "alto_marco")
    private Long altoMarco;

    @Column(name = "codigo_material_fabricacion_montura")
    private Long codigoMaterialFabricacionMontura;

    @Column(name = "codigo_material_fabricacion_luna")
    private Long codigoMaterialFabricacionLuna;

    @Column(name = "soft_errased")
    private Boolean softErrased;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

}
