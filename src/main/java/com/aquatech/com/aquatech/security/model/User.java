package com.aquatech.com.aquatech.security.model;

import javax.persistence.*;
import java.sql.Timestamp;

public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "ID", nullable = false, precision = 0)
    private Long id;
    @Basic
    @Column(name = "USERNAME", nullable = false, length = 100)
    private String username;
    @Basic@Column(name = "EMAIL_ADDRESS", nullable = false, length = 100)
    private String emailAddress;
    @Basic@Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;
    @Basic@Column(name = "PHONE", length = 100)
    private String phoneNumber;
    @Basic@Column(name = "PASSWORD_CHANGE_DATE", nullable = false)
    private Timestamp passwordChangeDate;
    @Basic@Column(name = "PASSWORD_EXPIRY_DATE", nullable = false)
    private Timestamp passwordExpiryDate;
    @Basic@Column(name = "ACCOUNT_IS_ENABLED", columnDefinition = "char", nullable = false, length = 1)
    private Boolean accountIsEnabled;
    @Basic@Column(name = "ACCOUNT_IS_LOCKED", columnDefinition = "char", nullable = false, length = 1)
    private Boolean accountIsLocked;
    @Basic@Column(name = "FAILED_LOGIN_ATTEMPTS", nullable = false, precision = 0)
    private int failedLoginAttempts;
    @Basic@Column(name = "LAST_LOGIN_ATTEMPT_DATE", nullable = true)
    private Timestamp lastLoginAttemptDate;
    @Basic@Column(name = "CHANGE_PASSWORD_ON_NEXT_LOGIN", columnDefinition = "char", nullable = false, length = 1)
    private Boolean changePasswordOnNextLogin;


    public User() {
        super();
    }

}
