$(".thumbDrop").on("dragenter dragover", function(event) {
	event.preventDefault();
});
$(".thumbDrop").on(
		"drop",
		function(event) {
			event.preventDefault();

			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];

			var formData = new FormData();
			formData.append("file", file);

			$.ajax({
				url : '/ticket/upload',
				type : 'post',
				data : formData,
				contentType : false,
				processData : false,
				success : function(data) {

					var str = "";
					if (checkImageType(data)) {
						str = "<div><img src='displayFile?fileName=" + data
								+ "'/><small data-src='" + data
								+ "'><input type='hidden' name='thumb' value="+data+"<button>X</button></small></div>"
					}

					$('.thumbList').append(str);
				}

			});

		});
$(".seatmapDrop").on("dragenter dragover", function(event) {
	event.preventDefault();
});
$(".seatmapDrop").on(
		"drop",
		function(event) {
			event.preventDefault();

			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];

			var formData = new FormData();
			formData.append("file", file);

			$.ajax({
				url : '/ticket/upload',
				type : 'post',
				data : formData,
				contentType : false,
				processData : false,
				success : function(data) {

					var str = "";
					if (checkImageType(data)) {
						str = "<div><img src='displayFile?fileName=" + data
								+ "'/><small data-src='" + data
								+ "'><button>X</button></small></div>"
					}

					$('.uploadedList').append(str);
				}

			});

		});
$(".fileDrop").on("dragenter dragover", function(event) {
	event.preventDefault();
});
$(".fileDrop").on(
		"drop",
		function(event) {
			event.preventDefault();

			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];

			var formData = new FormData();
			formData.append("file", file);

			$.ajax({
				url : '/ticket/upload',
				type : 'post',
				data : formData,
				contentType : false,
				processData : false,
				success : function(data) {

					var str = "";
					if (checkImageType(data)) {
						str = "<div><img src='displayFile?fileName=" + data
								+ "'/><small data-src='" + data
								+ "'><button>X</button></small></div>"
					}

					$('.uploadedList').append(str);
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
$('.uploadedList').on('click', 'small ', function() {
	var that = $(this);

	$.ajax({
		url : "deleteFile",
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
