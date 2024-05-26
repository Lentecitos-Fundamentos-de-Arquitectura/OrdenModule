package com.upc.order.design.domain.persistence;

import com.upc.order.design.domain.model.EstadoOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoOrdenRepository extends JpaRepository<EstadoOrden, Integer> {
}
