package com.poc.task1.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.task1.entites.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // List<Department> findByDeptId(Long deptId);
}


