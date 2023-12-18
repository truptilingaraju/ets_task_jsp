package com.ty.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.EmployeeDao;
import com.ty.dto.Employee;

@WebServlet("/manager")
public class ManagerServlet extends HttpServlet {

	EmployeeDao dao=new EmployeeDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher=null;
		
		String name=req.getParameter("user_name");
		String email=req.getParameter("user_email");
		String password=req.getParameter("user_password");
		String role=req.getParameter("user_role");
		int salary=Integer.parseInt(req.getParameter("user_salary"));
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setRole(role);
		employee.setSalaray(salary);
		
		Employee employee2=dao.createManager(employee);
		if(employee2!=null) {
			dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
