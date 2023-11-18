<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath }/joinHandle">
		<h3>기본</h3>
		<hr>
		아이디<input type="text" name="id" /> 비밀번호 <input type="password"
			name="password">
		<h3>추가정보</h3>
		<hr>

		닉네임 <input type="password" name="password"> 탄생년도 <select>
			<option></option>
			<c:forEach var="year" begin="1923" end="2023">
				<option>${year }</option>
			</c:forEach>
		</select> 성별(*) <input type="radio" name="gender" value="M" />남성 <input
			type="radio" name="gender" value="F" />여성 <input type="radio"
			name="gender" value="">비공개 <label>아바타</label>
		<div>
			<c:forEach var="one" items="${avatars}">
				${one.id }*^^*<input type="radio" name="avatarId" value="${one.id}" />
				
			
			
			</c:forEach>
			
			
		</div>




	</form>

</body>
</html>










