package com.project.start.entities.GDS.GEO;


import javax.persistence.*;

@Entity
@Table(name = "countriesList")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "CODE")
    private String countryCode;
    @Column(name = "COUNTRY")
    private String countryName;
    @Column(name = "REGION_A")
    private String regionA;
    @Column(name = "REGION_B")
    private String regionB;
    @Column(name = "CONTINENT")
    private String continent;

    public Country() {
    }

    public Country(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }


    public String getRegionA() {
        return regionA;
    }

    public void setRegionA(String regionA) {
        this.regionA = regionA;
    }

    public String getRegionB() {
        return regionB;
    }

    public void setRegionB(String regionB) {
        this.regionB = regionB;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


}
