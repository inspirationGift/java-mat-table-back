package com.project.start.repositories;

import com.project.start.entities.GDS.Oid.OidReasons;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OidReasonRepository extends JpaRepository<OidReasons, Integer> {
}
