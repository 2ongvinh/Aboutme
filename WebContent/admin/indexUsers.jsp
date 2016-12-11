<%@page import="library.PhanQuyen"%>
<%@page import="model.bean.Users"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>Quản lý người dùng</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
   <%ArrayList<Users> listUsers = (ArrayList<Users>)request.getAttribute("listUsers");
   	Users objUser = (Users)session.getAttribute("userInfo");
   %>
    <%@include file="/admin/inc/header.jsp"%>
        <div class="templatemo-content-container">
        <div>
       		<h2 class="margin-bottom-10" align="center">Người Dùng</h2>
         </div>
        <div class="templatemo-flex-row flex-content-row">
         <%if(objUser.getIdCapbac()==1){ %>
            <div class="templatemo-content-widget no-padding">
                       <a href="<%=request.getContextPath() %>/admin/themnguoidung" class="templatemo-add-btn">Thêm Người Dùng</a>
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
                    <td><a href="" class="white-text templatemo-sort-by">User Name <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Full Name <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Hình Ảnh <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Cấp Bậc <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Chức Năng <span class="caret"></span></a></td>
                  </tr>
                </thead>
                <tbody>
                <%
                if(listUsers.size()>0){
                	for(Users objUsers : listUsers){
                %>
                  <tr>
                    <td><%=objUsers.getIdUsers() %></td>
                    <td><%=objUsers.getUsername() %></td>
                    <td><%=objUsers.getFullname()%></td>
                    <td><img src="<%=request.getContextPath() %>/files/<%=objUsers.getPicture() %>" width="150px" height="100px"></td>
                    <td><%=objUsers.getTenCapbac()%></td>
                                      
                    <td>
					<%
						PhanQuyen pq=new PhanQuyen();
						if(pq.PqUser(objUser,objUsers)==1||pq.PqUser(objUser,objUsers)==3||pq.PqUser(objUser,objUsers)==5)	{
					%>      
						<a href="<%=request.getContextPath() %>/admin/suanguoidung?uid=<%=objUsers.getIdUsers() %>" class="templatemo-edit-btn">Edit</a>
					<%}else if(pq.PqUser(objUser,objUsers)==2||pq.PqUser(objUser,objUsers)==4) {%>               
                    <a href="<%=request.getContextPath() %>/admin/suanguoidung?uid=<%=objUsers.getIdUsers() %>" class="templatemo-edit-btn">Edit</a>
					<a href="<%=request.getContextPath() %>/admin/xoanguoidung?uid=<%=objUsers.getIdUsers() %>" class="templatemo-edit-btn" onclick="return getThongBao()">Delete</a></td>
                  	<%} %>
                  </tr>
                  
                  <%}} %>
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
					for(int i=1;i<=sumPage;i++){
						if(current_page == i){
							cl="class='active'";
						}else{
							cl="";
						}
				%> 
			<li <%=cl %>><a href="<%=request.getContextPath()%>/admin/nguoidung?page=<%=i%>"><%=i %></a></li>
			<%} %>
              <li>
                <a href="<%=request.getContextPath()%>/admin/nguoidung?page=<%=current_page+1%>" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-play"></i></span>
                </a>
              </li>
            </ul>
          </div>           
          <!-- Second row ends -->
          <div class="templatemo-flex-row flex-content-row">
            <div class="templatemo-content-widget white-bg col-2">
              <i class="fa fa-times"></i>
              <div class="media margin-bottom-30">
                <div class="media-left padding-right-25">
                  <a href="#">
                    <img class="media-object img-circle templatemo-img-bordered" src="images/person.jpg" alt="Sunset">
                  </a>
                </div>
                <div class="media-body">
                  <h2 class="media-heading text-uppercase blue-text">John Barnet</h2>
                  <p>Project Manager</p>
                </div>        
              </div>
              <div class="table-responsive">
                <table class="table">
                  <tbody>
                    <tr>
                      <td><div class="circle green-bg"></div></td>
                      <td>New Task Issued</td>
                      <td>02</td>                    
                    </tr> 
                    <tr>
                      <td><div class="circle pink-bg"></div></td>
                      <td>Task Pending</td>
                      <td>22</td>                    
                    </tr>  
                    <tr>
                      <td><div class="circle blue-bg"></div></td>
                      <td>Inbox</td>
                      <td>13</td>                    
                    </tr>  
                    <tr>
                      <td><div class="circle yellow-bg"></div></td>
                      <td>New Notification</td>
                      <td>18</td>                    
                    </tr>                                      
                  </tbody>
                </table>
              </div>             
            </div>
            <div class="templatemo-content-widget white-bg col-1 text-center templatemo-position-relative">
              <i class="fa fa-times"></i>
              <img src="images/person.jpg" alt="Bicycle" class="img-circle img-thumbnail margin-bottom-30">
              <h2 class="text-uppercase blue-text margin-bottom-5">Paul Smith</h2>
              <h3 class="text-uppercase margin-bottom-70">Managing Director</h3>
              <div class="templatemo-social-icons-container">
                <div class="social-icon-wrap">
                  <i class="fa fa-facebook templatemo-social-icon"></i>  
                </div>
                <div class="social-icon-wrap">
                  <i class="fa fa-twitter templatemo-social-icon"></i>  
                </div>
                <div class="social-icon-wrap">
                  <i class="fa fa-google-plus templatemo-social-icon"></i>  
                </div>                
              </div>
            </div>
            <div class="templatemo-content-widget white-bg col-1 templatemo-position-relative templatemo-content-img-bg">
              <img src="images/sunset-big.jpg" alt="Sunset" class="img-responsive content-bg-img">
              <i class="fa fa-heart"></i>
              <h2 class="templatemo-position-relative white-text">Sunset</h2>
              <div class="view-img-btn-wrap">
                <a href="" class="btn btn-default templatemo-view-img-btn">View</a>  
              </div>              
            </div>
          </div>
                   
          <%@include file="/admin/inc/footer.jsp"%>         
        </div>
      </div>
    </div>
    
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