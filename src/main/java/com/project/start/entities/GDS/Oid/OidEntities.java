package com.project.start.entities.GDS.Oid;

import javax.persistence.*;

@Entity
@Table(name = "oidEntities")
public class OidEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String entity;


    public OidEntities() {
    }

    public OidEntities(String entity) {
        this.entity = entity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }
}

