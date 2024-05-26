package com.upc.order.design.domain.service;

import com.upc.order.design.domain.model.AnteojosOrden;

import java.util.List;

public interface AnteojosOrdenService {
    AnteojosOrden save(AnteojosOrden anteojosOrden);
    AnteojosOrden update(AnteojosOrden anteojosOrden);
    AnteojosOrden findById(Long id);
    boolean deleteById(Long id);
    List<AnteojosOrden> findAll();
}
