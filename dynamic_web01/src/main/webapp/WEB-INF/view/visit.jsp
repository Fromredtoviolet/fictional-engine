<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<div>
		<c:url var="mainUrl" value="/" />
		<a href="${mainUrl }">메인으로</a>
	</div>
	<h2>방명록</h2>
	<c:url var="visitUrl" value="/visit" />
	<form action="${visitUrl }" method="post">
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
	<div>
		<form action="${visitUrl }">
			<select name="c" onchange="submit();"> <%-- 변경이 발생할때 제출해라 --%>
				<option value="5" ${requestScope.cnt eq 5 ? "selected" : "" }>5개</option>
				<option value="10" ${requestScope.cnt eq 10 ? "selected" : "" }>10개</option>
				<option value="15" ${requestScope.cnt eq 15 ? "selected" : "" }>15개</option>
				<option value="20" ${requestScope.cnt eq 20 ? "selected" : "" }>20개</option>
				<option value="25" ${requestScope.cnt eq 25 ? "selected" : "" }>25개</option>
			</select>
		</form>
	</div>
	<ul>
		<c:forEach var="d" items="${requestScope.data }">
			<c:url var="visitUpdateUrl" value="/visit/update">
				<c:param name="id" value="${d.id }" />
			</c:url>
			<c:set var="formId" value="deleteForm${d.id }" />
			<li>
				${d.nickname } | ${d.context }
				<button type="button" onclick="location.href='${visitUpdateUrl }'">수정</button>
				<button type="submit" form="${formId }">삭제</button>
				<form id="${formId }" action="${visitUrl }/delete" method="post">
					<input type="hidden" name="id" value="${d.id}">
				</form>
			</li>
		</c:forEach>
	</ul>
	<div>
		<c:set var="pageNumber" value="${empty param.p ? 1 : param.p }" />
		<c:choose>
			<c:when test="${pageNumber eq 1 }">
				<a>prev</a>
			</c:when>
			<c:otherwise>
				<a href="./visit?p=${pageNumber - 1 }">prev</a>
			</c:otherwise>
		</c:choose>
		<c:forEach var="num" items="${requestScope.pageList }"> <%--비짓컨트롤러에서 셋어트리뷰트해둔 속성을 찾아옴--%>
			<a href="${visitUrl }?p=${num }">${num }</a>
		</c:forEach>
		<c:choose>
			<c:when test="${pageNumber eq lastPageNumber }">
				<a>next</a>
			</c:when>
			<c:otherwise>
				<a href="./visit?p=${pageNumber + 1 }">next</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>