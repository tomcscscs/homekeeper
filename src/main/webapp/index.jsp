<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕하세요#메인#</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<style type="text/css">
body {
	text-align: center;
}

@import url('https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@900&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@400;900&display=swap');
</style>

</head>
<body>
<div style="font-size: 90px">


<div style="font-family:'Noto Serif KR', serif; font-size: 60px; background-color:black; color: white;" ><fmt:formatDate value="${date}" pattern ="yyyy,MM,dd   / HH:mm:ss"/></div>
<p style="font-family:'Noto Serif KR', serif; ">환영합니다.<br><div style="font-family:'Noto Serif KR', serif; ">위해 평화 당신 가계의</div></p>

</div>

<h1 class="align-right"><b>홈.키.퍼</b></h1>

<div style="margin: 50px">
<a href="/homekeeper/login">이미 회원이실까요?</a><br>
</div>

<div style="margin: 50px">
<a href="/homekeeper/join">처음이시라구요.</a>
</div>


</body>
</html>