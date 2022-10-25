package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public interface EmployeeService {
	public List<Employee>findAll();	
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int id);
}
