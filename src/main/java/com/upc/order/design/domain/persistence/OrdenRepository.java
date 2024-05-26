package com.upc.order.design.domain.persistence;

import com.upc.order.design.domain.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden,Integer> {
}
