<%@page import="model.bean.DanhMucTin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Thêm Bài Viết</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    
<%--    <%=request.getContextPath() %>/admin/xl-thembaiviet --%>
    <%@include file="/admin/inc/header.jsp"%>
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget white-bg">
            <h2 class="margin-bottom-10">Thêm Bài Viết</h2>
            <form name="xyz" onSubmit="return doanothercheck(this.mota);"
            enctype="multipart/form-data" action="<%=request.getContextPath() %>/admin/xl-thembaiviet"  method="post" class="formAddNews" >
               
              <div class="row form-group">
                <div class="col-lg-12 form-group">                  
                    <label for="inputNote">Tên Bài Viết (*)</label>
                    <input type="text" class="form-control " id="" name="tenbaiviet">                  
                </div>
              </div>
              <div class="row form-group">
             	 <div class="col-lg-6 col-md-6 form-group"> 
                  <label class="control-label templatemo-block">Danh Mục (*)</label>    
                  <select class="form-control" name="tendanhmuc">
                  <option value="">Chọn danh mục</option>
                  <%
              			if(request.getAttribute("listDMT")!=null){
              			ArrayList<DanhMucTin> listDMT = (ArrayList<DanhMucTin>)request.getAttribute("listDMT");
              			if(listDMT.size()>0){
              				for(DanhMucTin objDMT : listDMT){
              	
           			   %>   
                    <option value="<%=objDMT.getIdDMT() %>"><%=objDMT.getTenDMT() %></option>
                    <%}} }%>
                  </select>
                </div>
                
              </div>
              <div class="row form-group">
            	 <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputLastName">Ngày Đăng</label>
                    <input type="datetime-local" class="form-control" id="" name="ngaydang">                  
                </div> 
              </div>
              <div class="row form-group">
                <div class="col-lg-12">
                  <label class="control-label templatemo-block">Hình Ảnh</label> 
                  <!-- <input type="file" name="fileToUpload" id="fileToUpload" class="margin-bottom-10"> -->
                  <input type="file" name="hinhanh" id="" class="filestyle" data-buttonName="btn-primary" data-buttonBefore="true" data-icon="false">
                </div>
              </div>
              <div class="row form-group">
                <div class="col-lg-12 form-group">                   
                    <label class="control-label" for="inputNote">Mô Tả (*)</label>
                    <textarea class="form-control" id="" rows="3" name="mota" onKeyUp="javascript:dodacheck(xyz.mota);"></textarea>
                </div>
              </div>
              <div class="row form-group">
                <div class="col-lg-12 form-group">                   
                    <label class="control-label" for="inputNote">Nội Dung (*)</label>
                    <textarea class="form-control ckeditor" id="" rows="7" name="noidung"></textarea>
                </div>
                <script type="text/javascript">      
				    CKFinder.setupCKEditor(editor,'/ckeditor/'); 
				    </script>
              </div>
              <div class="form-group text-left">
                <button type="submit" class="templatemo-blue-button">Thêm</button>
                <button type="reset" class="templatemo-white-button">Nhập Lại</button>
              </div>     
              <script type="text/javascript">
              $(document).ready(function() {
					$('.formAddNews').validate({
						ignore: [],
						rules : {
							tenbaiviet : {
								required : true,
							},
							tendanhmuc : {
								required : true,
								
							},
							mota : {
								required : true,
							},
							

						},
						messages : {
							tenbaiviet : {
								required : "Vui lòng nhập Tên Bài Viết",
							},
							tendanhmuc : {
								required : "Vui lòng chọn Danh Mục ",
								
							},
							mota : {
								required : "Vui lòng nhập Mô Tả",
							},
							
							
						}
					});
				}); 
					
				</script> 
				<SCRIPT type="text/javascript">
				var mikExp = /[$\\@\\\#%\^\&\*\(\)\[\]\+\_\{\}\`\~\=\|\<\>\?\/]/;
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
