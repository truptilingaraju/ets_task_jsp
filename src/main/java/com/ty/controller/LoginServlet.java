package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.EmployeeDao;
import com.ty.dto.Employee;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	EmployeeDao dao= new EmployeeDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("user_email");
		String password=req.getParameter("user_password");
		
		HttpSession session =req.getSession();
		RequestDispatcher dispatcher=null;
		PrintWriter writer=resp.getWriter();
		
		Employee employee=dao.findEmployee(email, password);
		
		
		if(employee!=null && employee.getRole().equalsIgnoreCase("Manager")) {
			session.setAttribute("my_employee", employee);
			dispatcher=req.getRequestDispatcher("managerHome.jsp");
			dispatcher.forward(req, resp);
		}
		
		else if (employee!=null && employee.getRole().equalsIgnoreCase("employee")) {
			session.setAttribute("my_employee", employee);
			dispatcher=req.getRequestDispatcher("employeeHome.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			writer.print("<h1>invalid email or password</h1>");
			dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}
}
