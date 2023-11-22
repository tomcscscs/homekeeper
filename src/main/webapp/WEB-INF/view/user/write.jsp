<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>롸이트</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath }/writeComplex" method="post">
날짜# <input type="date" name="spendAt" value=${now }>
카테고리# <select name="categoryId">
<c:forEach var="one" items="${categories }">
<option value="${one.id}">${one.name }</option>
</c:forEach>
</select>
지출금액# <input type="number" name="amt" step="1000">
사용내역# <input type="text" name="useDesc">
			<button>지출내역기입</button>
			
		<c:if test="${param.error eq true}">
		<p>데이터등록에 실패했습니다. 다시 시도하세요.</p>
		</c:if>
		
</form>
</body>
</html>
		
















