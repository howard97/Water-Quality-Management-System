package com.aquatech.com.aquatech.usermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompanyApplication {
    @Id
    @SequenceGenerator(name = "company_sequence", sequenceName = "company_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_sequence")
    @Column(name = "ID", nullable = false, precision = 0)
    private Long id;
    @Basic@Column(name = "TPIN", nullable = false, length = 20)
    private String tpin;
    @Basic@Column(name = "COMAPNY_NAME", nullable = false, length = 100)
    private String companyName;
    @Basic@Column(name = "COMAPNY_ADDRESS", nullable = false, length = 100)
    private String companyAddress;
    @Basic@Column(name = "CONTACT", nullable = false, length = 20)
    private String contact;
    @Basic@Column(name = "EMAIL", nullable = false, length = 100)
    private String email;
    @Basic@Column(name = "TRADING_NAME", nullable = false, length = 30)
    private String tradingNumber;
    @Basic@Column(name = "REASON", nullable = false, length = 400)
    private String reason;
    @Basic@Column(name = "CREATED_BY", nullable = false)
    private Long createdBy;
    @Basic@Column(name = "CREATED_DATE", nullable = false, precision = 0)
    private Timestamp createdDate;
    @Basic@Column(name = "MODIFIED_BY", nullable = false, precision = 0)
    private Long modifiedBy;
    @Basic@Column(name = "MODIFIED_DATE", nullable = false)
    private Timestamp modifiedDate;
}
