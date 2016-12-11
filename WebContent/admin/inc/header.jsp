<%@page import="model.bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- 
    Visual Admin Template
    http://www.templatemo.com/preview/templatemo_455_visual_admin
    -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/templatemo-style.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
      <script type="text/javascript" src="js/jquery-3.1.0.js"></script> 

      
    <link href="css/jquery.dataTables.min.css" rel="stylesheet">
     <script type="text/javascript" src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"></script> 
     <script type="text/javascript" src="<%=request.getContextPath() %>/ckfinder/ckfinder.js"></script>
     <script type="text/javascript" src="js/jquery.validate.js"></script>
     <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>
  <body>  
 <!-- Left column -->
    <div class="templatemo-flex-row">
      <div class="templatemo-sidebar">
        <header class="templatemo-site-header">
           <%
                    		if(session.getAttribute("userInfo")!=null){
                    			Users usersInfo = (Users)session.getAttribute("userInfo");
           %>
          <h1><%=usersInfo.getFullname() %>!</h1>
           <%}else{ %>
            <h1>Chào Khách!</h1>
            <%} %>
        </header>
        <div class="profile-photo-container">
        <%
                    		if(session.getAttribute("userInfo")!=null){
                    			Users usersInfo = (Users)session.getAttribute("userInfo");
                    	%>
          <img src="<%=request.getContextPath() %>/files/<%=usersInfo.getPicture() %>" alt="Profile Photo" class="img-responsive">  
            <%}else{ %>
             <img src="images/profile-photo.jpg" alt="Profile Photo" class="img-responsive">
             <%} %>
          <div class="profile-photo-overlay"></div>
        </div>      
        <!-- Search box -->
        <form class="templatemo-search-form" role="search">
          <div class="input-group">
              <button type="submit" class="fa fa-search"></button>
              <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">           
          </div>
        </form>
        <div class="mobile-menu-icon">
            <i class="fa fa-bars"></i>
        </div>
        <nav class="templatemo-left-nav">          
          <ul>
            <li><a href="<%=request.getContextPath()%>/admin/datavisual"><i class="fa fa-database fa-fw"></i>Data Visualization</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/danhmuc"><i class="fa fa-folder-open fa-fw"></i>Danh Mục</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/baiviet"><i class="fa fa-book fa-fw"></i>Bài Viết</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/gioithieu"><i class="fa fa-info-circle fa-fw"></i>Giới Thiệu</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/nguoidung"><i class="fa fa-users fa-fw"></i>Người Dùng</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/danhngon"><i class="fa fa-comment fa-fw"></i>Danh Ngôn</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/duan"><i class="fa fa-database fa-fw"></i>Dự Án</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/quangcao"><i class="fa fa-money fa-fw"></i>Quảng Cáo</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/thongtin"><i class="fa fa-info-circle fa-fw"></i>Thông Tin</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/slider"><i class="fa fa-sliders fa-fw"></i>Slider</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/lienhe"><i class="fa fa-envelope-o fa-fw"></i>Liên Hệ</a></li>
          </ul>  
        </nav>
      </div>
      <!-- Main content --> 
      <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-top-nav-container">
          <div class="row">
            <nav class="templatemo-top-nav col-lg-12 col-md-12">
              <ul class="text-uppercase">
                <li><a href="<%=request.getContextPath() %>/admin" class="active">Trang Chủ</a></li>
                
                <%
                    		if(session.getAttribute("userInfo")!=null){
                    			Users usersInfo = (Users)session.getAttribute("userInfo");
                    	%>
                    	<li><a href="<%=request.getContextPath()%>/admin/suanguoidung?uid=<%=usersInfo.getIdUsers()%>">Tài Khoản</a></li>
                <li><a href="<%=request.getContextPath() %>/admin/logout">Đăng Xuất</a></li>
                <%}else{ %>
                <li><a href="<%=request.getContextPath() %>/admin/login">Đăng Nhập</a></li>
                <%} %>
              </ul>  
            </nav> 
          </div>
        </div>