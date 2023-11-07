package com.poc.task1.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {

	    private Long id;	   
		@NotNull
	    private String empName;
		@NotNull
	    private double empSal;

		@NotNull
	    private String empAddress;
		@Email
	    private String empEmail;
		@NotNull
	    private Long deptId;
	   
	
}
