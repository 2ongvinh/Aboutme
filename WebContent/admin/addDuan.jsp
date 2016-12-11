<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Thêm Dự Án</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
   
    <%@include file="/admin/inc/header.jsp"%>
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget white-bg">
            <h2 class="margin-bottom-10">Thêm Dự Án (*)</h2>
            <form enctype="multipart/form-data" action="<%=request.getContextPath() %>/admin/xl-themduan"  method="post" class="formDuAn">
              
             <div class="row form-group">
                <div class="col-lg-12 form-group">                  
                    <label for="inputNote">Tên Dự Án (*)</label>
                    <input type="text" class="form-control" id="" name="tenduan" >                  
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
                    <label for="inputNote">Mô Tả (*)</label>
                    <textarea class="form-control" id="" rows="3" name="mota"></textarea>           
                </div>
              </div>
              <div class="row form-group">
                <div class="col-lg-12 form-group">                  
                    <label for="inputNote">Liên Kết (*)</label>
                    <input type="text" class="form-control" id="" name="link">                  
                </div>
              </div>
              <div class="form-group text-left">
                <button type="submit" class="templatemo-blue-button">Thêm</button>
                <button type="reset" class="templatemo-white-button">Nhập Lại</button>
              </div>    
               <script type="text/javascript">
              $(document).ready(function() {
					$('.formDuAn').validate({
						ignore: [],
						rules : {
							tenduan : {
								required : true,
							},
							mota : {
								required : true,
								
							},
							link : {
								required : true,
								
							},
							
						},
						messages : {
							tenduan : {
								required : "Vui lòng nhập tên dự án",
							},
							mota : {
								required : "Vui lòng nhập mô tả ",
								
							},
							link : {
								required : "Vui lòng nhập liên kết ",
								
							},
							
						}
					});
				}); 
					
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
