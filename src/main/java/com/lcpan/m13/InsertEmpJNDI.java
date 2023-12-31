package com.lcpan.m13;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

import com.lcpan.bean.EmpBean;

@WebServlet("/InsertEmpJNDI")
public class InsertEmpJNDI extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final String JDBC_DRIVER = 
//			"com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private static final String DB_URL = 
//			"jdbc:sqlserver://localhost:1433;databaseName=jdbc;trustServerCertificate=true";
//	private static final String USER = "sa";
//	private static final String PASSWORD = "!2525KJHIuejhd@";
	private static final String SQL = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
    
	Connection conn;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String hiredate = request.getParameter("hiredate");
		int salary = Integer.parseInt(request.getParameter("salary"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String title = request.getParameter("title");
		try {     
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, empno);
			stmt.setString(2, ename);
			stmt.setString(3, hiredate);
			stmt.setInt(4, salary);
			stmt.setInt(5, deptno);
			stmt.setString(6, title);
//			EmpBean emp = new EmpBean();
//			if (rs.next()) {
//				emp.setEmpno(rs.getString("empno"));
//				emp.setEname(rs.getString("ename"));
//				emp.setHiredate(rs.getString("hiredate"));
//				emp.setSalary(rs.getString("salary"));
//				emp.setDeptno(rs.getString("deptno"));
//				emp.setTitle(rs.getString("title"));
//			}
//			request.setAttribute("emp", emp);
//			rs.close();
			stmt.executeUpdate();
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
		request.getRequestDispatcher("/m13/InsertEmpHomework.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
		 doGet(request, response);
	}
}
