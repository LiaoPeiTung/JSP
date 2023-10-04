package com.lcpan.m15;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

import com.lcpan.bean.EmpBean;

@WebServlet("/GetAllEmpsJSTL")
public class GetAllEmpsJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final String JDBC_DRIVER = 
//			"com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private static final String DB_URL = 
//			"jdbc:sqlserver://localhost:1433;databaseName=jdbc;trustServerCertificate=true";
//	private static final String USER = "sa";
//	private static final String PASSWORD = "!2525KJHIuejhd@";
	private static final String SQL = "SELECT * FROM employee";
    
	Connection conn;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {     
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
		
			
			PreparedStatement stmt = conn.prepareStatement(SQL);
			ResultSet rs = stmt.executeQuery();
			List<EmpBean> emps = new ArrayList<EmpBean>();
			EmpBean emp = null;
			while (rs.next()) {
				emp = new EmpBean();
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));
				emp.setTitle(rs.getString("title"));
				emps.add(emp);
			}
			request.setAttribute("emps", emps);
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
		request.getRequestDispatcher("/m15/GetAllEmps.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
		 doGet(request, response);
	}
}
