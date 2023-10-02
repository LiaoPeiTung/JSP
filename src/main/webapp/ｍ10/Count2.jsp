<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>區域變數</title>
</head>
<body>
	<%--區域變數:1,1,1 --%>
	<% int count = 0; %>
	<% count++; %>
	Welcome, your visitor number is
	<%= count %>
</body>
</html>