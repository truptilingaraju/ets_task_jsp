package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.EmployeeDao;
import com.ty.dto.Employee;

@WebServlet("/assign-task")
public class AssignTask extends HttpServlet {

	EmployeeDao dao = new EmployeeDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher=null;
		PrintWriter writer=resp.getWriter();
		
	   int emp_id=Integer.parseInt(req.getParameter("user_emp_id"));
	   int task_id=Integer.parseInt(req.getParameter("user_task_id"));
	   
	   Employee employee=dao.assignTask(emp_id, task_id);
	   if(employee!=null) {
		   dispatcher=req.getRequestDispatcher("managerHome.jsp");
			dispatcher.forward(req, resp);
	   }
	   else {
				writer.print("<h1>Something went wrong</h1>");
				dispatcher=req.getRequestDispatcher("assignTask.jsp");
				dispatcher.include(req, resp);
	   }
	}
}
