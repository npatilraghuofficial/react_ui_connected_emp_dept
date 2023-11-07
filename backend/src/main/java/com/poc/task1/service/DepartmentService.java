package com.poc.task1.service;

import java.util.List;

import com.poc.task1.payloads.DepartmentDto;

public interface DepartmentService {
  

     DepartmentDto createDepartment(DepartmentDto DepartmentDto);
    DepartmentDto updateDepartment(DepartmentDto DepartmentDto,Long empId);
    DepartmentDto getDepartmentById(Long id);
    void deleteDepartmentById(Long empId);

    List<DepartmentDto> getAllDepartment();
    

   
    

}
