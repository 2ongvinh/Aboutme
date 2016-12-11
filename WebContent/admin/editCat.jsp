<%@page import="model.bean.DanhMucTin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Thêm Danh Mục</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
   
    <%@include file="/admin/inc/header.jsp"%>
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget white-bg">
           <%
		if(request.getParameter("msg")!=null){
			int msg = Integer.parseInt(request.getParameter("msg"));
			if(msg==0){
				out.print("<p class='alert alert-success' style='font-weight:bold'>Trùng tên danh mục</p>");
			}
		}%>
            <h2 class="margin-bottom-10">Sửa Danh Mục</h2>
            
             <%
                    	DanhMucTin objDMT = (DanhMucTin)request.getAttribute("objDMT");
                    %>
                    
            <form action="<%=request.getContextPath() %>/admin/xl-suadanhmuc?cid=<%=objDMT.getIdDMT() %>"  method="post" class="formDanhMuc">
              
             <div class="row form-group">
                <div class="col-lg-12 form-group">                  
                    <label for="inputNote">Tên Danh Mục</label>
                   
                    <input type="text" class="form-control" id="inputNote" name="tendanhmuc" value="<%=objDMT.getTenDMT()%>">  
                </div>
              </div>
              <div class="form-group text-left">
                <button type="submit" class="templatemo-blue-button">Sửa</button>
                <button type="reset" class="templatemo-white-button">Nhập Lại</button>
              </div>                         
            </form>
          </div>
          
          <%@include file="/admin/inc/footer.jsp"%>
        </div>
      </div>
    </div>

    <!-- JS -->
    <script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script>  <!-- http://markusslima.github.io/bootstrap-filestyle/ -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>        <!-- Templatemo Script -->
  </body>
</html>
