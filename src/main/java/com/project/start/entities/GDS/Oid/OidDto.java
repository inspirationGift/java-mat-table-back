package com.project.start.entities.GDS.Oid;

public class OidDto {

    private String oid;
    private String iata;
    private Integer status;
    private String statusName;
    private Integer type;
    private String comment;
    private Integer country;
    private String countryCode;
    private String countryName;
    private Integer gds;
    private String gdsCode;
    private String gdsName;
    private Integer reasonId;
    private String reason;
    private Integer belongId;
    private String belong;
    private Integer assignId;
    private String assign;
    private String action;

    public OidDto(String oid, String iata, Integer status, String statusName, Integer type, String comment,
                  Integer country, String countryCode, String countryName, Integer gds,
                  String gdsCode, String gdsName, Integer reasonId, String reason, Integer belongId, String belong,
                  Integer assignId, String assign, String action) {
        this.oid = oid;
        this.iata = iata;
        this.status = status;
        this.statusName = statusName;
        this.type = type;
        this.comment = comment;
        this.country = country;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.gds = gds;
        this.gdsCode = gdsCode;
        this.gdsName = gdsName;
        this.reasonId = reasonId;
        this.reason = reason;
        this.belongId = belongId;
        this.belong = belong;
        this.assignId = assignId;
        this.assign = assign;
        this.action = action;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getGds() {
        return gds;
    }

    public void setGds(Integer gds) {
        this.gds = gds;
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

    public Integer getAssignId() {
        return assignId;
    }

    public void setAssignId(Integer assignId) {
        this.assignId = assignId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "OidDto{" +
                "oid='" + oid + '\'' +
                ", iata='" + iata + '\'' +
                ", status=" + status +
                ", statusName='" + statusName + '\'' +
                ", type=" + type +
                ", comment='" + comment + '\'' +
                ", country=" + country +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", gds=" + gds +
                ", gdsCode='" + gdsCode + '\'' +
                ", gdsName='" + gdsName + '\'' +
                ", reasonId=" + reasonId +
                ", reason='" + reason + '\'' +
                ", belongId=" + belongId +
                ", belong='" + belong + '\'' +
                ", assignId=" + assignId +
                ", assign='" + assign + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
