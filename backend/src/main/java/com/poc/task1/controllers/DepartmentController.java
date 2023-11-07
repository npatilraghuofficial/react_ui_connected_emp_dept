package com.poc.task1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.task1.payloads.ApiResponse;
import com.poc.task1.payloads.DepartmentDto;
import com.poc.task1.service.DepartmentService;
 

// import jakarta.validation.Valid;


@RestController
@RequestMapping("api/department")
@CacheConfig(cacheNames = "Departments")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;
    
    @PostMapping("/")
    @Cacheable()
    public ResponseEntity<DepartmentDto>createDepartment(@RequestBody DepartmentDto DepartmentDto){
      DepartmentDto creatDepartmentDto = this.departmentService.createDepartment(DepartmentDto);
      System.out.println("department created successfully");
      return new ResponseEntity<>(creatDepartmentDto, HttpStatus.CREATED); 
    }

    @PutMapping("/{deptId}")
    @CachePut(key="#deptId")
    public ResponseEntity<DepartmentDto>updateDepartment(@RequestBody DepartmentDto DepartmentDto,@PathVariable("deptId") Long deptId){
      DepartmentDto updateDepartmentDto = this.departmentService.updateDepartment(DepartmentDto,deptId);
      System.out.println("department updated successfully");
      return new ResponseEntity<>(updateDepartmentDto, HttpStatus.OK); 
    }

    @DeleteMapping("/{deptId}")
    @CacheEvict(key="#deptId")
    public ResponseEntity<ApiResponse> deletedepartmentById(@PathVariable("deptId") Long deptId){
      this.departmentService.deleteDepartmentById(deptId);
      System.out.println("department deleted successfully");
      return new ResponseEntity<ApiResponse>(new ApiResponse("department deleted successfully",true), HttpStatus.OK);

      
    }

    @GetMapping("/{deptId}")
    @Cacheable(key = "#deptId")
    public ResponseEntity<DepartmentDto> getdepartmentById(@PathVariable("deptId") Long deptId){
      DepartmentDto DepartmentDto = this.departmentService.getDepartmentById(deptId);
      System.out.println("department get successfully");
      return new ResponseEntity<>(DepartmentDto, HttpStatus.OK); 
    }

    @GetMapping("/all")
    // @Cacheable()
    public ResponseEntity<List<DepartmentDto>>getAlldepartments(){
      return ResponseEntity.ok(this.departmentService.getAllDepartment());

    }

   
    
   

    
}







