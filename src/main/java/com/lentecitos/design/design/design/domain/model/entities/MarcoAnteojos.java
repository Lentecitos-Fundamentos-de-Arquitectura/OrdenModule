package com.lentecitos.design.design.design.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "marco_antojos")
public class MarcoAnteojos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "ruta_archivo_chiquito", length = 255)
    private String rutaArchivoChiquito;

    @Column(name = "ruta_archivo_mediano", length = 255)
    private String rutaArchivoMediano;

    @Column(name = "ruta_archivo_grande", length = 255)
    private String rutaArchivoGrande;

    @Column(name = "aumento_precio")
    private BigDecimal aumentoPrecio;

    @Column(name = "disponible")
    private Boolean disponible;

}
