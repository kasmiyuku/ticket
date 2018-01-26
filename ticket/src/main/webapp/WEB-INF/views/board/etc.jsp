<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>기타</h1>
	<div>
		<table border="1px">
			<tr>
				<th>대표이미지</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>

			<c:forEach items="${list}" var="boardVO">

				<tr>
					<td><img src="/displayFile?fileName=${boardVO.thumb_name}"></td>
					<td><a href="/board/etc/etcdetail?ttr_no=${boardVO.ttr_no}">${boardVO.ttr_title }</a></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
							value="${boardVO.ttr_date}" /></td>
				</tr>

			</c:forEach>

		</table>
	</div>
</body>
</html>