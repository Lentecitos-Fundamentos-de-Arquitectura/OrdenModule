package com.lentecitos.design.design.design.resource;

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
public class CreateColorResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nombre", length = 250)
    private String nombre;

    @Column(name = "r")
    private short r;

    @Column(name = "g")
    private short g;

    @Column(name = "b")
    private short b;
}
