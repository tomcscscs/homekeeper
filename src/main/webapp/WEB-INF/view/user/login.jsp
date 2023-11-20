<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>저희의 멤버라는 것을 보여주세요.</h1>
<form method="post" action="${pageContext.servletContext.contextPath}/loginHandle ">
아이디: <input type="text" name="id" ><br>
패스워드: <input type="password" name="password"><br>
<div style="margin-top: 50px"><b>나를 기억해줘요</b> 나를 기억해줘요<input type="checkbox" name="keep" value="true"></div> 


<button type="submit">확인</button>


</form>

<div><a href="${pageContext.servletContext.contextPath}/index">메인으로</a> </div>







</body>
</html>