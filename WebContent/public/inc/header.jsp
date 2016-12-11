<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if lt IE 7 ]> <html lang="vi" class="ie6">    <![endif]-->
<!--[if IE 7 ]>    <html lang="vi" class="ie7">    <![endif]-->
<!--[if IE 8 ]>    <html lang="vi" class="ie8">    <![endif]-->
<!--[if IE 9 ]>    <html lang="vi" class="ie9">    <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="no-js" lang="vi">
    <head>
       
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Tran Nhat Vinh</title>
        <meta name="description" content="VinaEnter Edu">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!-- google font  -->
        <link href='https://fonts.googleapis.com/css?family=Oxygen:400,700,300' rel='stylesheet' type='text/css'>
        <link href="https://fonts.googleapis.com/css?family=Noto+Sans" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <!-- Favicon
        ============================================ -->
        <link rel="shortcut icon" type="public/image/ico" href="<%=request.getContextPath() %>/public/img/favicon.ico" />

        <!-- Datatable -->
        <link rel="stylesheet" href="<%=request.getContextPath() %>/public/css/jquery.dataTables.min.css">

        <!-- style CSS
        ============================================ -->          
        <link rel="stylesheet" href="<%=request.getContextPath() %>/public/css/agency.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/public/css/style.css">

        <!-- JS -->    
        <script src="<%=request.getContextPath() %>/public/js/jquerys.js"></script>

        <!-- jquery-1.11.3.min js
        ============================================ -->         
        <!-- <script src="js/vendor/jquery-1.11.3.min.js"></script>    -->
       <script src="<%=request.getContextPath() %>/public/js/jquery-1.11.2.min.js"></script> 
        <script src="<%=request.getContextPath() %>/public/js/validate.js"></script>
        <script src="<%=request.getContextPath() %>/public/js/jquery.validate.js"></script>
                   
        <!-- bootstrap js
        ============================================ -->         
        <script src="<%=request.getContextPath() %>/public/js/bootstrap.min.js"></script>      

        <!-- Datatable -->
        <script src="<%=request.getContextPath() %>/public/js/jquery.dataTables.min.js"></script>
        
        <script src="<%=request.getContextPath() %>/public/js/vendor/modernizr-2.8.3.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <!--Start nav  area --> 
    <div class="nav_area" id="sticker">
        <div class="container">
            <div class="row">
                <!--logo area-->
                <div class="col-md-3 col-sm-3 col-xs-4">
                    <div class="logo"><a href="<%=request.getContextPath() %>/"><img src="<%=request.getContextPath() %>/public/img/logo_edu.png" alt=""></a></div>
                </div>
                <!--end logo area-->
                <!--nav area-->
                <div class="col-md-9 col-sm-9 col-xs-8">
                    <!--  nav menu-->
                    <nav class="menu">
                        <ul class="navid">
                            <li class=""><a href="<%=request.getContextPath() %>/#home">Trang chủ</a></li>
                            <li class=""><a href="<%=request.getContextPath() %>/#about-me">Giới thiệu</a></li>
                            <li class=""><a href="<%=request.getContextPath() %>/#mypost">Bài viết</a></li>
                            <li class=""><a href="<%=request.getContextPath() %>/#portfolio">Dự án</a></li>
                            <li class=""><a href="<%=request.getContextPath() %>/#contact-me">Liên hệ</a></li>
                            <li><a href="<%=request.getContextPath() %>/timkiem"><i class="fa fa-search"></i></a></li>
                        </ul>
                    </nav>
                    <!--end  nav menu-->
                    <!--moblie menu area-->
                        <div class="dropdown mabile_menu">
                            <a data-toggle="dropdown" class="mobile-menu" href="#"><span> MENU </span><i class="fa fa-bars"></i></a>
                          <ul class="dropdown-menu mobile_menus drop_mobile navid">
                            <li class="current"><a href="<%=request.getContextPath() %>#home">Trang chủ</a></li>
                            <li class=""><a href="<%=request.getContextPath() %>/#about-me">Giới thiệu</a></li>
                            <li class=""><a href="<%=request.getContextPath() %>/#mypost">Bài viết</a></li>
                            <li class=""><a href="<%=request.getContextPath() %>/#portfolio">Dự án</a></li>
                            <li class=""><a href="<%=request.getContextPath() %>/#contact-me">Liên hệ</a></li>
                            <li><a href="<%=request.getContextPath() %>/timkiem"><i class="fa fa-search"></i></a></li>
                          </ul>
                        </div>  
                        <!--end moblie menu up lại cái file ni lên xem thử. Lâu lắm :)). 1 file ni thôi ren up đc. vô trang di-->                      
                </div>
                <!--end nav area-->
            </div>  
        </div>
    </div>
    <!--end header  area -->    
