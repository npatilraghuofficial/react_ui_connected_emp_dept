package com.poc.task1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.task1.payloads.EmployeeDto;
import com.poc.task1.service.EmployeeService;


// import jakarta.validation.Valid;


@RestController
@RequestMapping("api/employee")
@CacheConfig(cacheNames = "Employees")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping("/")
    @Cacheable()
    public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto){
      EmployeeDto creatEmployeeDto = this.employeeService.createEmployee(employeeDto);
      System.out.println("Employee created successfully");
      return new ResponseEntity<>(creatEmployeeDto, HttpStatus.CREATED); 
    }

    @PutMapping("/{empId}")
    @CachePut(key="#empId")
    public ResponseEntity<EmployeeDto>updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable("empId") Long empId){
      EmployeeDto updateEmployeeDto = this.employeeService.updateEmployee(employeeDto,empId);
      System.out.println("Employee updated successfully");
      return new ResponseEntity<>(updateEmployeeDto, HttpStatus.OK); 
    }

    @DeleteMapping("/{empId}")
    @CacheEvict(key="#empId")
    public void deleteEmployeeById(@PathVariable("empId") Long empId){
      this.employeeService.deleteEmployeeById(empId);
      System.out.println("Employee deleted successfully");
      
    }

    @GetMapping("/{empId}")
    @Cacheable(key = "#empId")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("empId") Long empId){
      EmployeeDto employeeDto = this.employeeService.getEmployeeById(empId);
      System.out.println("Employee get successfully");
      return new ResponseEntity<>(employeeDto, HttpStatus.OK); 
    }

    @GetMapping("/all")
    // @Cacheable
    public ResponseEntity<List<EmployeeDto>>getAllEmployees(){
      return ResponseEntity.ok(this.employeeService.getAllEmployee());

    }

    @GetMapping("/dept/{deptId}")
    @Cacheable(key="#deptId")
    public ResponseEntity<List<EmployeeDto>> getEmployeeByDeptId(@PathVariable("deptId") Long deptId) {
        List<EmployeeDto> employeeDtoList = this.employeeService.getEmployeeByDeptId(deptId);
    
        System.out.println("Employee get successfully"); // Assuming this is for debugging purposes
    
        return ResponseEntity.ok(employeeDtoList);
    }
    






}
