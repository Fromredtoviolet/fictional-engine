<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 추가 페이지</title>
<%@ include file="/WEB-INF/view/module/bootstrap.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		function imageValid(element) {
			if(element.files.length > 3) {
				alert('이미지는 3개 까지만 선택할 수 있습니다.');
				element.value = "";
				<%-- value값(첨부파일들)을 빈 문자열로 초기화시킨다. --%>
			}
		}
		function sendForm(form) {
			// Toast UI Editor 에 작성된 글 가져와서 전송할 폼에 넣기
			form.context.innerText = editor.getHTML();
											// 에디터에서 적용한 형식들까지 가져오려면 getHTML 써야함
			form.submit();
			return false;
		}
	</script>
	<div>
		<%@ include file="/WEB-INF/view/module/topnav.jsp" %>
	</div>
	<div>
		<h1>글 작성</h1>
	</div>
	<div>
		<c:url var="boardAddUrl" value="/board/add" />
		<form action="${boardAddUrl }" method="post" onsubmit="return sendForm(this);">
			<div>
				<label>제목</label>
				<input type="text" name="title">
			</div>
			<div>
				<label>내용</label>
				<div id="editor"></div>
				<textarea style="display: none;" name="context"></textarea>
			</div>
			<!-- <div> 이거 되살리려면 위에 폼 태그에 enctype 작성해야함
				<label>이미지 업로드</label>
				<input type="file" onchange="imageValid(this);" name="imageUpload" accept="image/*"  multiple>
			</div>  -->
			<c:if test="${sessionScope.role.type eq 'ADMIN' }">
				<div>
					<label>공지사항</label>
					<input type="checkbox" name="notice" value="yes">
				</div>
			</c:if>
			<br>
			<div>
				<button type="submit">저장</button>
				<button type="button" onclick="history.back();">취소</button>
											<%-- ↑ 자바스크립트에서 기본으로 제공하는 뒤로가기 기능--%>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		const editor = new toastui.Editor({
			el: document.querySelector('#editor'),
			height: "250px",
			hooks: {
				"addImageBlobHook": function(blob, callback) {
					// blob: 사용자가 선택한 이미지 파일
					// callback: 파일이 업로드 된 후 에디터에 표시할 이미지 주소를 전달하기 위한 콜백함수
					let formData = new FormData();
					formData.append("imageUpload", blob);
					formData.append("location", "board");
				 // 폼데이터에.추가(	//키	   //값)
				 
					<c:url var="imageUploadUrl" value="/ajax/imageUpload" />
						$.ajax({
							url: "${imageUploadUrl }",
							type: "post",
							data: formData,
							dataType: "json",
							enctype: "multipart/form-data",
							processData: false,
							contentType: false,
							success: function(data) {
								callback(data.imageUrl);
							}
						});
					}
				}
			})
	</script>
	<%-- 이 스크립트는 CDN으로 불러다 쓰는 토스트UI --%>
</body>
</html>