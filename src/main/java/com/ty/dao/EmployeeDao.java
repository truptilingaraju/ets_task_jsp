package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Employee;
import com.ty.dto.Task;

public class EmployeeDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public  boolean getManager() {
		Query query=entityManager.createQuery("select e from Employee e ");
		List<Employee> employees=query.getResultList();
		for (Employee employee : employees) {
			if(employee.getRole().equalsIgnoreCase("manager"))
				return true;
		}
		return false;
	}
	
	public Employee  createManager(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();

	     return employee;
	}
	
	public Employee findEmployee(String email, String password) {
		
		Query query=entityManager.createQuery("select e from Employee e where e.email=?1 and e.password=?2 ");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<Employee> employees=query.getResultList();
		for (Employee employee : employees) {
			return employee;
		}
		return  null;
	}
	
	public Employee  createEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();

	     return employee;
	}
	
	public Employee assignTask(int emp_id, int task_id) {
		Task task=entityManager.find(Task.class, task_id);
		Employee employee =entityManager.find(Employee.class, emp_id);
		
		List<Task> tasks=new ArrayList<>();
		tasks.add(task);
		if(employee!=null) {
			List<Task> tasks1=employee.getTasks();
			tasks1.addAll(tasks);
			employee.setTasks(tasks1);
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
			return employee;
		}
		else {
			return null;
		}
	}
	
	
	public List<Employee> findAllEmployees(){
		
		Query query=entityManager.createQuery("select e from Employee e where e.role=?1");
		query.setParameter(1, "Employee");
		List<Employee> employees=query.getResultList();
		return  employees;
	}
}
