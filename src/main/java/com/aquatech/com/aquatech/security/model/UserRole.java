package com.aquatech.com.aquatech.security.model;

import javax.persistence.*;
import java.sql.Timestamp;

public class UserRole {
    @Id
    @Column(name = "USER_ID", nullable = false)
    private Long userId;
    @Id
    @Column(name = "ROLE_ID", nullable = false)
    private Long roleId;

    @Basic
    @Column(name = "MODIFIED_BY", nullable = false)
    private Long modifiedBy;
    @Basic
    @Column(name = "CREATED_BY", nullable = false)
    private Long createdBy;
    @Basic
    @Column(name = "CREATED_DATE", nullable = false, columnDefinition = "Timestamp")
    private Timestamp createdDate;
    @Basic
    @Column(name = "MODIFIED_DATE", nullable = false, columnDefinition = "Timestamp")
    private Timestamp modifiedDate;
    @Basic
    @Column(name = "START_DATE", nullable = false, columnDefinition = "Timestamp")
    private Timestamp startDate;
    @Basic
    @Column(name = "END_DATE", nullable = false, columnDefinition = "Timestamp")
    private Timestamp endDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
    private User secUserByUserId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID",  nullable = false, insertable = false, updatable = false)
    private Role RoleByRoleId;

    public UserRole() {
        super();
    }

    public UserRole(Long userId, Long roleId, Long modifiedBy, Long createdBy, Timestamp createdDate, Timestamp modifiedDate, Timestamp startDate, Timestamp endDate, User secUserByUserId, Role roleByRoleId) {
        this.userId = userId;
        this.roleId = roleId;
        this.modifiedBy = modifiedBy;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.secUserByUserId = secUserByUserId;
        RoleByRoleId = roleByRoleId;
    }
}
