<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.Random" %>
<%!
	public Random rand = new Random();

	public int getNumber() {
		return rand.nextInt(10);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP 파일이 실행되었습니다.</h2>
	<form action="./main">
		<input type="number" name="num">
		<button type="submit">전송</button>
	</form>
	<h2><%=(Integer)request.getAttribute("number") %></h2>
	<ul>
	<% for(int i = getNumber(); i >= 0; i--) { %>
		<li><%= i %></li>
	<% } %>
	</ul>
</body>
</html>