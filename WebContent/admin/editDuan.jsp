<%@page import="model.bean.DuAn"%>
<%@page import="model.bean.DanhNgon"%>
<%@page import="model.bean.Gioithieu"%>
<%@page import="model.bean.Users"%>
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
    <title>Sửa Dự Án</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
   
    <%@include file="/admin/inc/header.jsp"%>
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget white-bg">
            <h2 class="margin-bottom-10">Sửa Dự Án</h2>
            
            <%
            	DuAn objDA = (DuAn)request.getAttribute("objDA");
            %>
            
            <form enctype="multipart/form-data" action="<%=request.getContextPath() %>/admin/xl-suaduan?id=<%=objDA.getIdDuan() %>"  method="post" class="formUsers">
              
              <div class="row form-group">
                <div class="col-lg-12 form-group">                  
                    <label for="inputNote">Tên Dự Án</label>
                    <input type="text" class="form-control" id="inputNote" name="tenduan" value="<%=objDA.getTenDuan()%>">  
                </div>
              </div>
              
              <div class="row form-group">
                <div class="col-lg-12">
                  <label class="control-label templatemo-block">Hình Ảnh</label> 
                  <!-- <input type="file" name="fileToUpload" id="fileToUpload" class="margin-bottom-10"> -->
                  <input type="file" name="hinhanh" id="" class="filestyle" data-buttonName="btn-primary" data-buttonBefore="true" data-icon="false">
                   <br><img style="width:200px; height:150px;"  alt="" src="<%=request.getContextPath()%>/files/<%=objDA.getHinhanhDuan()%>">
                </div>
              </div>
              
              <div class="row form-group">
                <div class="col-lg-12 form-group">                  
                    <label for="inputNote">Mô Tả</label>
                    <input type="text" class="form-control" id="inputNote" name="mota" value="<%=objDA.getMotaDuan()%>">  
                </div>
              </div>
              
              <div class="row form-group">
                <div class="col-lg-12 form-group">                  
                    <label for="inputNote">Liên Kết</label>
                    <input type="text" class="form-control" id="inputNote" name="link" value="<%=objDA.getLinkDuan()%>">  
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
