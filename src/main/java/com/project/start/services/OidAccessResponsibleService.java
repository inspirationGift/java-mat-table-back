package com.project.start.services;

import com.project.start.entities.GDS.OidsAccess.OidResponsible;
import com.project.start.repositories.OidAccessResponsibleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OidAccessResponsibleService {

    private final OidAccessResponsibleRepository repository;

    public OidAccessResponsibleService(OidAccessResponsibleRepository repository) {
        this.repository = repository;
    }

    public List<OidResponsible> getOidResponsible() {
        return this.repository.findAll();
    }
}
