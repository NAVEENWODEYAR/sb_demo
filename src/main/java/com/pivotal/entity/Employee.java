package com.pivotal.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "SB_EMPLOYEE")
public class Employee extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID", nullable = false,unique = true)
    private Long empId;

    @Column(name = "EMP_NAME", nullable = false)
    private String empName;

    @Column(name = "EMP_MAIL", nullable = false,unique = true)
    private String empEmail;

    @Column(name = "EMP_PHONE", nullable = false,unique = true)
    private String empPhone;

    @Column(name = "EMP_CLASS", nullable = false)
    private String empClass;

    @Column(name = "EMP_GRADE", nullable = false)
    private Character empGrade;
}
