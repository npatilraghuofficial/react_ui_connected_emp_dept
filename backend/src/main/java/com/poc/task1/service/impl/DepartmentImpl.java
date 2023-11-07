package com.poc.task1.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.poc.task1.entites.Department;
import com.poc.task1.exceptions.ResourceNotFoundException;
import com.poc.task1.payloads.DepartmentDto;
import com.poc.task1.repositories.DepartmentRepository;
import com.poc.task1.service.DepartmentService;

@Service
public class DepartmentImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
public DepartmentDto createDepartment(DepartmentDto DepartmentDto)  {
    Department Department = dtoToDepartment(DepartmentDto);
    Department savedDepartment = departmentRepository.save(Department);
    return DepartmentToDto(savedDepartment);
}



@Override
public DepartmentDto updateDepartment(DepartmentDto DepartmentDto, Long deptId) {
    Department Department = this.departmentRepository.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Deptartment", "id", deptId));
    Department.setDeptName(DepartmentDto.getDeptName());
    
    Department updatedDepartment = this.departmentRepository.save(Department);
    DepartmentDto updatedDepartmentDto = this.DepartmentToDto(updatedDepartment);
    System.out.println("Department updated successfully");
    return updatedDepartmentDto;
}



	@Override
			public DepartmentDto getDepartmentById(Long deptId) {
		Department Department = this.departmentRepository.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("user", "id", deptId));
			DepartmentDto DepartmentDto = this.DepartmentToDto(Department);
			System.out.println("Department get successfully"+DepartmentDto.getId());
			return DepartmentDto;
		
	}


	@Override
	public void deleteDepartmentById(Long deptId) {
		Department Department = this.departmentRepository.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("user", "id", deptId));

		this.departmentRepository.delete(Department);
		System.out.println("Department deleted successfully");
		
	}


	@Override
	public List<DepartmentDto> getAllDepartment() {
		List<Department> Departments = this.departmentRepository.findAll();
		List <DepartmentDto>DepartmentDtos= Departments.stream().map(Department->this.DepartmentToDto(Department)).collect(Collectors.toList());
		
		System.out.println("Department get successfully");
		return DepartmentDtos;		
	}



// 	@Override
// 	// @CachePut(value="Departments",key="#deptId")
//      public List<DepartmentDto> getDepartmentByDeptId(Long deptId) {
//     List<Department> Departments = this.departmentRepository.findByDeptId(deptId);
    
//     // Create a list to hold the DepartmentDto objects
//     List<DepartmentDto> DepartmentDtos = new ArrayList<>();

//     for (Department Department : Departments) {
//         // Convert each Department to DepartmentDto
//         DepartmentDto DepartmentDto = DepartmentToDto(Department);
//         DepartmentDtos.add(DepartmentDto);
//     }
    
//     return DepartmentDtos;
// }

//conversion

	
	private Department dtoToDepartment(DepartmentDto DepartmentDto){
		Department Department = this.modelMapper.map(DepartmentDto, Department.class);
		return Department;
		
	}

	private DepartmentDto DepartmentToDto(Department Department){
		DepartmentDto DepartmentDto = this.modelMapper.map(Department, DepartmentDto.class);
		return DepartmentDto;
		
	}



	

}
