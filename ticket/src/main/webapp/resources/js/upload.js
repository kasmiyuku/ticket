$(".thumb").on("dragenter dragover", function(event) {
	event.preventDefault();
});
$(".thumb").on(
		"drop",
		function(event) {
			event.preventDefault();

			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];

			var formData = new FormData();
			formData.append("file", file);

			$.ajax({
				url : '/upload',
				type : 'post',
				data : formData,
				contentType : false,
				processData : false,
				success : function(data) {

					var str = "";
					if (checkImageType(data)) {
						str = "<div><img src='/displayFile?fileName=" + data
								+ "'/><small data-src='" + data
								+ "'><input type='hidden' name='thumb_name' value='"+data+"'><button>X</button></small></div>"
					}

					$(".thumb").append(str);
				}

			});

		});
$(".seatmap").on("dragenter dragover", function(event) {
	event.preventDefault();
});
$(".seatmap").on(
		"drop",
		function(event) {
			event.preventDefault();

			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];

			var formData = new FormData();
			formData.append("file", file);

			$.ajax({
				url : '/upload',
				type : 'post',
				data : formData,
				contentType : false,
				processData : false,
				success : function(data) {

					var str = "";
					if (checkImageType(data)) {
						
						str = "<div><img src='/displayFile?fileName=" + data
								+ "'/><small data-src='" + data
								+ "'><input type='hidden' name='seatmap_name' value='"+data+"'><button>X</button></small></div>"
					}

					$(".seatmap").append(str);
				}

			});

		});
$(".file").on("dragenter dragover", function(event) {
	event.preventDefault();
});
$(".file").on(
		"drop",
		function(event) {
			event.preventDefault();

			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];

			var formData = new FormData();
			formData.append("file", file);

			$.ajax({
				url : '/upload',
				type : 'post',
				data : formData,
				contentType : false,
				processData : false,
				success : function(data) {

					var str = "";
					if (checkImageType(data)) {
						str = "<div style='display:inline;'><img class='file_submit' src='/displayFile?fileName=" + data
								+ "'/><small data-src='" + data
								+ "'><button>X</button></small></div>"
					}

					$(".file").append(str);
				}

			});

		});
function checkImageType(fileName) {
	var pattern = /jpg|gif|png|jpeg/i;
	return fileName.match(pattern);
}
function getOriginalName(fileName) {
	if (checkImageType(fileName)) {
		return;
	}

	var idx = fileName.indexOf("_") + 1;
	return fileName.substr(idx);
}
function getImageLink(fileName) {
	if (!checkImageType(fileName)) {
		return;
	}
	var front = fileName.substr(0, 12);
	var end = fileName.substr(14);

	return front + end;
}
$('.file .seatmap .thumb').on('click', 'small ', function() {
	var that = $(this);

	$.ajax({
		url : "/deleteFile",
		type : "post",
		dataType : "text",
		data : {
			fileName : $(this).attr("data-src")
		},
		success : function(result) {
			if (result == 'deleted') {
				that.parent("div").remove();
			}
		}
	});

});

$('#write').submit(function(event){
	event.preventDefault();
	
	var that=$(this);
	var str="";
	$('.file_submit').each(function(index){
		str+="<input type='hidden' name='files'"
		+"value='"+$(this).attr('src')+"'>";
	});
	
	that.append(str);
	that.get(0).submit();
});
