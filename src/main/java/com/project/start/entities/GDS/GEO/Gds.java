package com.project.start.entities.GDS.GEO;


import javax.persistence.*;

@Entity
@Table(name = "gdsList")
public class Gds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String gdsCode;
    private String gdsName;


    public Gds() {
    }

    public Gds(Integer id, String code, String name) {
        this.id = id;
        this.gdsCode = code;
        this.gdsName = name;
    }

    public Gds(String code, String name) {
        this.gdsCode = code;
        this.gdsName = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGdsCode() {
        return gdsCode;
    }

    public void setGdsCode(String gdsCode) {
        this.gdsCode = gdsCode;
    }

    public String getGdsName() {
        return gdsName;
    }

    public void setGdsName(String gdsName) {
        this.gdsName = gdsName;
    }


}
