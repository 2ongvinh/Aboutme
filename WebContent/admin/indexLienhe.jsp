<%@page import="model.bean.LienHe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>Quản lý liên hệ</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
   <%Users objUser = (Users)session.getAttribute("userInfo"); %>
    <%@include file="/admin/inc/header.jsp"%>
        <div class="templatemo-content-container" id="lienhe">
        <div>
       		<h2 class="margin-bottom-10" align="center">Liên Hệ</h2>
         </div>
        <div class="templatemo-flex-row flex-content-row">
           
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
			}else if(msg==4){
				out.print("<p class='alert alert-success' style='font-weight:bold'>Sửa thành công</p>");
			}
		}%>
		 </div>
        <div class="templatemo-content-widget no-padding" >
            <div class="panel panel-default table-responsive" >
            <form action="<%=request.getContextPath()%>/admin/delallLienHe" method="POST">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by">ID <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Tên<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Email<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Phone<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Nội Dung<span class="caret"></span></a></td>
                      <%if(objUser.getIdCapbac()==1){ %>
                    <td><a href="" class="white-text templatemo-sort-by">Chức Năng <span class="caret"></span></a></td>
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
                	ArrayList<LienHe> listLH = (ArrayList<LienHe>)request.getAttribute("listLH");
                	for(LienHe objLH : listLH){
                %>
                  <tr>
                    <td><%=objLH.getIdLienhe() %></td>
                    <td><%=objLH.getTenLienhe() %></td>
                     <td><%=objLH.getEmailLienhe() %></td>
                      <td><%=objLH.getSdtLienhe() %></td>
                       <td><%=objLH.getNoidungLienhe() %></td>
                         <%if(objUser.getIdCapbac()==1){ %>
                    <td>
                    <a href="javascript: void(0)" onclick="viewLienHe(<%=objLH.getIdLienhe()%>)" class="templatemo-edit-btn" onclick="return viewLienHe()">Xem</a>
                    <a href="<%=request.getContextPath() %>/admin/xoalienhe?id=<%=objLH.getIdLienhe()%>" class="templatemo-edit-btn" onclick="return getThongBao()">Delete</a>
             		</td>
                	 <td class="text-center">
						
								<div class="margin-right-15 templatemo-inline-block">                      
					              <input type="checkbox" name="idCheckbox" id="<%=objLH.getIdLienhe() %>" value="<%=objLH.getIdLienhe() %>" />
					              <label for="<%=objLH.getIdLienhe() %>" class="font-weight-400"><span></span></label>
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
              </table>   
              </form> 
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
			<li <%=cl %>><a href="<%=request.getContextPath()%>/admin/lienhe?page=<%=i%>"><%=i %></a></li>
			
			<%} %>
              <li>
                <a href="<%=request.getContextPath()%>/admin/lienhe?page=<%=current_page+1%>" aria-label="Next">
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
	<script type="text/javascript">
				
				function viewLienHe(idLH1){
					
					$.ajax({
						url: '<%=request.getContextPath()%>/admin/xemlienhe',
								type : 'post',
								cache : false,
								data : {
									aidLH1 : idLH1
								},

								success : function(data) {
									// Xử lý thành công
									$("#lienhe").html(data);
								},
								error : function() {
									// Xử lý nếu có lỗi
									alert("Có lỗi trong quá trình xử lý");
								}
							});
					return false;
				}
			</script>
  </body>
</html>