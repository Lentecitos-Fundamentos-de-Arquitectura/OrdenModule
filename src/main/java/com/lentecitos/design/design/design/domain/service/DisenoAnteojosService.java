package com.lentecitos.design.design.design.domain.service;

import com.lentecitos.design.design.design.domain.model.entities.DisenoAnteojos;

import java.util.List;

public interface DisenoAnteojosService {
    DisenoAnteojos save(DisenoAnteojos disenoAnteojos);
    DisenoAnteojos findById(Long id);
    DisenoAnteojos update(DisenoAnteojos disenoAnteojos);
    boolean deleteById(Long id);
    List<DisenoAnteojos> findAll();
}
