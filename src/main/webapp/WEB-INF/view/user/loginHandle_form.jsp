<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인핸들러</title>
</head>
<body>
	<c:choose>
		<c:when test="${loginResult}">
			<p>안녕하세요. 너무 반가워요. ${sessionScope.logonUser.id }님.</p>
		</c:when>
		<c:otherwise>
			<p>뭔가 오타가 있는게 아닐까요. 다시 시도해주시겠어요.
		</c:otherwise>
	</c:choose>
	<a href="${pageContext.servletContext.contextPath}/login">뒤로</a>
	<a href="${pageContext.servletContext.contextPath}/index">메인으로</a>





</body>
</html>