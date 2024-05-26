package com.lentecitos.design.design.design.domain.service;

import com.lentecitos.design.design.design.domain.model.entities.Color;

import java.util.List;

public interface ColorService {
    Color save(Color color);
    Color update(Color color);
    Color findById(Long id);
    List<Color> findAll();
    boolean deleteById(Long id);
}
