package com.pivotal.dto;
/*
 * @author Naveen K Wodeyar
 * @date 23/06/2024
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class EmployeeDto {

    private Long empId;

    @NotBlank(groups = {Create.class,Update.class},message = "Employee name can't be empty,Please enter the name")
    private String empName;

    @NotBlank(groups = {Create.class,Update.class},message = "Employee mail can't be empty,Please enter the name")
    @Pattern(groups = {Create.class, Update.class}, regexp = ".+@.+\\..+", message = "Invalid email format")
    private String empEmail;

    @NotBlank(groups = {Create.class,Update.class},message = "Employee phone can't be empty,Please enter the name")
    @Pattern(groups = {Create.class, Update.class}, regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String empPhone;

    @NotBlank(groups = {Create.class,Update.class},message = "Employee class can't be empty,Please enter the name")
    private String empClass;

    @NotBlank(groups = {Create.class,Update.class},message = "Employee grade can't be empty,Please enter the name")
    private Character empGrade;

    public interface Create{};

    public interface Update{};

}
