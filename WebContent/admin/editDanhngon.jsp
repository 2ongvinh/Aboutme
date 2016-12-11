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
    <title>Sửa Danh Ngôn</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
   
    <%@include file="/admin/inc/header.jsp"%>
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget white-bg">
            <h2 class="margin-bottom-10">Sửa Danh Ngôn</h2>
            
            <%
            	DanhNgon objDN = (DanhNgon)request.getAttribute("objDN");
            %>
            
            <form enctype="multipart/form-data" action="<%=request.getContextPath() %>/admin/xl-suadanhngon?id=<%=objDN.getIdDN() %>"  method="post" class="formUsers">
              
              <div class="row form-group">
               <div class="col-lg-12 form-group">                  
                    <label for="inputNote">Danh Ngôn</label>
                    <textarea class="form-control" id="" rows="3" name="danhngon"><%=objDN.getNoidungDN()%></textarea>           
                </div>
                
              </div>
              <div class="row form-group">
                <div class="col-lg-12 form-group">                  
                    <label for="inputNote">Tác Giả</label>
                    <input type="text" class="form-control" id="inputNote" name="tacgia" value="<%=objDN.getTacgiaDN()%>">  
                </div>
              </div>
              
              
              <div class="row form-group">
                <div class="col-lg-12">
                  <label class="control-label templatemo-block">Hình Ảnh</label> 
                  <!-- <input type="file" name="fileToUpload" id="fileToUpload" class="margin-bottom-10"> -->
                  <input type="file" name="hinhanh" id="" class="filestyle" data-buttonName="btn-primary" data-buttonBefore="true" data-icon="false">
                   <br><img style="width:200px; height:150px;"  alt="" src="<%=request.getContextPath()%>/files/<%=objDN.getHinhanhDN()%>">
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
