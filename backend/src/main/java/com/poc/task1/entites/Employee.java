package com.poc.task1.entites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empName;
    private double empSal;
    private String empAddress;
    private String empEmail;
    private Long deptId;
   
    @ManyToOne(cascade = {CascadeType.REMOVE})
    private Department department;
    
}
