<%@page import="com.lec.ex.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String conPath = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%
	String result = request.getParameter("result");
	if (result != null && result.equals("1")) {
	%>
	<script>
	alert("게시글 작성 완료");
	</script>
	<%} else if (result != null && result.equals("0")) {%>
	<script>
		alert("게시글 작성 실패");
	</script>
	<%}%>
	<table>
		<caption>게시판</caption>
		<tr onclick="location.href='<%=conPath%>/Board/writeForm.jsp'">
			<td id="writeForm"><a href="<%=conPath%>/Board/writeForm.jsp">글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>메일</th>
			<th>조회수</th>
			<%
				BoardDao bDao = BoardDao.getInstance();
			int totalCnt = bDao.getBoardTotalCnt(); // 글 전체갯수 가져오기
			if (totalCnt == 0) {
				out.print("<tr><td colspan='5'>아직 게시글이 없습니다</td></tr>");
			} else {
				ArrayList<BoardDto> lists = bDao.boardList();
				for (BoardDto dtos : lists) {
					//out.print("<tr><td>"+dtos.getBid()+"</td><td class = 'left'>"+dtos.getBtitle());
					//글번호
					out.print("<tr><td>" + dtos.getBid() + "</td>");
					//작성자
					out.print("<td>" + dtos.getBname() + "</td>");
					//제목 (왼쪽정렬 + hot이미지 출력 / 클릭시 상세보기)
					out.print("<td class = 'left'>");
					if (dtos.getBhit() >= 10) {
			%>
			<img src="<%=conPath%>/img/hot.gif">
			<%
				}
			%>
			<a href="<%=conPath%>/Board/content.jsp?bid=<%=dtos.getBid()%>"><%=dtos.getBtitle()%></a>
			</td>
			<%
				//메일
			String email = dtos.getBemail();
			out.print("<td>" + (email == null ? "-" : email) + "</td>");
			//조회수
			out.print("<td>" + dtos.getBhit() + "</td></tr>");
				}
			}
			%>
		
	</table>
</body>
</html>