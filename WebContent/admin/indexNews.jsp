<%@page import="model.dao.UsersDAO"%>
<%@page import="library.PhanQuyen"%>
<%@page import="model.bean.TinTuc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý bài viết</title>
<meta name="description" content="">
<meta name="author" content="templatemo">
<%
	
Users objUser = (Users)session.getAttribute("userInfo");
   %>
<%@include file="/admin/inc/header.jsp"%>

<div class="templatemo-content-container">
<div>
       		<h2 class="margin-bottom-10" align="center">Bài Viết</h2>
         </div>
	<div class="templatemo-flex-row flex-content-row">

		<div class="templatemo-content-widget no-padding">
			<a href="<%=request.getContextPath() %>/admin/thembaiviet" class="templatemo-add-btn">Thêm Bài Viết</a>
		</div>
	</div>
	 <div class="templatemo-content-widget no-padding" >
        <%
		if(request.getParameter("msg")!=null){
			int msg = Integer.parseInt(request.getParameter("msg"));
			if(msg==1){
				out.print("<p class='alert alert-success' style='font-weight:bold'>Thêm thành công</p>");
			}else if(msg==0){
				out.print("<p class='alert alert-success' style='font-weight:bold'>Thất Bại</p>");
			}else if(msg==3){
				out.print("<p class='alert alert-success' style='font-weight:bold'>Xóa thành công</p>");
			}else if(msg==2){
				out.print("<p class='alert alert-success' style='font-weight:bold'>Sửa thành công</p>");
			}
		}%>
		 </div>
	<div class="templatemo-content-widget no-padding">
		<div class="panel panel-default table-responsive">
		<form action="<%=request.getContextPath()%>/admin/delallNews" method="POST">
			<table id="myTable"
				class="table table-striped table-bordered templatemo-user-table">
				<thead>
					<tr>
						<td><a href="" class="white-text templatemo-sort-by">ID <span
								class="caret"></span>
						</a></td>
						<td><a href="" class="white-text templatemo-sort-by" >Tên
								<span class="caret"></span>
						</a></td>
						<td><a href="" class="white-text templatemo-sort-by">Danh
								Mục <span class="caret"></span>
						</a></td>
						<td><a href="" class="white-text templatemo-sort-by">Hình
								Ảnh <span class="caret"></span>
						</a></td>
						<td><a href="" class="white-text templatemo-sort-by">Ngày
								Đăng<span class="caret"></span>
						</a></td>
						<%if(objUser.getIdCapbac()==1 || objUser.getIdCapbac()==2){ %>
						<td><a href="" class="white-text templatemo-sort-by">Trạng
								Thái 
						</a></td>
						<%} %>
						<td><a href="" class="white-text templatemo-sort-by">Edit
						</a></td>
						<td><a href="" class="white-text templatemo-sort-by">Delete 
						</a></td>
						 <%if(objUser.getIdCapbac()==1){ %>
						<td><a href="" class="white-text templatemo-sort-by">Chọn 
						<input type="checkbox" name="chkAll" id="chkAll" value="" />
					              <label for="chkAll" class="font-weight-400"><span></span></label>
					              <input type="submit" name="dels" id="dels" value="Xóa" onclick="return valDels();" />
						
						</a></td>
						<%} %>
					</tr>
				</thead>
				<tbody>
				<%
					ArrayList<TinTuc> listTT = (ArrayList<TinTuc>)request.getAttribute("listTT");
					
					for(TinTuc objTT:listTT){
				%>
					<tr>
						<td><%=objTT.getIdTT() %></td>
						<td><%=objTT.getTenTT() %></td>
						<td><%=objTT.getTenDMT() %></td>
						<td><img src="<%=request.getContextPath() %>/files/<%=objTT.getHinhanhTT() %>" width="150px" height="100px"></td>
						<td><%=objTT.getNgaydang() %></td>
						<%if(objUser.getIdCapbac()==1 || objUser.getIdCapbac()==2){ %>
						<td id="active<%=objTT.getIdTT()%>"><center>
							<a href="javascript:void(0)" onclick="getActive(<%=objTT.getStatus() %>,<%=objTT.getIdTT()%>)">
								<%
									if(objTT.getStatus()==1){
								%>
								<img src="images/tick-circle.gif" alt="Trạng Thái">
								<%}else{ %>
								<img src="images/minus-circle.gif" alt="Trạng Thái">
								<%} %>
							</a>
							</center></td>
							<%} %>
						<td>
					<%
							UsersDAO usersDAO = new UsersDAO();
							Users nd=usersDAO.getItemByID(objTT.getIdUsers());
							
							PhanQuyen pq=new PhanQuyen();
						if(pq.PqUser(objUser,nd)==1||pq.PqUser(objUser,nd)==3||pq.PqUser(objUser,nd)==5)	{
					%>  <a href="<%=request.getContextPath() %>/admin/suabaiviet?nid=<%=objTT.getIdTT()%>" class="templatemo-edit-btn">Edit</a>
						<%}else if(pq.PqUser(objUser,nd)==2||pq.PqUser(objUser,nd)==4) {%>
						<a href="<%=request.getContextPath() %>/admin/suabaiviet?nid=<%=objTT.getIdTT()%>" class="templatemo-edit-btn">Edit</a>
						<br>
						
						<%} %>
						</td>
						<td>
							<%
								if(pq.PqUser(objUser, nd)!=0||pq.PqUser(objUser,nd)==2||pq.PqUser(objUser,nd)==4){
							%>
							<a href="<%=request.getContextPath() %>/admin/xoabaiviet?nid=<%=objTT.getIdTT()%>" class="templatemo-edit-btn" onclick="return getThongBao()">Delete</a>
							<%} %>
						</td>
						
						 <%if(objUser.getIdCapbac()==1){ %>
						<td class="text-center">
						
								<div class="margin-right-15 templatemo-inline-block">                      
					              <input type="checkbox" name="idCheckbox" id="<%=objTT.getIdTT() %>" value="<%=objTT.getIdTT() %>" />
					              <label for="<%=objTT.getIdTT() %>" class="font-weight-400"><span></span></label>
					            </div>
							</td>
						<%} %>
					</tr>
					<%} %>

				</tbody>
				<script type="text/javascript">
                function getThongBao(){
                	return confirm("Bạn có muốn xóa không?");
                }
                </script>
                <script type="text/javascript">
				function getActive(trangthai,nid){
					var id="#active"+nid;
					$.ajax({
						url: '<%=request.getContextPath() %>/admin/active',
						type: 'post',
						cache: false,
						data: {
								//Dữ liệu gửi đi
								anid: nid,
								atrangthai:trangthai
								},
						success: function(data){
							// Xử lý thành công
							$(id).html(data);
						},
						error: function (){
						// Xử lý nếu có lỗi
							alert("Có lỗi trong quá trình xử lý");
						}
					});
					return false;
				}
	</script>
			</table>
			</form>
		</div>

	</div>
<!-- 	<div class="pagination-wrap"> -->
<!-- 		<ul class="pagination"> -->
<%-- <%-- 		<% --%>
<!-- //   					int sumPage =(Integer)request.getAttribute("sumPage"); -->
<!-- //   					int current_page = (Integer)request.getAttribute("page"); -->
<!-- //   					String cl= ""; -->
<!-- //   					int i; -->
<!-- //  						for(i=1;i<=sumPage;i++){ -->
<!-- //  						if(current_page == i){  -->
<!-- //   							cl="class='active'"; -->
<!-- //   						}else{ -->
<!-- //   							cl="";  -->
<!-- //   						} -->
<%-- <%-- 				%>  --%> 
<%-- 			<li <%=cl %>><a href="<%=request.getContextPath()%>/admin/baiviet?page=<%=i%>"><%=i %></a></li> --%>
			
<%-- 			<%} %> --%>
<%-- 			<li><a href="<%=request.getContextPath()%>/admin/baiviet?page=<%=current_page+1%>" aria-label="Next"> <span aria-hidden="true"><i --%>
<!-- 						class="fa fa-play"></i></span> -->
<!-- 			</a></li> -->
<!-- 		</ul> -->
<!-- 	</div> -->
	<%@include file="/admin/inc/footer.jsp"%>
	<!-- JS -->
	<!-- jQuery -->
	<script type="text/javascript" src="js/templatemo-script.js"></script>
	<!-- Templatemo Script -->
	<script>
	$("#myTable").dataTable();
		$(document).ready(
				function() {
					// Content widget with background image
					var imageUrl = $('img.content-bg-img').attr('src');
					$('.templatemo-content-img-bg').css('background-image',
							'url(' + imageUrl + ')');
					$('img.content-bg-img').hide();
				});
	</script>
	<script type="text/javascript">
	function valDels()
	{
	    var checkedAtLeastOne = false;
	    $('input[type="checkbox"][name="idCheckbox"]').each(function() {
	        if ($(this).is(":checked")) {
	            checkedAtLeastOne = true;
	        }
	    });
	    if (checkedAtLeastOne == true){
			return confirm('Bạn có muốn xóa các mẫu tin đã chọn?');
	    } else {
	    	alert('Vui lòng chọn ít nhất 1 tin để xóa');
	    	return false;
	    }
	}

	$('#chkAll').click(function(event) {
	  if(this.checked) {
	      // Iterate each checkbox
	      $(':checkbox').each(function() {
	          this.checked = true;
	      });
	  }
	  else {
	    $(':checkbox').each(function() {
	          this.checked = false;
	      });
	  }
	});

	</script>
	</body>
</html>