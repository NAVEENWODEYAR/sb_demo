package com.pivotal.dto;
/*
 * @author Naveen K Wodeyar
 * @date 23/06/2024
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Objects;

import javax.validation.constraints.*;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class EmployeeDto {

    public interface Create{};

    public interface Update{};

    private Long empId;

    @NotBlank(groups = {Create.class,Update.class},message = "Employee name can't be empty,Please enter the employee name")
    private String empName;

    @NotBlank(groups = {Create.class,Update.class},message = "Employee mail can't be empty,Please enter the employee mail")
    @Pattern(groups = {Create.class, Update.class}, regexp = ".+@.+\\..+", message = "Invalid email format")
    private String empEmail;

    @NotBlank(groups = {Create.class,Update.class},message = "Employee phone can't be empty,Please enter the employee name")
    @Pattern(groups = {Create.class, Update.class}, regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String empPhone;

    @NotBlank(groups = {Create.class,Update.class},message = "Employee class can't be empty,Please enter the employee class")
    private String empClass;

    @NotBlank(groups = {Create.class,Update.class},message = "Employee grade can't be empty,Please enter the employee grade")
    private String empGrade;

    public EmployeeDto() {}

	public EmployeeDto(Long empId, @NotBlank(groups = { Create.class,
			Update.class }, message = "Employee name can't be empty,Please enter the employee name") String empName,
			@NotBlank(groups = { Create.class,
					Update.class }, message = "Employee mail can't be empty,Please enter the employee mail") @Pattern(groups = {
							Create.class,
							Update.class }, regexp = ".+@.+\\..+", message = "Invalid email format") String empEmail,
			@NotBlank(groups = { Create.class,
					Update.class }, message = "Employee phone can't be empty,Please enter the employee name") @Pattern(groups = {
							Create.class,
							Update.class }, regexp = "\\d{10}", message = "Phone number must be 10 digits") String empPhone,
			@NotBlank(groups = { Create.class,
					Update.class }, message = "Employee class can't be empty,Please enter the employee class") String empClass,
			@NotBlank(groups = { Create.class,
					Update.class }, message = "Employee grade can't be empty,Please enter the employee grade") String empGrade) {
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
		EmployeeDto other = (EmployeeDto) obj;
		return Objects.equals(empClass, other.empClass) && Objects.equals(empEmail, other.empEmail)
				&& Objects.equals(empGrade, other.empGrade) && Objects.equals(empId, other.empId)
				&& Objects.equals(empName, other.empName) && Objects.equals(empPhone, other.empPhone);
	}

	@Override
	public String toString() {
		return "EmployeeDto [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empPhone="
				+ empPhone + ", empClass=" + empClass + ", empGrade=" + empGrade + "]";
	}
    
    
    
	
}
