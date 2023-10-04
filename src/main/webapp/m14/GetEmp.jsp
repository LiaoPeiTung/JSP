<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>員工資料</title>
</head>
<body style="background-color: #fdf5e6">
	<div align="center">
		<h2>員工資料</h2>
		<table>
			<tr>
				<td>員工編號
				<td><input type="text" disabled value="${emp.empno}">
			<tr>
				<td>姓名
				<td><input type="text" disabled value="${emp.ename}">
			<tr>
				<td>到職日
				<td><input type="text" disabled value="${emp.hiredate}">
			<tr>
				<td>薪水
				<td><input type="text" disabled value="${emp.salary}">
			<tr>
				<td>部門編號
				<td><input type="text" disabled value="${emp.deptno}">
			<tr>
				<td>職稱
				<td><input type="text" disabled value="${emp.title}">
		</table>
	</div>
</body>
</html>