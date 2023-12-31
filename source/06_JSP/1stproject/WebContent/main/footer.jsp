<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link href="${conPath }/main/css/style2.css" rel = "stylesheet">
</head>
<body>
	<footer id = "main_footer">
            <div class="footer bg-dark text-secondary px-1 text-center">
                <div class="py-2">
                    <a href = "#"><button type="button" class="btn btn-outline-light btn-lg px-1">▲TOP</button></a>
                    <a href = "#"><button type="button" class="btn btn-outline-light btn-lg px-1" onclick = "location.href='/1st_project/main/intro.jsp'">회사소개</button></a>
                    <a href = "#privacy"><button type="button" class="btn btn-outline-light btn-lg px-1">개인정보</button></a>
                    <a href = "#policy"><button type="button" class="btn btn-outline-light btn-lg px-1">운영규약</button></a>
                    <a href = "#qna"><button type="button" class="btn btn-outline-light btn-lg px-1">문의게시판</button></a>
                </div>
                <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
              	   <h1 class="display-5 fw-bold text-white"><img class = "footerImg" src = "${conPath }/main/img/footerlogo.jpg" height = "100">Weekend Company</h1>
                </div>
                <div class="col-lg-6 mx-auto">
                    <p class="fs-6">사업자등록번호:10-29247-998 | 대표이사:권주말 | 주소: 서울시 강남구 신당빌딩 3층 310호 </p>
                    <p class="fs-6">연락처:063-300-0909 | 팩스:02-3537-0366 | 문의메일 <a href="mailto:jpju99@gmail.com" style="color: #a3aa3b;">desk@Game-idaa.com</a></p>                                          
                    <p class="fs-6">Copyright ⓒ Game-idaa All Rights Reserved.</p>
                </div>
             </div>   
         </footer>              
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>