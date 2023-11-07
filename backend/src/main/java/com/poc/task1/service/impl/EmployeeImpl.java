package com.poc.task1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.poc.task1.entites.Employee;
import com.poc.task1.exceptions.ResourceNotFoundException;
import com.poc.task1.payloads.EmployeeDto;
import com.poc.task1.repositories.EmployeeRepository;
import com.poc.task1.service.EmployeeService;

@Service
public class EmployeeImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override

public EmployeeDto createEmployee(EmployeeDto employeeDto)  {
    Employee employee = dtoToEmployee(employeeDto);
    Employee savedEmployee = employeeRepository.save(employee);
    return employeeToDto(savedEmployee);
}



@Override

public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long empId) {
    Employee employee = this.employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("user", "id", empId));
    employee.setEmpName(employeeDto.getEmpName());
    employee.setEmpSal(employeeDto.getEmpSal());
    employee.setEmpAddress(employeeDto.getEmpAddress());
    employee.setEmpEmail(employeeDto.getEmpEmail());
    employee.setDeptId(employeeDto.getDeptId());
    Employee updatedEmployee = this.employeeRepository.save(employee);
    EmployeeDto updatedEmployeeDto = this.employeeToDto(updatedEmployee);
    System.out.println("Employee updated successfully");
    return updatedEmployeeDto;
}



	@Override
	
		public EmployeeDto getEmployeeById(Long empId) {
		Employee employee = this.employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("user", "id", empId));
			EmployeeDto employeeDto = this.employeeToDto(employee);
			System.out.println("Employee get successfully"+employeeDto.getId());
			return employeeDto;
		
	}


	@Override
	public void deleteEmployeeById(Long empId) {
		Employee employee = this.employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("user", "id", empId));

		this.employeeRepository.delete(employee);
		System.out.println("Employee deleted successfully");
		
	}


	@Override
// @CachePut(value = "Employees")
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees = this.employeeRepository.findAll();
		List <EmployeeDto>employeeDtos= employees.stream().map(employee->this.employeeToDto(employee)).collect(Collectors.toList());
		
		System.out.println("Employee get successfully");
		return employeeDtos;		
	}



	@Override
	// @CachePut(value="Employees",key="#deptId")
     public List<EmployeeDto> getEmployeeByDeptId(Long deptId) {
    List<Employee> employees = this.employeeRepository.findByDeptId(deptId);
    
    // Create a list to hold the EmployeeDto objects
    List<EmployeeDto> employeeDtos = new ArrayList<>();

    for (Employee employee : employees) {
        // Convert each Employee to EmployeeDto
        EmployeeDto employeeDto = employeeToDto(employee);
        employeeDtos.add(employeeDto);
    }
    
    return employeeDtos;
}

//conversion

	
	private Employee dtoToEmployee(EmployeeDto employeeDto){
		Employee employee = this.modelMapper.map(employeeDto, Employee.class);
		return employee;
		
	}

	private EmployeeDto employeeToDto(Employee employee){
		EmployeeDto employeeDto = this.modelMapper.map(employee, EmployeeDto.class);
		return employeeDto;
		
	}

}
