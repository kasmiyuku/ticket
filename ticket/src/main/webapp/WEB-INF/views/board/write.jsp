<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form id="write" method="post">
		<input type="hidden" name="ttr_cat" value="기타"> 
		<input type="hidden" name="com_id" value="qwe"> 
		<label>썸네일</label>
		<div class="thumb"
			style="width: 200px; height: 200px; background-color: blue;">
		</div>
		<label>좌석배치도</label>
		<div class="seatmap"
			style="width: 200px; height: 200px; background-color: blue;">
		</div>
		<div>
		<label>제목</label> <input type="text" name="ttr_title"> 
		</div>
		<div>
		<label>시작일</label>
		<input type="date" name="ttr_sdate"></div> 
		<div>
		<label>종료일</label> <input type="date" name="ttr_edate">
		</div> 
		<div>	
			<label>장소</label> <input type="text" name="ttr_place">
		</div> 
		<div>
		<label>시간</label> <input type="text" name="ttr_time">
		</div> 
		<div><label>알림</label> <input type="text" name="ttr_alert">
		</div> 
		<div><label>세부내용</label> <input type="text" name="ttr_content">
		</div> 
		<label>사진자료</label>
		<div class="file"
			style="width: 800px; height: 200px; background-color: blue;"></div>
		<input type="submit" value="작성">
	</form>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/resources/js/upload.js"></script>
</body>
</html>