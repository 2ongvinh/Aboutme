<%@page import="model.bean.Users"%>
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
    <title>Visual Admin Dashboard - Home</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    <!-- 
    Visual Admin Template
    http://www.templatemo.com/preview/templatemo_455_visual_admin
    -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/templatemo-style.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>

  <body>  
   <%@include file="/admin/inc/header.jsp"%>
    <%Users objUser = (Users)session.getAttribute("userInfo"); %>
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget no-padding" >
  <%
if(request.getParameter("msg")!=null){
	int msg = Integer.parseInt(request.getParameter("msg"));
	if(msg==1){
		out.print("<p class='alert alert-success' style='font-weight:bold'>Đăng nhập thành công</p>");
	}
	
}%>
</div>
          <div class="templatemo-flex-row flex-content-row">
            <div class="templatemo-content-widget white-bg col-2">
			<i class="fa fa-times"></i>
			<div class="square"></div>
			<h2 class="templatemo-inline-block">Admin</h2><hr>
			<p>Chương trình được viết bằng SPRING FRAMEWORK</p>
			<p>Thực hiện: VinaEnter Edu</p>
			<p>Email: info@vinaenter.com</p>
			<p>Số ĐT: 0905.051.720</p>
		</div>
		<div class="templatemo-content-widget white-bg col-2">
		<%if(objUser.getIdCapbac()==1){ %>
		<a href="<%=request.getContextPath() %>/admin/themdanhmuc" title="Add" class="templatemo-add-btn">Add</a>
		<%} %>
		<h2 class="text-uppercase" style="text-align: center; padding-bottom: 10px;">Danh mục tin</h2>
		<table class="table table-striped table-bordered templatemo-user-table">
			<thead>
				<tr align="center">
					<td>ID</td>
					<td>Tên chuyên mục</td>
				<%if(objUser.getIdCapbac()==1){ %>
					<td>Edit</td>
					<td>Delete</td>
				<%} %>
				</tr>
			</thead>
			<tbody>
			<%
				ArrayList<DanhMucTin> listDMT = (ArrayList<DanhMucTin>)request.getAttribute("listDMT");
				for(DanhMucTin objDMT : listDMT){
			%>
				<tr align="center">
					<td align="center"><%=objDMT.getIdDMT() %></td>
					<td><%=objDMT.getTenDMT() %></td>
					<%if(objUser.getIdCapbac()==1){ %>
					<td align="center"><a href="<%=request.getContextPath() %>/admin/suadanhmuc?cid=<%=objDMT.getIdDMT() %>" class="templatemo-edit-btn">Edit</a></td>
					<td align="center"><a href="<%=request.getContextPath() %>/admin/xoadanhmuc?cid=<%=objDMT.getIdDMT() %>" class="templatemo-edit-btn" onclick="return getThongBao()">Delete</a></td>
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
    <script type="text/javascript" src="js/loader.js"></script> 
  	
  	<div class="templatemo-flex-row flex-content-row">
		<div class="templatemo-content-widget white-bg col-2">
			<i class="fa fa-times"></i>
			<h2 class="text-uppercase" style="text-align: center; padding-bottom: 10px;">Thống kê bài viết</h2>
			<div id="columnchart_values"></div>
		</div>
		<script type="text/javascript">
              <%-- function abc(){
            	  <%
            	  	if(request.getAttribute("ArrTKBV")!=null){
            	  		ArrayList<String[]> ar=(ArrayList<String[]>) request.getAttribute("ArrTKBV");
            	  		String[] s=ar.get(0);
            	  		String ss=s[0];
            	  %>
            	  var b=new Array();
            	  b='<%=s%>';
            	  alert(b);
            	  <%}%>
              } --%>
              google.charts.load("current", {packages:['corechart']});
              google.charts.setOnLoadCallback(drawChart);
              function drawChart() {
              	 var data = new google.visualization.DataTable();
                var data = google.visualization.arrayToDataTable([//data: lưu nội dung
                  ["Tên", "Số lượng", { role: "style" } ],
                  	<%
					if(request.getAttribute("listStringTTT")!=null){
						ArrayList<String[]> ar=(ArrayList<String[]>) request.getAttribute("listStringTTT");
						for(String[] s:ar){
					%>
               			['<%=s[0]%>', <%=s[1]%>,"#39adb4"],
					<%}}%>
                ]);
                var view = new google.visualization.DataView(data);
                view.setColumns([0, 1,
                 { calc: "stringify",
                   sourceColumn: 1,
                   type: "string",
                   role: "annotation" },
                 2]);

                var options = {
                  bar: {groupWidth: "95%"},
                  legend: { position: "none" },
                };
                var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
                chart.draw(view, options);
              }
              </script>
		<div class="templatemo-content-widget white-bg col-2">
			<i class="fa fa-times"></i>
			<h2 class="text-uppercase" style="text-align: center; padding-bottom: 10px;">Thống kê cấp bậc</h2>
			<table class="table table-striped table-bordered templatemo-user-table">
				<thead>
					<tr align="center">
						<td>Cấp bậc</td>
						<td>Số user</td>
					</tr>
				</thead>
				<tbody>
				<%
					if(request.getAttribute("listString")!=null){
						ArrayList<String[]> listString =(ArrayList<String[]>)request.getAttribute("listString");
						for(String[] mang : listString){
					
				%>
					<tr align="center">
						<td><%=mang[0] %></td>
						<td><%=mang[1] %></td>
					</tr>
					<%}} %>
					
				</tbody>
			</table>
		</div>
	</div>

 <!-- Second row ends -->
          <div class="templatemo-flex-row flex-content-row templatemo-overflow-hidden"> <!-- overflow hidden for iPad mini landscape view-->
            <div class="col-1 templatemo-overflow-hidden">
              <div class="templatemo-content-widget white-bg templatemo-overflow-hidden">
                <i class="fa fa-times"></i>
                <div class="templatemo-flex-row flex-content-row">
                  <div class="col-1 col-lg-6 col-md-12">
                    <h2 class="text-center">Modular<span class="badge">new</span></h2>
                    <div id="pie_chart_div" class="templatemo-chart"></div> <!-- Pie chart div -->
                  </div>
                  <div class="col-1 col-lg-6 col-md-12">
                    <h2 class="text-center">Interactive<span class="badge">new</span></h2>
                    <div id="bar_chart_div" class="templatemo-chart"></div> <!-- Bar chart div -->
                  </div>  
                </div>                
              </div>
            </div>
          </div>
         <%@include file="/admin/inc/footer.jsp"%>        
        </div>
      </div>
    </div>
    
    <!-- JS -->
    <script src="js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script src="js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
    <script src="https://www.google.com/jsapi"></script> <!-- Google Chart -->
    <script>
      /* Google Chart 
      -------------------------------------------------------------------*/
      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart); 
      
      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

          // Create the data table.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Slices');
          data.addRows([
            ['Mushrooms', 3],
            ['Onions', 1],
            ['Olives', 1],
            ['Zucchini', 1],
            ['Pepperoni', 2]
          ]);

          // Set chart options
          var options = {'title':'How Much Pizza I Ate Last Night'};

          // Instantiate and draw our chart, passing in some options.
          var pieChart = new google.visualization.PieChart(document.getElementById('pie_chart_div'));
          pieChart.draw(data, options);

          var barChart = new google.visualization.BarChart(document.getElementById('bar_chart_div'));
          barChart.draw(data, options);
      }

      $(document).ready(function(){
        if($.browser.mozilla) {
          //refresh page on browser resize
          // http://www.sitepoint.com/jquery-refresh-page-browser-resize/
          $(window).bind('resize', function(e)
          {
            if (window.RT) clearTimeout(window.RT);
            window.RT = setTimeout(function()
            {
              this.location.reload(false); /* false to get page from cache */
            }, 200);
          });      
        } else {
          $(window).resize(function(){
            drawChart();
          });  
        }   
      });
      
    </script>
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->

  </body>
</html>