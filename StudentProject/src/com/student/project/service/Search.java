package com.student.project.service;

import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;

import com.student.project.dao.DataRetrive;  
  
public class Search extends HttpServlet {  
  
		public void doGet(HttpServletRequest request, HttpServletResponse response)  
			            throws ServletException, IOException {  
			  
			response.setContentType("text/html");  
			PrintWriter out = response.getWriter();
			DataRetrive dr=new DataRetrive();
			ResultSet rs= dr.getData();   //ps.executeQuery();  
			if(null!=rs) {	
				try{  
					/*Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "devi", "devi");
					Statement st = con.createStatement();
					PreparedStatement ps=con.prepareStatement("select * from studentproject ");  */
				              
				out.print("<table width=50% border=1>");  
				out.print("<caption>Student List:</caption>");  
				
				/* Printing column names */  
				ResultSetMetaData rsmd=rs.getMetaData();  
				int total=rsmd.getColumnCount();  
				out.print("<tr>");  
				for(int i=1;i<=total;i++)  
				{  
				out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
				}  
				  
				out.print("</tr>");  
				              
				/* Printing result */  
				  
				while(rs.next())  
				{  
					out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+" </td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td></tr>");
				//out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+" </td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");  
				                  
				}  
				  
				out.print("</table>");  
				              
				}catch (Exception e2) {e2.printStackTrace();}  
				          
				finally{out.close();}  
		}else {
			out.print("<h1> : Sorry this feture is not ready because of devi person is on leave  Please try later<h1>");
		}	
	}		
 }  