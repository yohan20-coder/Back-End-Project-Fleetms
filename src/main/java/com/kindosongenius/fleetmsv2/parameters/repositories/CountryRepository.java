package com.kindosongenius.fleetmsv2.parameters.repositories;


import com.kindosongenius.fleetmsv2.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
