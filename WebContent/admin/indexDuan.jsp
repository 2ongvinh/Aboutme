<%@page import="model.bean.DuAn"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>Quản lý dự án</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
   <%
   	Users objUser = (Users)session.getAttribute("userInfo");
   %>
    <%@include file="/admin/inc/header.jsp"%>
        <div class="templatemo-content-container">
        <div>
       		<h2 class="margin-bottom-10" align="center">Dự Án</h2>
         </div>
        <div class="templatemo-flex-row flex-content-row">
        <%if(objUser.getIdCapbac()==1){ %>
            <div class="templatemo-content-widget no-padding">
                       <a href="<%=request.getContextPath() %>/admin/themduan" class="templatemo-add-btn">Thêm Dự Án</a>
            </div>
            <%} %>
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
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by">ID <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Tên Dự Án<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Hình Ảnh <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Mô Tả <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Link <span class="caret"></span></a></td>
                    <%if(objUser.getIdCapbac()==1){ %>
                    <td><a href="" class="white-text templatemo-sort-by">Edit<span class="caret"></span>
						</a></td>
						<td><a href="" class="white-text templatemo-sort-by">Delete <span class="caret"></span>
						</a></td>
						<%} %>
                  </tr>
                </thead>
                <tbody>
                <%
                	ArrayList<DuAn> listDuAn = (ArrayList<DuAn>)request.getAttribute("listDuAn");
                	for(DuAn objDuAn : listDuAn){
                %>
                  <tr>
                    <td><%=objDuAn.getIdDuan() %></td>
                    <td><%=objDuAn.getTenDuan() %></td>
                    <td><img src="<%=request.getContextPath() %>/files/<%=objDuAn.getHinhanhDuan() %>" width="150px" height="100px"/></td>
                    <td><%=objDuAn.getMotaDuan() %></td>
                    <td><%=objDuAn.getLinkDuan() %></td>
                    <%if(objUser.getIdCapbac()==1){ %>
                    <td><a href="<%=request.getContextPath() %>/admin/suaduan?id=<%=objDuAn.getIdDuan() %>" class="templatemo-edit-btn">Edit</a></td>
						<td><a href="<%=request.getContextPath() %>/admin/xoaduan?id=<%=objDuAn.getIdDuan() %>" class="templatemo-edit-btn" onclick="return getThongBao()">Delete</a></td>
                 <%} %>
                  </tr>
                  
                    <%} %>
                </tbody>
                <script type="text/javascript">
                function getThongBao(){
                	return confirm("Bạn có muốn xóa không?");
                }
                </script>
              </table>    
            </div>                          
          </div>          
           <div class="pagination-wrap">
            <ul class="pagination">
              <%
					int sumPage =(Integer)request.getAttribute("sumPage");
					int current_page = (Integer)request.getAttribute("page");
					String cl= "";
					int i;
					for(i=1;i<=sumPage;i++){
						if(current_page == i){
							cl="class='active'";
						}else{
							cl="";
						}
				%> 
			<li <%=cl %>><a href="<%=request.getContextPath()%>/admin/duan?page=<%=i%>"><%=i %></a></li>
			
			<%} %>
              <li>
                <a href="<%=request.getContextPath()%>/admin/duan?page=<%=current_page+1%>" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-play"></i></span>
                </a>
              </li>
            </ul>
          </div>   
           <%@include file="/admin/inc/footer.jsp"%>  
    <!-- JS -->
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->
    <script>
      $(document).ready(function(){
        // Content widget with background image
        var imageUrl = $('img.content-bg-img').attr('src');
        $('.templatemo-content-img-bg').css('background-image', 'url(' + imageUrl + ')');
        $('img.content-bg-img').hide();        
      });
    </script>
  </body>
</html>