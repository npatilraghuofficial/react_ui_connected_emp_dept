package com.poc.task1.service;


import java.util.List;

import com.poc.task1.payloads.EmployeeDto;


public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto,Long empId);
    EmployeeDto getEmployeeById(Long id);
    void deleteEmployeeById(Long empId);

    List<EmployeeDto> getAllEmployee();

    //get all employee

    //get emp details by dept id
    List<EmployeeDto> getEmployeeByDeptId(Long deptId);    
}
