package com.project.start.entities.GDS.Oid;

import javax.persistence.*;

@Entity
@Table(name = "oids")
public class Oid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String oid;
    private String iata;
    private Integer type;
    private Integer status;
    private String comment;
    private Integer gdsId;
    private Integer countryId;
    private Integer reasonId;
    private Integer belongId;
    private Integer assignedId;


    public Oid() {
    }

    public Integer getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(Integer assignedId) {
        this.assignedId = assignedId;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Integer getGdsId() {
        return gdsId;
    }

    public void setGdsId(Integer gdsId) {
        this.gdsId = gdsId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getReasonId() {
        return reasonId;
    }

    public void setReasonId(Integer reasonId) {
        this.reasonId = reasonId;
    }

    public Integer getBelongId() {
        return belongId;
    }

    public void setBelongId(Integer belongId) {
        this.belongId = belongId;
    }

    @Override
    public String toString() {
        return "Oid{" +
                "id=" + id +
                ", oid='" + oid + '\'' +
                ", iata='" + iata + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                ", gdsId=" + gdsId +
                ", countryId=" + countryId +
                ", reasonId=" + reasonId +
                ", belongId=" + belongId +
                ", assignedId=" + assignedId +
                '}';
    }
}
