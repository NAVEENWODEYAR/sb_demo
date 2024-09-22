package com.pivotal.entity;
import java.util.Objects;

/*
 * @author Naveen K Wodeyar
 * @date 23/06/2024
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private String empGrade;
    
    public Employee() {}

	public Employee(Long empId, String empName, String empEmail, String empPhone, String empClass, String empGrade) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empClass = empClass;
		this.empGrade = empGrade;
	}

	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empEmail
	 */
	public String getEmpEmail() {
		return empEmail;
	}

	/**
	 * @param empEmail the empEmail to set
	 */
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	/**
	 * @return the empPhone
	 */
	public String getEmpPhone() {
		return empPhone;
	}

	/**
	 * @param empPhone the empPhone to set
	 */
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	/**
	 * @return the empClass
	 */
	public String getEmpClass() {
		return empClass;
	}

	/**
	 * @param empClass the empClass to set
	 */
	public void setEmpClass(String empClass) {
		this.empClass = empClass;
	}

	/**
	 * @return the empGrade
	 */
	public String getEmpGrade() {
		return empGrade;
	}

	/**
	 * @param empGrade the empGrade to set
	 */
	public void setEmpGrade(String empGrade) {
		this.empGrade = empGrade;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empPhone=" + empPhone
				+ ", empClass=" + empClass + ", empGrade=" + empGrade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(empClass, empEmail, empGrade, empId, empName, empPhone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empClass, other.empClass) && Objects.equals(empEmail, other.empEmail)
				&& Objects.equals(empGrade, other.empGrade) && Objects.equals(empId, other.empId)
				&& Objects.equals(empName, other.empName) && Objects.equals(empPhone, other.empPhone);
	}
    
}
