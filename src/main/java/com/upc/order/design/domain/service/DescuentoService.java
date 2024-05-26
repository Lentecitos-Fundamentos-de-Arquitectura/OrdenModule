package com.upc.order.design.domain.service;

import com.upc.order.design.domain.model.Descuento;

import java.util.List;

public interface DescuentoService {
    Descuento save(Descuento descuento);
    Descuento update(Descuento descuento);
    Descuento findById(Long id);
    boolean deleteById(Long id);
    List<Descuento> findAll();
}
