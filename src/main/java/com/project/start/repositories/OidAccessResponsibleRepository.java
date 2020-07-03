package com.project.start.repositories;

import com.project.start.entities.GDS.OidsAccess.OidResponsible;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OidAccessResponsibleRepository extends JpaRepository<OidResponsible, Integer> {
}
