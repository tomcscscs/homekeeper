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
		<table border="1" style="margin: 0 auto; width: 1600px; ">
			<tr>
				<th>아이디</th>
				<th>지출액</th>
			</tr>
	
		<c:forEach var="one" items="${maxAmt}">
	
			<tr>
				<td>${one.userId}</td>
				<td>${one.maxA}</td>
			
			</tr>
			
							
			
			
		</c:forEach>
		</table>
	</div>

</body>
</html>