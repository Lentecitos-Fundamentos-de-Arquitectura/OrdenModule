package com.lentecitos.design.design.design.domain.persistence;

import com.lentecitos.design.design.design.domain.model.entities.MarcoAnteojos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcoAnteojosRepository extends JpaRepository<MarcoAnteojos, Integer> {
}
