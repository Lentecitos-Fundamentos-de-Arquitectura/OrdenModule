package com.lentecitos.design.design.design.domain.persistence;

import com.lentecitos.design.design.design.domain.model.entities.DisenoAnteojos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisenoAnteojosRepository extends JpaRepository<DisenoAnteojos, Integer> {
}
