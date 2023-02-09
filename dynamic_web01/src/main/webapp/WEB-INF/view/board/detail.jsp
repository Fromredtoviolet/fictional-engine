<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 페이지</title>
<%@ include file="/WEB-INF/view/module/bootstrap.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
</head>
<body>
	<c:url var="recommendUrl" value="/ajax/recommend" />
	<script type="text/javascript">
		function recommend(element, id, type) {
			$.ajax({
				type: "get",
				url: "${recommendUrl }",
				data: {
					id: id,
					type: type
				},
				dataType: "json",
				success: function(data) {
					if(data.redirect !== undefined) {
						let message = "추천/비추천은 회원만 할 수 있습니다. 로그인 페이지로 이동합니까?";
						if(confirm(message)) {
							location.href = data.redirect;
										<%-- ↑ 로그인필터의 리다이렉트를 말함 --%>
						}
					} else {
						if(data.type === "success") {
							if(type === "recom") {
								element.innerText = "추천 " + data.count
							} else if(type === "depre") {
								element.innerText = "비추천 " + data.count
							}
						} else if(data.type === "error") {
							console.log(msg);
						}
					}
				}
			});
		}
	</script>
	<c:url var="boardUrl" value="/board" />
	<div>
		<%@ include file="/WEB-INF/view/module/topnav.jsp" %>
	</div>
	<div>
		<h1>${requestScope.data.title }</h1>
	</div>
	<div>
		<fmt:formatDate var="createDate" type="both" pattern="yyyy년 MM월 dd일 EEEE a KK시 mm분 ss초" value="${requestScope.data.createDate }" />
		<fmt:formatDate var="updateDate" type="both" pattern="yyyy년 MM월 dd일 EEEE a KK시 mm분 ss초" value="${requestScope.data.updateDate }" />
		작성자: ${requestScope.data.writer }<br>
		작성일: ${createDate }<br>
		수정일: ${updateDate }<br>
		조회수: ${requestScope.data.viewCnt }
	</div>
	<div id="viewer"></div>
	<div>
		<ul>
			<c:forEach var="image" items="${requestScope.images }" >
				<c:url var="imagePath" value="${image.path }${image.uuid }" />
				<li><a href="${imagePath }" download="${image.name }">${image.name }</a></li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<button type="button" class="btn btn-primary" onclick="recommend(this, ${requestScope.data.id }, 'recom');">
			추천 ${requestScope.data.recomCnt }</button>
		<button type="button" class="btn btn-danger" onclick="recommend(this, ${requestScope.data.id }, 'depre');">
			비추천 ${requestScope.data.depreCnt }</button>
	</div>
	<div>
		<button onclick="location.href='${boardUrl }'">목록</button>
		<c:if test="${sessionScope.login }">
			<c:if test="${sessionScope.user.userId eq requestScope.data.writer }">
				<button onclick="location.href='${boardUrl }/update?id=${requestScope.data.id }'">수정</button>
				<button onclick="location.href='${boardUrl }/delete?id=${requestScope.data.id }'">삭제</button>
			</c:if>
		</c:if>
	</div>
	<script type="text/javascript">
		var viewer;
		window.onload = function() {
			<c:url var="boardDetailUrl" value="/board/detail" />
			$.ajax({
				url: "${boardDetailUrl }",
				data: {
					id: ${requestScope.data.id }
				},
				type: "post",
				dataType: "json",
				success: function(data) {
					viewer = new toastui.Editor.factory({
						el: document.querySelector("#viewer"),
						viewer: true, // 뷰어로 사용
						initialValue: data.context // 초기값
					});
				}
			});
			// 위의 initialValue 의 값을 Ajax 를 사용하여 페이지가 로드 되었을 때 서버에 조회 요청을 하고
			// 응답 데이터의 context 를 찾아서 초기값으로 설정되도록 변경해 보세요.
		}
	</script>
</body>
</html>