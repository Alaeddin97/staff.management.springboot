package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOhibernateEmpl implements EmployeeDAO {

	// declare the field EntityManager
	private EntityManager entityManager; // like session factory?

	// inject entity manager with constructor injection so that we can use it
	@Autowired
	public EmployeeDAOhibernateEmpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create a query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		// execute the query and get the result
		List<Employee> employees = query.getResultList();
		// return the result
		return employees;
	}

	@Override
	public Employee findById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create a query
		Query<Employee> query = currentSession.createQuery("from Employee where id=:id", Employee.class);
		// set id
		query.setParameter("id", id);
		// execute the query and get the result
		Employee employee = query.getSingleResult();
		// return the result
		return employee;
	}

	@Override
	public void save(Employee employee) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("delete from Employee e where e.id=:id");
		// set id
		query.setParameter("id", id);
		// delete
		query.executeUpdate();

	}

}
