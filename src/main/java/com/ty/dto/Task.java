package com.ty.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private String status;
	
	
	public Task(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(int id, String description, String status) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", status=" + status + "]";
	}
	
	
}
