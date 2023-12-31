<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath }/css/style.css" rel = "stylesheet">
</head>
<body>
	<h2>studentOk.jsp 페이지입니다.</h2>
	<h4> Model (confirm된) ID:
	<c:if test="${empty id }">
	아이디없음 (redirect 키워드 사용 / 바로실행)
	</c:if>	
	<c:if test = "${not empty id }">
	${id } (forward 키워드 사용)
	</c:if>
	</h4>
	<h4>
	패러미터로 넘어온 ID :
	<c:if test = "${empty param.id }">
	X (redirect 키워드 사용 / 바로실행)
	</c:if>
	<c:if test = "${not empty param.id }">
	O (${param.id })  (forward 사용)		
	</c:if>
	</h4>
</body>
</html>