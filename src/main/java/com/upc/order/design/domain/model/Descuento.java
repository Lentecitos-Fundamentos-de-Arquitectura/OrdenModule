package com.upc.order.design.domain.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "descuento")
public class Descuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nombre", length = 250)
    private String nombre;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @Column(name = "caducidad")
    private Date caducidad;

    @Column(name = "porcentaje_descuento")
    private double porcentajeDescuento;
}
