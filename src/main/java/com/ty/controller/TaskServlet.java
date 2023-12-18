package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.TaskDao;
import com.ty.dto.Task;

@WebServlet("/task")
public class TaskServlet extends HttpServlet {

	TaskDao dao=new TaskDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher=null;
		PrintWriter writer=resp.getWriter();
		
		String description=req.getParameter("user_description");
		String Status=req.getParameter("user_status");
		
		Task task=new Task();
		task.setDescription(description);
		task.setStatus(Status);
		
		Task task2=dao.createTask(task);
		
		if(task!=null) {
			dispatcher=req.getRequestDispatcher("managerHome.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			writer.print("<h1>Something went wrong</h1>");
			dispatcher=req.getRequestDispatcher("registerTask.jsp");
			dispatcher.include(req, resp);
		}
	}
}
