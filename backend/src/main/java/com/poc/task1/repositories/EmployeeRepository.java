package com.poc.task1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.task1.entites.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDeptId(Long deptId);
}


