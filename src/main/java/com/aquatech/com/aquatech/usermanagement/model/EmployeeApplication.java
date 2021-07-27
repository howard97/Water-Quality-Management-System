package com.aquatech.com.aquatech.usermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
public class EmployeeApplication {
    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    @Column(name = "ID", nullable = false, precision = 0)
    private Long id;
    @Basic@Column(name = "USERNAME", nullable = false, length = 20)
    private String username;
    @Basic@Column(name = "FIRST_NAME", nullable = false, length = 20)
    private String firstName;
    @Basic@Column(name = "OTHER_NAME", nullable = false, length = 20)
    private String otherName;
    @Basic@Column(name = "LAST_NAME", nullable = false, length = 20)
    private String lastName;
    @Basic@Column(name = "EMAIL", nullable = false, length = 20)
    private String email;
    @Basic@Column(name = "DESIGNATION", nullable = false, length = 20)
    private String designation;
    @Basic@Column(name = "MAN_NUMBER", nullable = false, length = 20)
    private String manNumber;
    @Basic@Column(name = "PHONE_NUMBER", nullable = false, length = 20)
    private String phoneNumber;
    @Basic@Column(name = "NATIONAL_ID", nullable = false, length = 20)
    private String nationId;
    @Basic@Column(name = "GENDER", nullable = false, length = 20)
    private String gender;
}
