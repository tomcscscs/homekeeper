<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그 뷰어 페이지.</title>
</head>
<body>

<table>
<tr>
<th>날짜</th>
<th>내역</th>
<th>금액</th>
<th>분류</th>
</tr>
<tr>
<c:forEach var="one" items="${logs}">
<td>${one.spendAt }</td>
<td>${one.useDesc }</td>
<td>
<fmt:formatNumber value="${one.amt }" pattern="#,###"/>
</td>
<td>${one.category.name }</td>
</tr>
</c:forEach>
</table>

<a href="${pageContext.servletContext.contextPath }/writeComplex"><button>기록추가</button> </a>


</body>
</html>











