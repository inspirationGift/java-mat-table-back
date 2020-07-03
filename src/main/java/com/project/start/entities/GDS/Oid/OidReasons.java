package com.project.start.entities.GDS.Oid;

import javax.persistence.*;

@Entity
@Table(name = "oidReasons")
public class OidReasons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reason;

    public OidReasons() {
    }

    public OidReasons(String reason) {
        this.reason = reason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
