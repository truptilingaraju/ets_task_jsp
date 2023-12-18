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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	TaskDao dao=new TaskDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("task_id"));
		String status=req.getParameter("user_status");
		
		RequestDispatcher dispatcher=null;
		PrintWriter writer=resp.getWriter();
		
		Task task=dao.updateTask(id, status);
		if(task!=null) {
			dispatcher=req.getRequestDispatcher("employeeHome.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			writer.print("<h1>Something went wrong</h1>");
			dispatcher=req.getRequestDispatcher("updateTask.jsp");
			dispatcher.include(req, resp);
		}
		
	}
}
