package com.lentecitos.design.design.design.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ColorResource {
    private Long codigo;
    private String nombre;
    private short r;
    private short g;
    private short b;
}
