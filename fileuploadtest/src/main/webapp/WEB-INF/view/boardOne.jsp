<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>boardOne</h1>
	<a href="${pageContext.request.contextPath}/boardList/1">목록</a>
	<a href="${pageContext.request.contextPath}/updateBoard?boardId=${boardOne.boardId}">수정</a>
	<a href="${pageContext.request.contextPath}/removeBoard?boardId=${boardOne.boardId}">삭제</a>
				
	<table border="1">
		<tr>
			<td>boardId</td>
			<td>${boardOne.boardId}</td>
		</tr>
		<tr>
			<td>boardTitle</td>
			<td>${boardOne.boardTitle}</td>
		</tr>
		<tr>
			<td>boardContent</td>
			<td>${boardOne.boardContent}</td>
		</tr>
	</table>
	
		<c:forEach var="bf" items="${boardOne.boardfiles}">
			<c:if test="${bf.boardfileName!=null}">
			<table border ="1">
				<tr>
					<td>boardfileName</td>
					<td>${bf.boardfileName}</td>
				</tr>
				<tr>
					<td>boardfileType</td>
					<td>${bf.boardfileType}</td>
				</tr>
				<tr>
					<td>boardfileSize</td>
					<td>${bf.boardfileSize}</td>
				</tr>
			</table>	
			</c:if>	
		</c:forEach>
	
	
</body>
</html>