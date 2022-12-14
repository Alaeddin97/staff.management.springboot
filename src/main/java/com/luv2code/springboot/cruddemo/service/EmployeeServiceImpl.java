package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
@Repository
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDAO employeeDAO;

	@Autowired
	EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
		employeeDAO=theEmployeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}
	@Override
	@Transactional
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}
	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}
	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDAO.deleteEmployee(id);

	}

}
