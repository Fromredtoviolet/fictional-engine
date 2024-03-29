<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.dto.VisitDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 수정</title>
<%@ include file="/WEB-INF/view/module/bootstrap.jsp" %>
</head>
<body>
	<div>
		<%@ include file="/WEB-INF/view/module/topnav.jsp" %>
	</div>
	<div>
		<a href="../visit">돌아가기</a>
	</div>
	<h2>즐겨찾기 수정</h2>
	<form action="./update" method="post">
		<div>
			<input type="hidden" name="id" value="<%=((VisitDTO)request.getAttribute("data")).getId() %>">
		</div>
		<div>
			<textarea rows="3" cols="25" name="context"><%=((VisitDTO)request.getAttribute("data")).getContext() %></textarea>
		</div>
		<div>
			<input type="text" name="nickname" value="<%=((VisitDTO)request.getAttribute("data")).getNickname() %>">
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
</body>
</html>