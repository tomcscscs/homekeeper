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
<body style="text-align: center;">

<div><img alt="pic" src="${pageContext.servletContext.contextPath}${sessionScope.logonUser.avatar.imageUrl}"/></div>
<div><b> ${sessionScope.logonUser.nickname }</b>님 로그온 하셨습니다.</div>

<select name="sort">
<c:choose>
<c:when test="${param.sort eq 'spendAt' }">
<option value="spendAt" selected>날짜순</option>
</c:when>
<c:otherwise>
<option value="spendAt">날짜순</option>
</c:otherwise>





</c:choose>:
</select>


<form action="${pageContext.servletContext.contextPath }/login">
<div style="border-bottom-color: red;" align="center"><input type="date" name="begin" value="${param.begin }"/>~
<input style="border-bottom: thick;" type="date" name ="end" value="${param.end }"/>
<button type="button">검색</button> 
</div>
</form>









<form action="${pageContext.servletContext.contextPath }/delete">
<table border="1" style="width: 1000px ">
<tr>

<th></th>
<th>날짜</th>
<th>내역</th>
<th>금액</th>
<th>분류</th>
</tr>
<tr>
<c:forEach var="one" items="${logs}">

<td><input type="checkbox" name="no" value="${one.no }" /> </td>
<td>${one.spendAt }</td>
<td>${one.useDesc }</td>
<td>
<fmt:formatNumber value="${one.amt }" pattern="#,###"/>
</td>
<td>${one.category.name }</td>
</tr>
</c:forEach>
<tr>
<td colspan="3">총 합</td>
<td colspan="2"><fmt:formatNumber value="${total }" pattern="#,###"/> </td>
</table>


<div>
<button type="submit">기록삭제</button>
<a href="${pageContext.servletContext.contextPath }/writeComplex"><button>기록추가</button> </a>
</div>

</form>

</body>
</html>











