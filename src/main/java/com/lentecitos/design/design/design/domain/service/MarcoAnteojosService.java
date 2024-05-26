package com.lentecitos.design.design.design.domain.service;

import com.lentecitos.design.design.design.domain.model.entities.MarcoAnteojos;

import java.util.List;

public interface MarcoAnteojosService {
    MarcoAnteojos save (MarcoAnteojos marcoAnteojos);
    MarcoAnteojos findById(Long id);
    MarcoAnteojos update(MarcoAnteojos marcoAnteojos);
    boolean deleteById(Long id);
    List<MarcoAnteojos> findAll();
}
