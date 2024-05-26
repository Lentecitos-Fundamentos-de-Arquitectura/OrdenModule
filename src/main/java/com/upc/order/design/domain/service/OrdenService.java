package com.upc.order.design.domain.service;

import com.upc.order.design.domain.model.Orden;

import java.util.List;

public interface OrdenService {
    Orden save(Orden orden);
    Orden update(Orden orden);
    Orden findById(Long id);
    List<Orden> findAll();
    boolean deleteById(Long id);
}
