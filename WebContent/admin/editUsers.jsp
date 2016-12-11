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
    <title>Sửa Người Dùng</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    <%Users objUser = (Users)session.getAttribute("userInfo"); %>
    <%@include file="/admin/inc/header.jsp"%>
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget white-bg">
            <h2 class="margin-bottom-10">Sửa Người Dùng</h2>
            <%
			if (request.getParameter("msg") != null) {
				int msg = Integer.parseInt(request.getParameter("msg"));
				if (msg == 5) {
					out.print("<p class='alert alert-success' style='font-weight:bold'>Trùng tên người dùng</p>");
				}
			}
		%>
            
            <%
            	Users objUsers = (Users)request.getAttribute("objUsers");
            %>
            <form name="xyz" onSubmit="return doanothercheck(this.username,this.fullname);" 
            enctype="multipart/form-data" action="<%=request.getContextPath() %>/admin/xl-suanguoidung?uid=<%=objUsers.getIdUsers() %>"  method="post" class="formUsers">
              
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputFirstName">Username</label>
                    <input type="text" class="form-control" id="" name="username" value="<%=objUsers.getUsername()%>" onKeyUp="javascript:dodacheck(xyz.username);">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputLastName">Password</label>
                    <input type="password" class="form-control" id="" name="password" value="<%=objUsers.getPassword()%>">                  
                </div> 
              </div>
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputUsername">Fullname</label>
                    <input type="text" class="form-control" id="" name="fullname" value="<%=objUsers.getFullname()%>" >                  
                </div>
                <%if(objUser.getIdCapbac()==1){ %>
                <div class="col-lg-6 col-md-6 form-group"> 
                  <label class="control-label templatemo-block">Cấp Bậc</label>                 
                  <select class="form-control" name="capbac">
                   
                    <%
                    if(request.getAttribute("listCapBac")!=null){
                    	ArrayList<CapBac> listCapBac = (ArrayList<CapBac>)request.getAttribute("listCapBac");
                    	if(listCapBac.size()>0){
                    		String selected = "";
                    		for(CapBac objCapBac : listCapBac){
                    			if(objCapBac.getIdCapbac() == objUsers.getIdCapbac()){
				    				selected = "selected = 'selected'";
				    			}else{
				    				selected = "";
				    			}
                    %>
                    <option <%=selected%> value="<%=objCapBac.getIdCapbac()%>"><%=objCapBac.getTenCapbac() %></option>      
                    <%} }}%>                
                  </select>
                </div>
              </div>
              
              <%}else{ %>
              <div class="col-lg-6 col-md-6 form-group"> 
                  <label class="control-label templatemo-block">Cấp Bậc</label>                 
                  <select disabled class="form-control" name="capbac">
                  
                    <%
                    if(request.getAttribute("listCapBac")!=null){
                    	ArrayList<CapBac> listCapBac = (ArrayList<CapBac>)request.getAttribute("listCapBac");
                    	if(listCapBac.size()>0){
                    		String selected = "";
                    		for(CapBac objCapBac : listCapBac){
                    			if(objCapBac.getIdCapbac() == objUsers.getIdCapbac()){
				    				selected = "selected = 'selected'";
				    			}else{
				    				selected = "";
				    			}
                    %>
                    <option <%=selected%> value="<%=objCapBac.getIdCapbac()%>"><%=objCapBac.getTenCapbac() %></option>      
                    <%} }}%>                
                  </select>
                </div>
              </div>
              <%} %>
              <div class="row form-group">
                <div class="col-lg-12">
                  <label class="control-label templatemo-block">Hình Ảnh</label> 
                  <!-- <input type="file" name="fileToUpload" id="fileToUpload" class="margin-bottom-10"> -->
                  <input type="file" name="hinhanh" id="" class="filestyle" data-buttonName="btn-primary" data-buttonBefore="true" data-icon="false">
                   <br><img style="width:200px; height:150px;"  alt="" src="<%=request.getContextPath()%>/files/<%=objUsers.getPicture()%>">
                </div>
              </div>
             
              <div class="form-group text-left">
                <button type="submit" class="templatemo-blue-button">Sửa</button>
                <button type="reset" class="templatemo-white-button">Nhập Lại</button>
              </div>  
                 
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
    <script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script>  <!-- http://markusslima.github.io/bootstrap-filestyle/ -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>        <!-- Templatemo Script -->
  </body>
</html>
