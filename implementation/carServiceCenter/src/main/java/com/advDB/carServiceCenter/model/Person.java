package com.advDB.carServiceCenter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @Column(name = "ssn", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private Long ssn;

    @Column(name = "first_name")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String firstName;

    @Column(name = "middle_name")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String middleName;

    @Column(name = "last_name")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String lastName;

    @Column(name = "birth_date")
    @JdbcTypeCode(SqlTypes.DATE)
    private String birthDate;

    @ElementCollection
    @Column(name = "phone_no")
    @CollectionTable(name = "phone_NO", joinColumns = @JoinColumn(name = "ssn"))
    private Set<char[]> phone_NO = new LinkedHashSet<>();

    @Email
    @Column(name = "email", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String email;

}