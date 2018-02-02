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
<style>
.popup {
	position: absolute;
	left: 0px;
	top: 0px;
}

.back {
	background-color: gray;
	opacity: 0.5;
	width: 100%;
	height: 100%;
	overflow: hidden;
	z-index: 1101;
}

.front {
	z-index: 1110;
	opacity: 1;
	border: 1px;
}

.show {
	position: relative;
	width: 50%;
	height: 50%;
	margin: 200px auto;
	overflow: hidden;
}
</style>
</head>
<body>
<form id="write" method="post">
		<input type="hidden" name="ttr_cat" value="${boardVO.ttr_cat}">
		<input type="hidden" name="com_id" value="${boardVO.com_id}">
		<label>썸네일</label>
		<div class="thumb"
			style="width: 200px; height: 200px; background-color: blue;"></div>
		<div>
			<label>제목</label> <input type="text" name="ttr_title"
				value="${boardVO.ttr_title}" readonly>
		</div>
		<div>
			<label>알림</label> <input type="text" name="ttr_alert"
				value="${boardVO.ttr_alert}" readonly>
		</div>
		<div>
			<label>세부내용</label> <input type="text" name="ttr_content"
				value="${boardVO.ttr_content}" readonly>
		</div>
		<div><label>좌석정보</label>
			<table id="seat_table">
				<tr>
					<td>등급</td>
					<td>좌석수</td>
					<td>가격</td>
					<td>날짜</td>
					<td>시간</td>
				</tr>
			</table>
		</div>
	</form>
		<div class="popup back" style="display: none;"></div>
	<div id="popup_front" class='popup front' style="display: none;">
		<img id="popup_img" />
	</div>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="/resources/js/upload.js"></script>
<script>
$(document).ready(function(){
	var seats=null;
	var str=""
	<c:forEach var="seat" items="${boardVO.seat_grd}" varStatus="status">
		str+="<tr>"+
		"<td id='seat_info'><input type='text' name='seat_grd' value='${boardVO.seat_grd[status.count-1]}' readonly></td>"+
		"<td><input type='int' name='seat_no' value="+${boardVO.seat_no[status.count-1]}-<%=request.getAttribute(seat_cnt).get(%>${boardVO.seat_id[status.count-1]}<%=) %>+" readonly></td>"+
		"<td><input type='int' name='seat_pri' value='${boardVO.seat_pri[status.count-1]}' readonly></td>"+
		"<td><input type='date' name='seat_date' value='<fmt:formatDate pattern='yyyy-MM-dd' value='${boardVO.seat_date[status.count-1]}' />' readonly></td>"+
		"<td><input type='time' name='seat_time' value='<fmt:formatDate pattern='HH:mm' value='${boardVO.seat_time[status.count-1]}' />' readonly></td>"+
	"</tr>"
	</c:forEach>
	$('#seat_table').append(str);
var ttr_no=${boardVO.ttr_no};
			var thumb_name="${boardVO.thumb_name}"
			var thumb="<div class='min'><img src='"+getThumb(thumb_name)+"'><ori data_src='"+getOri(thumb_name)+"'></div>"
			$(".thumb").append(thumb);
			$('.min').on('click',function(event){
				var fileLink=$(this).children('ori').attr('data_src')
				if(checkImageType(fileLink)){
					event.preventDefault();
					
					var imgTag=$('#popup_img');
					imgTag.attr('src',fileLink);
					
					//console.log(imgTag.attr('src'));
					
					$('.popup').show('slow');
					imgTag.addClass('show');
				}
			});
			$('#popup_img').on('click',function(){
				$('.popup').hide('slow');
			});
		})
</script>
</body>
</html>