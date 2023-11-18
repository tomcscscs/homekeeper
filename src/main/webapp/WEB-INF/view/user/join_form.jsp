<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resource/stylesheet/style.css">

</head>
<body>
<p class="align-right"><a href="${pageContext.servletContext.contextPath}/index }">메인으로</a> </p>
	
	<form action="${pageContext.servletContext.contextPath }/joinHandle">
		<h3>기본</h3>
		<hr>
		<div>아이디<input type="text" name="id" /></div>
		<div>비밀번호 <input type="password"
			name="password"></div> 
		<h3>추가정보</h3>
		<hr>

		<div>닉네임 <input type="password" name="password"></div>
		<div>탄생년도 <select name="brith">
			<option></option>
			<c:forEach var="year" begin="1923" end="2023">
				<option>${year }</option>
			</c:forEach>
		</select> </div>
		<div>성별(*) <input type="radio" name="gender" value="M" />남성 <input
			type="radio" name="gender" value="F" />여성 <input type="radio"
			name="gender" value="">비공개 </div>
			<hr>
			
			
			<label>아바타</label>
		<div>
			<c:forEach var="one" items="${avatars}">
							<img alt="피엔지파일" src="${pageContext.servletContext.contextPath}${one.imageUrl}"/>
							<input type="radio" name="avatarId" value="${one.id}"/>${one.id }
			
			</c:forEach>
		</div>
	</form>
	
	

</body>
</html>






				
			
			
			
			
		








