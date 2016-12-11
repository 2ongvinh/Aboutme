<%@page import="model.bean.ThongTin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sửa Thông Tin</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
   
    <%@include file="/admin/inc/header.jsp"%>
        <div class="templatemo-content-container">
  <div class="templatemo-content-widget white-bg">
    <h2 class="margin-bottom-10">THÔNG TIN LIÊN HỆ</h2>
	<div class="module-body">
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
	<%
		ThongTin objThongTin = (ThongTin)request.getAttribute("objThongTin");
	%>
		<form method="post" novalidate="novalidate" action="<%=request.getContextPath()%>/admin/xl-suathongtin?id=1">
			<div class="row form-group">
		        <div class="col-lg-8 form-group">                   
		            <label class="control-label">Địa chỉ</label>
		            <input type="text" class="form-control" name="diachi" value="<%=objThongTin.getDiachi() %>" placeholder="Nhập địa chỉ">
		        </div>
		        <div class="col-lg-4 form-group">                   
		            <label class="control-label">Số điện thoại</label>
		            <input type="text" class="form-control" name="sdt" value="<%=objThongTin.getPhone() %>" placeholder="Nhập số điện thoại">
		        </div>
		    </div>
		    <div class="row form-group">
		        
		        <div class="col-lg-4 form-group">                   
		            <label class="control-label">Email</label>
		            <input type="text" class="form-control" name="email" value="<%=objThongTin.getEmail()%>" placeholder="Nhập email">
		        </div>
		        <div class="col-lg-4 form-group">                   
		            <label class="control-label">Skype</label>
		            <input type="text" class="form-control" name="skype" value="<%=objThongTin.getSkype() %>" placeholder="Nhập Skype">
		        </div>
		        <div class="col-lg-4 form-group">                   
		            <label class="control-label">Wordpress</label>
		            <input type="text" class="form-control" name="wordpress" value="<%=objThongTin.getWordpress() %>" placeholder="Nhập link Wordpress">
		        </div>
		    </div>

		    <div class="row form-group">
		        <div class="col-lg-6 form-group">                   
		            <label class="control-label">Facebook</label>
		            <input type="text" class="form-control" name="facebook" value="<%=objThongTin.getFacebook() %>" placeholder="Nhập tên username Facebook">
		        </div>
		        <div class="col-lg-6 form-group">                   
		            <label class="control-label">Link Facebook</label>
		            <input type="text" class="form-control" name="linkfacebook" value="<%=objThongTin.getLinkfacebook() %>" placeholder="Nhập link Facebook">
		        </div>
		    </div>
		    <div class="row form-group">
		        <div class="col-lg-6 form-group">                   
		            <label class="control-label">Twitter</label>
		            <input type="text" class="form-control" name="twitter" value=" <%=objThongTin.getTwitter() %>" placeholder="Nhập tên username Twitter">
		        </div>
		        <div class="col-lg-6 form-group">                   
		            <label class="control-label">Link Twitter</label>
		            <input type="text" class="form-control" name="linktwitter" value="<%=objThongTin.getLinktwitter() %>" placeholder="Nhập link Twitter">
		        </div>
		    </div>
		    
		    <div class="row form-group">
		        <div class="col-lg-6 form-group">                   
		            <label class="control-label">Google Plus</label>
		            <input type="text" class="form-control" name="googleplus" value="<%=objThongTin.getGoogleplus()%>" placeholder="Nhập tên username Google Plus">
		        </div>
		        <div class="col-lg-6 form-group">                   
		            <label class="control-label">Link Google Plus</label>
		            <input type="text" class="form-control" name="linkgoogleplus" value="<%=objThongTin.getLinkgoogleplus() %>" placeholder="Nhập link Google Plus">
		        </div>
		    </div>

			<div class="form-group text-left">
		        <input type="submit" class="templatemo-blue-button" name="sua" value="Cập nhật">
		        <input type="reset" class="templatemo-white-button" name="reset" value="Nhập lại">
		    </div> 
		</form>
	</div> <!-- End .module-body -->
 </div> 

          <%@include file="/admin/inc/footer.jsp"%>
        </div>
      </div>
    </div>

    <!-- JS -->
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>        <!-- jQuery -->
    <script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script>  <!-- http://markusslima.github.io/bootstrap-filestyle/ -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>        <!-- Templatemo Script -->
  </body>
</html>
