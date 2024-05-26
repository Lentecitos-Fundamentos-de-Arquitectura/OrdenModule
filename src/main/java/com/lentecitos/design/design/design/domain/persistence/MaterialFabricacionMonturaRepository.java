package com.lentecitos.design.design.design.domain.persistence;

import com.lentecitos.design.design.design.domain.model.entities.MaterialFabricacionMontura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialFabricacionMonturaRepository extends JpaRepository<MaterialFabricacionMontura, Integer> {
}
