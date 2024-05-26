package com.upc.order.design.domain.service;

import com.upc.order.design.domain.model.EstadoOrden;

import java.util.List;

public interface EstadoOrdenService {

    EstadoOrden save(EstadoOrden estadoOrden);
    EstadoOrden update(EstadoOrden estadoOrden);
    EstadoOrden findById(Long id);
    boolean deleteById(Long id);
    List<EstadoOrden> findAll();
}
