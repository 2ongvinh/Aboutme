 $(document).ready(function() {
						$('.formAddNews').validate({
							ignore: [],
							rules : {
								tenbaiviet : {
									required : true,
								},
								tendanhmuc : {
									required : true,
									
								},
								mota : {
									required : true,
								},
								
							},
							messages : {
								tenbaiviet : {
									required : "Vui lòng nhập Tên Bài Viết",
								},
								tendanhmuc : {
									required : "Vui lòng chọn Danh Mục ",
									
								},
								mota : {
									required : "Vui lòng nhập Mô Tả",
								},
								
							}
						});
					}); 