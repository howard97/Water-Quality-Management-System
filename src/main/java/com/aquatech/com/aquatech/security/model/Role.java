package com.aquatech.com.aquatech.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "ROLE_ID", nullable = false)
    private Long id;
    @Basic
    @Column(name = "ROLE_NAME", nullable = false, length = 100)
    private String roleName;
    @Basic@Column(name = "DESCRIPTION", nullable = false, length = 500)
    private String description;
    @Basic@Column(name = "ROLE_TYPE", nullable = false, length = 20)
    private String roleType;
    @Basic@Column(name = "ACTIVE", columnDefinition = "char", nullable = false, length = 1)
    private Boolean active;
    @Basic@Column(name = "CREATED_BY", nullable = false, precision = 0)
    private Long createdBy;
    @Basic@Column(name = "CREATED_DATE", nullable = false)
    private Timestamp createdDate;
    @Basic@Column(name = "MODIFIED_BY", nullable = false, precision = 0)
    private Long modifiedBy;
    @Basic@Column(name = "MODIFIED_DATE", nullable = false)
    private Timestamp modifiedDate;

}
