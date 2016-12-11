<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Thêm Danh Ngôn</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
   
    <%@include file="/admin/inc/header.jsp"%>
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget white-bg">
            <h2 class="margin-bottom-10">Thêm Danh Ngôn</h2>
            <form enctype="multipart/form-data" action="<%=request.getContextPath() %>/admin/xl-themdanhngon"  method="post" class="formDanhNgon">
              
             <div class="row form-group">
                 <div class="col-lg-12 form-group">                  
                    <label for="inputNote">Danh Ngôn (*)</label>
                    <textarea class="form-control" id="" rows="3" name="danhngon"></textarea>           
                </div>
              </div>
              <div class="row form-group">
                <div class="col-lg-12 form-group">                  
                    <label for="inputNote">Tác Giả (*)</label>
                    <input type="text" class="form-control" id="" name="tacgia">                  
                </div>
              </div>
              <div class="row form-group">
                <div class="col-lg-12">
                  <label class="control-label templatemo-block">Hình Ảnh</label> 
                  <!-- <input type="file" name="fileToUpload" id="fileToUpload" class="margin-bottom-10"> -->
                  <input type="file" name="hinhanh" id="" class="filestyle" data-buttonName="btn-primary" data-buttonBefore="true" data-icon="false">
                </div>
              </div>
              <div class="form-group text-left">
                <button type="submit" class="templatemo-blue-button">Thêm</button>
                <button type="reset" class="templatemo-white-button">Nhập Lại</button>
              </div>                           
            </form>
             <script type="text/javascript">
              $(document).ready(function() {
					$('.formDanhNgon').validate({
						ignore: [],
						rules : {
							danhngon : {
								required : true,
							},
							tacgia : {
								required : true,
								
							},
							
						},
						messages : {
							danhngon : {
								required : "Vui lòng nhập danh ngôn",
							},
							tacgia : {
								required : "Vui lòng nhập tác giả",
								
							},
							
						}
					});
				}); 
					
				</script>    
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
