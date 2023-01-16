<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.Random" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/function" %>
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
	<%="값" %> -> ${"값" }<br>
	
	<h3>EL - Expression Language</h3> <!-- jsp에서 오류 뜨는건 무시해도 됨 -->
	${10 + 20 }<br>
	${10 div 3 }<br> <!-- 나누기 -->
	${10 mod 3 }<br> <!-- 나머지 -->
	${10 eq 10 }<br> <!-- 같다 -->
	${10 ne 10 }<br> <!-- 같지 않다(not equal. 줄임말에서 e는 equal을 뜻함) -->
	${10 gt 10 }<br> <!-- 크다 -->
	${10 ge 10 }<br> <!-- 크거나 같다 -->
	${10 lt 10 }<br> <!-- 작다 -->
	${10 le 10 }<br> <!-- 작거나 같다 -->
	${true and true }<br>
	${true or true }<br>
	${not true }<br>
	${empty x }<br> <!-- x가 null이나 빈문자열" " 인지 true false로 판단함 -->
	${empty x ? "없음" : "있음" }<br>
	
	${"문자열" }${"문자열" }<br>
	${10 }${"문자열" }<br>
	
	<h4>EL 로 request.getAttribute() 사용</h4>
	${requestScope.number }<br> <!-- 다운캐스팅(Integer) 안해도됨 -->
	
	<h4>EL 로 request.getParameter() 사용</h4>
	${param.num }<br> <!-- 인풋 네임이 num이므로 .num -->
	
</body>
</html>