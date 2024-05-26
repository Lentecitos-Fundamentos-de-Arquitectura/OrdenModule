package com.upc.order.design.domain.persistence;

import com.upc.order.design.domain.model.AnteojosOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnteojosOrdenRepository extends JpaRepository<AnteojosOrden, Integer> {
}
