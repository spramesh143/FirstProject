package com.student.project.dao;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class dataStore {

	public boolean DBstore(String name, String email, String psd, String phnumber) {
		boolean status=false;
		System.out.println("Student Name : " + name);
		System.out.println("email : " + email);
		System.out.println("psword : " + psd);
		System.out.println("ph : " + phnumber);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "devi", "devi");
			Statement st = con.createStatement();
			String query = "insert into studentproject (name,EMAIL,PASSWORD,PHONENUMBER) values(' " + name + "' ,' " + email
					+ " ' , ' " + psd + " '," + phnumber + ")";
			System.out.println(query);
			int r = st.executeUpdate(query);
			con.commit();
			status=true;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
public static void main(String[] args) {
	dataStore dr=new dataStore();
	dr.DBstore("", "email", "psd", "phnumber");
}
	
	
}
