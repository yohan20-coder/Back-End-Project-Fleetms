package com.kindosongenius.fleetmsv2.parameters.repositories;

import com.kindosongenius.fleetmsv2.parameters.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
