package com.lentecitos.design.design.design.domain.service;

import com.lentecitos.design.design.design.domain.model.entities.MaterialFabricacionMontura;

import java.util.List;

public interface MaterialFabricacionMonturaService {
    MaterialFabricacionMontura save(MaterialFabricacionMontura materialFabricacionMontura);
    MaterialFabricacionMontura findById(Long id);
    MaterialFabricacionMontura update(MaterialFabricacionMontura materialFabricacionMontura);
    boolean deleteById(Long id);
    List<MaterialFabricacionMontura> findAll();
}
