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
	.popup{
		position:absolute;
		left:0px;
		top:0px;
	}
	.back{
		background-color:gray;
		opacity:0.5;
		width:100%;
		height:100%;
		overflow:hidden;
		z-index:1101;
	}
	.front{
		z-index:1110;				
		opacity:1;
		border:1px;	
			}
	.show{
		position:relative;
		width:50%;
		height:50%;
		margin:200px auto;
		overflow:hidden;
	}
</style>
</head>
<body>
	<form id="write" method="post">
		<input type="hidden" name="ttr_cat" value="${boardVO.ttr_cat}"> 
		<input type="hidden" name="com_id" value="${boardVO.com_id}"> 
		<label>썸네일</label>
		<div class="thumb"
			style="width: 200px; height: 200px; background-color: blue;">
		</div>
		<label>좌석배치도</label>
		<div class="seatmap"
			style="width: 200px; height: 200px; background-color: blue;">
		</div>
		<div>
		<label>제목</label> <input type="text" name="ttr_title" value="${boardVO.ttr_title}" readonly> 
		</div>
		<div>
		<label>시작일</label>
		<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${boardVO.ttr_sdate}" /></div> 
		<div>
		<label>종료일</label> <fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${boardVO.ttr_edate}" />
		</div> 
		<div>	
			<label>장소</label> <input type="text" name="ttr_place" value="${boardVO.ttr_place}" readonly>
		</div> 
		<div>
		<label>시간</label> <input type="text" name="ttr_time" value="${boardVO.ttr_time}" readonly>
		</div> 
		<div><label>알림</label> <input type="text" name="ttr_alert" value="${boardVO.ttr_alert}" readonly>
		</div> 
		<div><label>세부내용</label> <input type="text" name="ttr_content" value="${boardVO.ttr_content}" readonly>
		</div> 
		<div><label>좌석정보</label>
		<c:forEach items="${seats}" var="seatinfo">

				<tr>
					<td><input type="text" name="seat_grd" value="${seatinfo.seat_grd}" readonly></td>
					<td><input type="text" name="seat_no" value="${seatinfo.seat_no}" readonly></td>
					<td><input type="text" name="seat_pri" value="${seatinfo.seat_pri}" readonly></td>
					<td><fmt:formatDate pattern="HH:mm"
							value="${seatinfo.seat_time}" /></td>
				</tr>

			</c:forEach>
		</div>
		<label>사진자료</label>
		<div class="file"
			style="width: 800px; height: 200px; background-color: blue;"></div>
	</form>
	<div class="popup back" style="display:none;"></div>
<div id="popup_front" class='popup front' style="display:none;" >
	<img id="popup_img" />
</div>	
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="/resources/js/upload.js"></script>
	<script>
	$(document).ready(function(){
		var seats=null;
		var seat_grds="${boardVO.seat_grd}";
		var seat_nos="${boardVO.seat_no}";
		var seat_pris="${boardVO.seat_pri}";
		var seat_times="${boardVO.seat_time}";
		for(i in seat_grds){
			seats[i].setSeat_grd(seat_grds.get(i));
			seats[i].setSeat_no(seat_nos.get(i));
			seats[i].setSeat_pri(seat_pris.get(i));
			seats[i].setSeat_time(seat_times.get(i));
		}
			console.log("${boardVO}");
			var ttr_no=${boardVO.ttr_no}
			var thumb_name="${boardVO.thumb_name}"
			var thumb="<div class='min'><img src='"+getThumb(thumb_name)+"'><ori data_src='"+getOri(thumb_name)+"'></div>"
			var seatmap_name="${boardVO.seatmap_name}"
			var seatmap="<div class='min'><img src='"+getThumb(seatmap_name)+"'><ori data_src='"+getOri(seatmap_name)+"'></div>"
			$(".thumb").append(thumb);
			$(".seatmap").append(seatmap);
			$.getJSON("/board/getFiles/"+ttr_no,function(list){
				$(list).each(function(){
					console.log(this)
					var file;
					file="<img src='"+getOri(this)+"'>";
					$(".file").append(file);
				})
			})
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