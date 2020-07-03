package com.project.start.entities.GDS.OidsAccess.TableView;

public class AccessView {
    private String terminal;
    private Integer statusActive;
    private String statusName;
    private String rDate;
    private String oid;
    private String gdsCode;
    private String gdsName;
    private String countryCode;
    private String countryName;
    private String responsible;
    private String department;
    private String description;


    public AccessView() {
    }

    public AccessView(String terminal, Integer statusActive, String statusName, String rDate, String oid, String gdsCode,
                      String gdsName, String countryCode, String countryName, String responsible, String department,
                      String description) {
        this.terminal = terminal;
        this.statusActive = statusActive;
        this.statusName = statusName;
        this.rDate = rDate;
        this.oid = oid;
        this.gdsCode = gdsCode;
        this.gdsName = gdsName;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.responsible = responsible;
        this.department = department;
        this.description = description;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
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

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
