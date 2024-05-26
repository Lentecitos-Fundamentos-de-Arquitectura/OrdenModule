package com.lentecitos.design.design.design.domain.persistence;

import com.lentecitos.design.design.design.domain.model.entities.PatasAnteojos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatasAnteojosRepository extends JpaRepository<PatasAnteojos, Integer> {
}
