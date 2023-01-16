<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.dto.VisitDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<div>
		<a href="./">메인으로</a>
	</div>
	<h2>방명록</h2>
	<form action="./visit" method="post">
		<div>
			<input type="text" name="nickname">
		</div>
		<div>
			<textarea rows="3" cols="25" name="context"></textarea>
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
	<ul>
		<% for(VisitDTO d: (List<VisitDTO>)request.getAttribute("data")) { %>
			<li>
			<%=d.getNickname() %> | <%=d.getContext() %>
			<button type="button" onclick="location.href='./visit/update?id=<%=d.getId() %>'">수정</button>
			<button type="submit" form="deleteForm<%=d.getId() %>">삭제</button>
				<form id="deleteForm<%=d.getId() %>" action="./visit/delete" method="post">
					<input type="hidden" name="id" value="<%=d.getId() %>">
				</form>
			</li>
		<% } %>
	</ul>
</body>
</html>