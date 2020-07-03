package com.project.start.repositories;

import com.project.start.entities.GDS.GEO.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
