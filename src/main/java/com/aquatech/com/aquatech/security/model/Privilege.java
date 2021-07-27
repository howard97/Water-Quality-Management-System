package com.aquatech.com.aquatech.security.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@ToString
@Data
@Entity
public class Privilege {
    @Id
    @Column(name = "PRIVILEGE_ID", nullable = false, length = 100)
    private String privilegeId;

    @Basic
    @Column(name = "PRIVILEGE_NAME", nullable = false, length = 100)
    private String privilegeName;

    @Basic
    @Column(name = "MODULE_ID", nullable = false)
    private Long moduleId;

    @Basic
    @Column(name = "CREATED_BY", nullable = false)
    private Long createdBy;

    @Basic
    @Column(name = "CREATED_DATE", nullable = false)
    private Timestamp createdDate;

    @Basic
    @Column(name = "MODIFIED_BY", nullable = false)
    private Long modifiedBy;

    @Basic
    @Column(name = "MODIFIED_DATE", nullable = false)
    private Timestamp modifiedDate;

    @Basic
    @Column(name = "DISPLAY", length = 1)
    private String display;

    public Privilege() {
        super();
    }

    public Privilege(String privilegeId, String privilegeName, Long moduleId, Long createdBy, Timestamp createdDate, Long modifiedBy, Timestamp modifiedDate, String display) {
        this.privilegeId = privilegeId;
        this.privilegeName = privilegeName;
        this.moduleId = moduleId;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.display = display;
    }
}
