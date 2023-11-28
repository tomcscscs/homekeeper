<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통계 테스트</title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath }/log">뒤로</a>

<div style="text-align: center;">
<c:forEach var="one" items="${maxAmt}">
<p>${maxAmt} 전체가 나와야하는데.
</c:forEach>
</div>

</body>
</html>