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
	<form id="etcwrite" method="post">
	<input type="hidden" name="ttr_cat">
	<input type="hidden" name="com_id">
		<label>썸네일</label>
		<div class="thumb fileDrop uploadedList" name="thumb" style="width: 200px; height: 200px; background-color: blue;">
		<input type="hidden" name="thumb">
		</div>
		<label>좌석배치도</label>
		<div class="seatmap fileDrop uploadedList" name="seatmap" style="width: 200px; height: 200px; background-color: blue;">
		<input type="hidden" name="seatmap">
		</div>
		<label>제목</label>
		<input type="text" name="ttr_title">
		<label>시작일</label>
		<input type="date" name="ttr_sdate">
		<label>종료일</label>
		<input type="date" name="ttr_edate">
		<label>장소</label>
		<input type="text" name="ttr_place">
		<label>시간</label>
		<input type="text" name="ttr_time">
		<label>알림</label>
		<input type="text" name="ttr_alert">
		<label>세부내용</label>
		<input type="text" name="ttr_content">
		<label>사진자료</label>
		<div class="files fileDrop uploadedList" name="files" style="width: 800px; height: 200px; background-color: blue;">
		</div>
	</form>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="/resource/js/upload"></script>
<script>
$('#registerForm').submit(function(event){
	event.preventDefault();
	
	var that=$(this);
	var str="";
	$('.uploadedList .delbtn').each(function(index){
		str+="<input type='hidden' name='files'"
		+"value='"+$(this).attr('href')+"'>";
	});
	
	that.append(str);
	that.get(0).submit();
});
</script>
</body>
</html>