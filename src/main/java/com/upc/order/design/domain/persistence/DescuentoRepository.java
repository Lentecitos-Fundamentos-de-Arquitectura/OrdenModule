package com.upc.order.design.domain.persistence;

import com.upc.order.design.domain.model.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoRepository extends JpaRepository<Descuento,Integer> {
}
