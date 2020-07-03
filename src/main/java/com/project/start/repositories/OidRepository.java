package com.project.start.repositories;

import com.project.start.entities.GDS.Oid.Oid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OidRepository extends JpaRepository<Oid, Long> {
    Page<Oid> findAll(Pageable pageable);

    Oid findOidByOidAndGdsId(String oid, Integer gdsId);

}

