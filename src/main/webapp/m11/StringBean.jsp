<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using JavaBeans with JSP</title>
</head>
<body>
	<h3>Using JavaBeans with JSP</h3>
	<jsp:useBean id="sb" class="com.lcpan.bean.StringBean" />
	<ol>
		<li>Set and get property with jsp:setProperty:<br> 
			<jsp:setProperty name="sb" property="message" value="This is a test" />
			<i><jsp:getProperty name="sb" property="message"/>
		</i>
		<li>Set and get property with scriptlet:<br>
			<% sb.setMessage("Learing JSP is wonderful"); %>
			<i><%=sb.getMessage() %></i>
	</ol>
</body>
</html>