package com.lentecitos.design.design.design.domain.persistence;

import com.lentecitos.design.design.design.domain.model.entities.MaterialFabricaLuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialFabricaLunaRepository extends JpaRepository<MaterialFabricaLuna, Integer> {
}
