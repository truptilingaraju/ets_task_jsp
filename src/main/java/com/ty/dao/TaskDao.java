package com.ty.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Task;


public class TaskDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public Task  createTask(Task task) {
		entityTransaction.begin();
		entityManager.persist(task);
		entityTransaction.commit();

	     return task;
	}
	
	public Task updateTask(int id, String status) {
		Task task=entityManager.find(Task.class, id);
		if(task!=null) {
			task.setStatus(status);
			entityTransaction.begin();
			entityManager.merge(task);
			entityTransaction.commit();
			return task;
		}
		else {
			return null;
		}
	}
}
