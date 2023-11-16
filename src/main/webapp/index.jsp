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


</style>
</head>
<body>
<div style="font-size: 100px">


<p style="font-family:'Noto Serif KR', serif; ">환영한다. 위해 평화 너희 가계의</p>

</div>

<h1><b>홈.키.퍼</b></h1>
<div><fmt:formatDate value="${date}" pattern ="yyyy,MM,dd HH:mm:ss"/> </div>

<div style="margin: 50px">
<a href="/homekeeper/login">이미 회원이시간요?</a><br>
</div>

<div style="margin: 50px">
<a href="/homekeeper/register">처음이시라구요.</a>
</div>


</body>
</html>