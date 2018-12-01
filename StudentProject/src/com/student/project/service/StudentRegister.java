package com.student.project.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.project.dao.dataStore;

public class StudentRegister extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {
		String studentName = request.getParameter("name");
		String email = request.getParameter("email");
		String psword = request.getParameter("psw");
		String ph = request.getParameter("Phone number");

		dataStore db = new dataStore();
		boolean status = db.DBstore(studentName, email, psword, ph);

		if (status) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("You are successfully registered...");
		} else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<h1>" + studentName + " : Sorry not  registered Please try later<h1>");
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
	}
	
	

}
