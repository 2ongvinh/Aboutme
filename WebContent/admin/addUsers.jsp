<%@page import="model.bean.CapBac"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Thêm Người Dùng</title>
<meta name="description" content="">
<meta name="author" content="templatemo">

<%@include file="/admin/inc/header.jsp"%>
<div class="templatemo-content-container">
	<div class="templatemo-content-widget white-bg">
		<%
			if (request.getParameter("msg") != null) {
				int msg = Integer.parseInt(request.getParameter("msg"));
				if (msg == 5) {
					out.print("<p class='alert alert-success' style='font-weight:bold'>Trùng tên người dùng</p>");
				}
			}
		%>
		<h2 class="margin-bottom-10">Thêm Người Dùng</h2>
		<form name=xyz onSubmit="return doanothercheck(this.username,this.fullname);" 
			enctype="multipart/form-data"
			action="<%=request.getContextPath()%>/admin/xl-themnguoidung"
			method="post" class="formUsers">

			<div class="row form-group">
				<div class="col-lg-6 col-md-6 form-group" id="availability">
					<label for="inputFirstName">Username (*)</label> <input type="text"
						class="form-control" id="username" name="username" value=""
						onchange="return checkUsername(); " 
						onKeyUp="javascript:dodacheck(xyz.username);"> <span
						style="color: red"></span>
				</div>
				<div class="col-lg-6 col-md-6 form-group">
					<label for="inputLastName">Password (*)</label> <input type="text"
						class="form-control" id="" name="password">
				</div>
			</div>
			<div class="row form-group">
				<div class="col-lg-6 col-md-6 form-group">
					<label for="inputUsername">Fullname</label> <input type="text"
					onKeyUp="javascript:dodacheck(xyz.fullname);"
						class="form-control" id="fullname" name="fullname">
				</div>
				<div class="col-lg-6 col-md-6 form-group">
					<label class="control-label templatemo-block">Cấp Bậc (*)</label> <select
						class="form-control" name="capbac">
						<option value="">Chọn cấp bậc</option>
						<%
							if (request.getAttribute("listCapBac") != null) {
								ArrayList<CapBac> listCapBac = (ArrayList<CapBac>) request.getAttribute("listCapBac");
								if (listCapBac.size() > 0) {
									for (CapBac objCapBac : listCapBac) {
						%>
						<option value="<%=objCapBac.getIdCapbac()%>"><%=objCapBac.getTenCapbac()%></option>
						<%
							}
								}
							}
						%>
					</select>
				</div>
			</div>


			<div class="row form-group">
				<div class="col-lg-12">
					<label class="control-label templatemo-block">Hình Ảnh</label>
					<!-- <input type="file" name="fileToUpload" id="fileToUpload" class="margin-bottom-10"> -->
					<input type="file" name="hinhanh" id="" class="filestyle"
						data-buttonName="btn-primary" data-buttonBefore="true"
						data-icon="false">
				</div>
			</div>

			<div class="form-group text-left">
				<button type="submit" class="templatemo-blue-button">Thêm</button>
				<button type="reset" class="templatemo-white-button">Nhập
					Lại</button>
			</div>

			<script type="text/javascript">
            
              $(document).ready(function() {
					$('.formUsers').validate({
					
						rules : {
							username : {
								required : true,
							},
							password : {
								required : true,
								
							},
							capbac : {
								required : true,
								
							},
							
							
							
						},
						messages : {
							username : {
								required : "Vui lòng nhập Username",
							},
							password : {
								required : "Vui lòng nhập Password ",
								
							},
							capbac : {
								required : "Vui lòng chọn Cấp bậc ",
								
							},
						}
					});
				}); 
					
				</script>
			<script type="text/javascript">
				
				function checkUsername(){
						var username = $("#username").val();
					$.ajax({
						url: '<%=request.getContextPath()%>/admin/checkusername',
								type : 'post',
								cache : false,
								data : {
									//Dữ liệu gửi đi
									ausername : username
								},

								success : function(data) {
									// Xử lý thành công
									$("#availability").html(data);
								},
								error : function() {
									// Xử lý nếu có lỗi
									alert("Có lỗi trong quá trình xử lý");
								}
							});
					return false;
				}
			</script>
			<SCRIPT type="text/javascript">
				var mikExp = /[$\\@\\\#%\^\&\*\(\)\[\]\+\_\{\}\`\~\=\|\<\>\?\,\.\/]/;
				function dodacheck(val) {
					var strPass = val.value;
					var strLength = strPass.length;
					var lchar = val.value.charAt((strLength) - 1);
					if (lchar.search(mikExp) != -1) {
						var tst = val.value.substring(0, (strLength) - 1);
						val.value = tst;
					}
				}
				function doanothercheck(form) {
					
					if(form.value.search(mikExp) != -1) {
						alert("Sorry, but the following characters\n\r\n\r@ $ % ^ & * # ( ) [ ] \\ { + } ` ~ =  | \n\r\n\rare not allowed!\n");
						form.select();
						form.focus();
						return false;
					}
					
				}
			</script>
		</form>
	</div>
	<%@include file="/admin/inc/footer.jsp"%>
</div>
</div>
</div>

<!-- JS -->
<script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script>
<!-- http://markusslima.github.io/bootstrap-filestyle/ -->
<script type="text/javascript" src="js/templatemo-script.js"></script>
<!-- Templatemo Script -->
</body>
</html>
