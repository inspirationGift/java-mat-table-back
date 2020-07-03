package com.project.start.entities.GDS.OidsAccess;


import javax.persistence.*;

@Entity
@Table(name = "gds_accsess")
public class OidAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "access")
    private String terminal;
    @Column(name = "status")
    private Integer statusActive;
    @Column(name = "refresh")
    private String rDate;
    private Integer oid_id;
    private Integer responsible_id;

    public OidAccess() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String access) {
        this.terminal = access;
    }

    public Integer getStatusActive() {
        return statusActive;
    }

    public void setStatusActive(Integer statusActive) {
        this.statusActive = statusActive;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public Integer getOid_id() {
        return oid_id;
    }

    public void setOid_id(Integer oid_id) {
        this.oid_id = oid_id;
    }

    public Integer getResponsible_id() {
        return responsible_id;
    }

    public void setResponsible_id(Integer responsible_id) {
        this.responsible_id = responsible_id;
    }
}
