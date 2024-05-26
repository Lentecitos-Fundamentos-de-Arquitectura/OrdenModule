package com.lentecitos.design.design.design.domain.service;

import com.lentecitos.design.design.design.domain.model.entities.MaterialFabricaLuna;

import java.util.List;

public interface MaterialFabricaLunaService {
    MaterialFabricaLuna save(MaterialFabricaLuna materialFabricaLuna);
    MaterialFabricaLuna findById(Long id);
    MaterialFabricaLuna update(MaterialFabricaLuna materialFabricaLuna);
    List<MaterialFabricaLuna> findAll();
    boolean deleteById(Long id);

}
