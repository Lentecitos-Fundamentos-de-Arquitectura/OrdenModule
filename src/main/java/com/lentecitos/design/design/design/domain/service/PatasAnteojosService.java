package com.lentecitos.design.design.design.domain.service;

import com.lentecitos.design.design.design.domain.model.entities.PatasAnteojos;

import java.util.List;

public interface PatasAnteojosService {
    PatasAnteojos save (PatasAnteojos patasAnteojos);
    PatasAnteojos findById(Long id);
    List<PatasAnteojos> findAll();
    boolean deleteById(Long id);
    PatasAnteojos update(PatasAnteojos patasAnteojos);
}
