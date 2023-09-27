<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%
	String color = request.getParameter("color");
if (color == null) {
	color = "aqua";
}
%>

<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: <%=color%>
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>배경색 바꾸기</h1>
	<form action="" method="post">
		<select name="color">
			<option value="red">빨강</option>
			<option value="orange">주황</option>
			<option value="yellow">노랑</option>
			<option value="green">초록</option>
			<option value="blue">파랑</option>
			<option value="navy">남색</option>
			<option value="violet">보라</option>
		</select> <input type="submit" value="색상적용">
	</form>
</body>
</html>