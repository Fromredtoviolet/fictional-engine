<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록 페이지</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/boardInsert" method="post">
		<table>
			<tr><td>제목</td>
				<td><input type="text" name="boardTitle​​"></td></tr>
			<tr><td>작성자</td>
				<td><input type="text" name="boardWriter​"></td></tr>
			<tr><td>내용</td>
				<td><textarea cols="50" rows="7" name="boardContent​"></textarea></td></tr>
			<tr><td colspan="2">
				<input type="submit" value="등록하기">  
				<a href="<%=request.getContextPath()%>/boardList">목록으로</a></td></tr>
		</table>
	</form>
</body>
</html>