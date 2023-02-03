<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${errorType eq 'fileExtError' }">
			<h1>잘못된 파일 포맷입니다.</h1>
			<p>
				허용된 파일 포맷은 ${initParam.permitFileExt } 입니다.
			</p>
		</c:when>
		<c:when test="${errorType eq 'fileTypeError' }">
			<h1>잘못된 파일 종류입니다.</h1>
			<p>
				허용된 파일 종류는 ${initParam.permitFileType } 입니다.
			</p>
		</c:when>
		<c:when test="${errorType eq 'fileSizeError' }">
			<h1>파일의 크기가 너무 큽니다.</h1>
			<p>
				허용된 파일 크기는 ${initParam.maxFileSize } 바이트입니다.
			</p>
		</c:when>
	</c:choose>
</body>
</html>