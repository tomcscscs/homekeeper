<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조인핸들</title>
</head>
<body>
	<h1>홈키퍼-회원가입 결과</h1>
	<c:choose>
		<c:when test="${saveResult}">
			<b>${savedUser.id}</b>가 성공적으로 등록됐습니다.  
</c:when>
		<c:otherwise>
${existUser.id}는 이미 존재하는 회원입니다. 
<b>다른 아이디 사용 바랍니다.</b>

		</c:otherwise>
	</c:choose>

	<a href="${pageContext.servletContext.contextPath}/join"><button>뒤로</button>
	</a>















</body>
</html>