package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.EmployeeDao;
import com.ty.dto.Employee;
import com.ty.dto.Task;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

	EmployeeDao dao=new EmployeeDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=null;
		PrintWriter writer=resp.getWriter();
		
		String name=req.getParameter("user_name");
		String email=req.getParameter("user_email");
		String password=req.getParameter("user_password");
		String role=req.getParameter("user_role");
		int salary=Integer.parseInt(req.getParameter("user_salary"));
		
		List<Task> tasks=new ArrayList<>();
		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setRole(role);
		employee.setSalaray(salary);
		employee.setTasks(tasks);
		
		Employee employee2=dao.createEmployee(employee);
		if(employee2!=null) {
			dispatcher=req.getRequestDispatcher("managerHome.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			writer.print("<h1>Something went wrong</h1>");
			dispatcher=req.getRequestDispatcher("registerEmployee.jsp");
			dispatcher.include(req, resp);
		}
	}
}
