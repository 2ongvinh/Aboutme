<%@page import="model.dao.ViewHomeDAO"%>
<%@page import="model.bean.ViewHome"%>
<%@page import="library.ConvertStringLibrary"%>
<%@page import="model.dao.DuAnDAO"%>
<%@page import="model.dao.TinTucDAO"%>
<%@page import="model.bean.Slider"%>
<%@page import="model.bean.ThongTin"%>
<%@page import="model.bean.QuangCao"%>
<%@page import="javafx.scene.control.Alert"%>
<%@page import="model.bean.DuAn"%>
<%@page import="model.bean.DanhNgon"%>
<%@page import="model.bean.TinTuc"%>
<%@page import="model.bean.DanhMucTin"%>
<%@page import="model.bean.Gioithieu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/public/inc/header.jsp"%>
<!-- HOME SLIDER -->
<div class="slider-wrap home-1-slider" id="home">

	<%
		ArrayList<Slider> listSlider = (ArrayList<Slider>)request.getAttribute("listSlider");
			
	%>
	<div id="mainSlider" class="nivoSlider slider-image">
		<%

			int i =0;
			for(Slider objSlider: listSlider){
				i=i+1;
		%>
		<img src="public/img/slider.jpg" alt="main slider"
			title="#htmlcaption<%=i %>" /> 
			<%} %>
	</div>
	<%
		int j =0;
		for(Slider objSlider: listSlider){
		j=j+1;
	%>
	<div id="htmlcaption<%=j %>" class="nivo-html-caption slider-caption-<%=j %>">
		<div class="slider-progress"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="slide1-text slide-text">
						<div class="middle-text">
							<div class="left_sidet1">
								<div class="cap-title wow slideInRight" data-wow-duration=".9s"
									data-wow-delay="0s">
									<h1><%=objSlider.getTenSlider() %></h1>
								</div>
								<div class="cap-dec wow slideInRight" data-wow-duration="1.1s"
									data-wow-delay="0s">
									<h2><%=objSlider.getMotaSlider()%></h2>
								</div>
								<div class="cap-readmore animated fadeInUpBig" data-wow-duration="1.5s" data-wow-delay=".5s">
									<a href="" target="_blank">Chi tiết</a>
								</div>
							</div>
							<div class="right_sidet1">
								<div class="slide-image1">
									<img class="wow slideInUp" data-wow-duration="1.5s"
										data-wow-delay="0s"
										src="<%=request.getContextPath() %>/files/<%=objSlider.getHinhanhSlider() %>"
										alt="slider caption" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%} %>
</div>
	
<!-- HOME SLIDER -->

<!-- About Section -->
<section id="about-me">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">ABOUT ME</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<ul class="timeline">

					<%
						ArrayList<Gioithieu> listItem = (ArrayList<Gioithieu>) request.getAttribute("listGioithieu");
					//	int i = 0;
						String c = "";
						for (Gioithieu objGioithieu : listItem) {
							i = i + 1;
							if (i % 2 == 0) {
								c = "class='timeline-inverted'";
							} else {
								c = "";
							}
					%>
					<li <%=c%>>
						<div class="timeline-image">
							<img class="img-circle img-responsive"
								src="<%=request.getContextPath()%>/files/<%=objGioithieu.getHinhanhGioithieu()%>"
								alt="">
						</div>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4><%=objGioithieu.getNgayGioithieu()%></h4>
								<h4 class="subheading text-bold"><%=objGioithieu.getTieudeGioithieu()%></h4>
							</div>
							<div class="timeline-body">
								<p class="text-muted"><%=objGioithieu.getNoidungGioithieu()%></p>
							</div>
						</div>
					</li>

					<%
						}
					%>
					<li class="timeline-inverted">
						<div class="timeline-image">
							<h4>
								To be <br>Continue <br>...
							</h4>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</section>
<!-- end About area -->
<!-- progress area -->
<div class="progress_area bg-light-gray" id="about">
	<div class="container">
		<div class="row">
			<!-- progress content -->
			<div class="col-md-6">
				<div class="progress_text">
					<h2>
						<span>Skills</span>
					</h2>
					<p>Những kỹ năng của tôi</p>
				</div>
			</div>
			<!-- end progress content -->
			<!-- progress bar -->
			<div class="col-md-6">
				<div class="progress_content">
					<!--single progress bar-->
					<div class="progress  progress-bar-value">
						<div class="progress-bar wow fadeInLeft animated"
							role="progressbar" aria-valuenow="0" aria-valuemin="0"
							aria-valuemax="100"
							style="min-width: 90%; visibility: visible; animation-duration: 1.5s; animation-name: fadeInLeft;"
							data-wow-duration="1.5s">
							<span class="p_text_left">HTML + CSS</span> <span
								class="p_text_right">90%</span>
						</div>
					</div>
					<!--single progress bar-->
					<div class="progress  progress-bar-value">
						<div class="progress-bar wow fadeInLeft animated"
							role="progressbar" aria-valuenow="0" aria-valuemin="0"
							aria-valuemax="100"
							style="min-width: 90%; visibility: visible; animation-duration: 1.5s; animation-name: fadeInLeft;"
							data-wow-duration="1.5s">
							<span class="p_text_left">PHP &amp; MySQL</span> <span
								class="p_text_right">98%</span>
						</div>
					</div>
					<!--single progress bar-->
					<div class="progress  progress-bar-value">
						<div class="progress-bar wow fadeInLeft animated"
							role="progressbar" aria-valuenow="0" aria-valuemin="0"
							aria-valuemax="100"
							style="min-width: 85%; visibility: visible; animation-duration: 1.5s; animation-name: fadeInLeft;"
							data-wow-duration="1.5s">
							<span class="p_text_left">JavaScript</span> <span
								class="p_text_right">95%</span>
						</div>
					</div>
					<!-- end single progress bar-->
					<!--single progress bar-->
					<div class="progress  progress-bar-value">
						<div class="progress-bar wow fadeInLeft animated"
							role="progressbar" aria-valuenow="0" aria-valuemin="0"
							aria-valuemax="100"
							style="min-width: 85%; visibility: visible; animation-duration: 1.5s; animation-name: fadeInLeft;"
							data-wow-duration="1.5s">
							<span class="p_text_left">Angular</span> <span
								class="p_text_right">97%</span>
						</div>
					</div>
					<!-- end single progress bar-->
					<!--single progress bar-->
					<div class="progress  progress-bar-value">
						<div class="progress-bar wow fadeInLeft animated"
							role="progressbar" aria-valuenow="0" aria-valuemin="0"
							aria-valuemax="100"
							style="min-width: 85%; visibility: visible; animation-duration: 1.5s; animation-name: fadeInLeft;"
							data-wow-duration="1.5s">
							<span class="p_text_left">AJAX</span> <span class="p_text_right">100%</span>
						</div>
					</div>
					<!-- end single progress bar-->
					<!--single progress bar-->
					<div class="progress  progress-bar-value">
						<div class="progress-bar wow fadeInLeft animated"
							role="progressbar" aria-valuenow="0" aria-valuemin="0"
							aria-valuemax="100"
							style="min-width: 85%; visibility: visible; animation-duration: 1.5s; animation-name: fadeInLeft;"
							data-wow-duration="1.5s">
							<span class="p_text_left">JSP-SERVLET</span> <span
								class="p_text_right">98%</span>
						</div>
					</div>
					<!-- end single progress bar-->
					<!--single progress bar-->
					<div class="progress  progress-bar-value">
						<div class="progress-bar wow fadeInLeft animated"
							role="progressbar" aria-valuenow="0" aria-valuemin="0"
							aria-valuemax="100"
							style="min-width: 85%; visibility: visible; animation-duration: 1.5s; animation-name: fadeInLeft;"
							data-wow-duration="1.5s">
							<span class="p_text_left">SPRING FRAMEWORK</span> <span
								class="p_text_right">100%</span>
						</div>
					</div>
					<!-- end single progress bar-->
					<!--single progress bar-->
					<div class="progress  progress-bar-value">
						<div class="progress-bar wow fadeInLeft animated"
							role="progressbar" aria-valuenow="0" aria-valuemin="0"
							aria-valuemax="100"
							style="min-width: 85%; visibility: visible; animation-duration: 1.5s; animation-name: fadeInLeft;"
							data-wow-duration="1.5s">
							<span class="p_text_left">JAVA SWING</span> <span
								class="p_text_right">95%</span>
						</div>
					</div>
					<!-- end single progress bar-->
				</div>
			</div>
			<!-- end progress bar -->
		</div>
	</div>
</div>
<!--end  progress area -->
<div class="portfolio_area" id="mypost">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">Bài viết</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="portfolio_nav">
					<ul>
						<li class="filter" data-filter=".Tat-Ca">Tất cả</li>
						<%
							ArrayList<DanhMucTin> listDMT = (ArrayList<DanhMucTin>) request.getAttribute("listDMT");
							for (DanhMucTin objDMT : listDMT) {
								String urlCat="danh-muc/"+ConvertStringLibrary.createSlug(objDMT.getTenDMT())+"/"+objDMT.getIdDMT();
								
						%>
						<li class="filter" data-filter=".<%=objDMT.getIdDMT()%>"><%=objDMT.getTenDMT()%>
							<a href="<%=request.getContextPath()%>/<%=urlCat%>"> <i
								class="fa fa-play-circle" aria-hidden="true"
								style="font-size: 20px; line-height: 20px;"></i>
						</a></li>
						<%
							}
						%>
					</ul>
				</div>
			</div>
			<div class="project_maxitup" id="MixItUp380DA8">
			
				<!--single portfolio item-->
				<%
					ArrayList<TinTuc> listTT = (ArrayList<TinTuc>) request.getAttribute("listTT");
					for (TinTuc objTT1 : listTT) {
						if(objTT1.getStatus()==1){
							String urlDetail="danh-muc/"+ConvertStringLibrary.createSlug(objTT1.getTenDMT())+"/"+objTT1.getIdDMT()+"/chi-tiet/"+objTT1.getIdTT();
				%>
				<div class="col-md-4 col-sm-6 mix <%=objTT1.getIdDMT()%> Tat-Ca"
					style="display: inline-block;" data-bound="">
					<div class="portfolio">
						<div class="single_protfolio">
							<div class="prot_imag">
								<a class="venobox vbox-item"
									href="<%=request.getContextPath() %>/<%=urlDetail%>">
									<img style="width: 400px;height: 300px"
									src="<%=request.getContextPath()%>/files/<%=objTT1.getHinhanhTT()%>"
									alt="">
								</a>
								<div class="hover_port_text">
									<h2>
										<a
											href="<%=request.getContextPath() %>/<%=urlDetail%>"><%=objTT1.getTenTT()%></a>
									</h2>
									<p><%=objTT1.getTenDMT()%></p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%
					}}
				%>

				<!-- end single portfolio item-->

			</div>
		</div>
	</div>
</div>
<!--end portfolio area -->

<!-- client  area -->
<div class="client_area">
	<div class="container">
		<div class="row">
			<div class="client_own curosel-style client_style">
				<%
					ArrayList<DanhNgon> listDN = (ArrayList<DanhNgon>) request.getAttribute("listDN");
					for (DanhNgon objDN : listDN) {
				%>
				<div class="col-md-12">
					<div class="client">
						<div class="client_img">
							<a href="#"><img
								src="<%=request.getContextPath()%>/files/<%=objDN.getHinhanhDN()%>"
								alt="" width="150" height="150"></a>
						</div>
					</div>
					<div class="client_content">
						<div class="client_text">
							<h2>
								<span>Danh ngôn</span>
							</h2>
							<p><%=objDN.getNoidungDN()%></p>
							<a href="#"><%=objDN.getTacgiaDN()%><span></span></a>
						</div>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</div>
<!-- end client  area -->


<!-- Portfolio Grid Section -->
<section id="portfolio">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">My Project</h2>
				<h3 class="section-subheading text-muted">Các dự án tôi đã thực
					hiện.</h3>
			</div>
		</div>
		<div class="row">
			<%
				ArrayList<DuAn> listDuAn = (ArrayList<DuAn>) request.getAttribute("listDuAn");
				for (DuAn objDuAn : listDuAn) {
			%>

			<div class="col-md-4 col-sm-6 portfolio-item">
				<a href="#<%=objDuAn.getIdDuan()%>" class="portfolio-link"
					data-toggle="modal">
					<div class="portfolio-hover">
						<div class="portfolio-hover-content">
							<i class="fa fa-plus fa-3x"></i>
						</div>
					</div> <img style="width: 400px;height: 300px"
					src="<%=request.getContextPath()%>/files/<%=objDuAn.getHinhanhDuan()%>"
					class="img-responsive" alt="">
				</a>
				<div class="portfolio-caption">
					<h4>
						<a href="<%=objDuAn.getLinkDuan()%>" title="" target="_blank"><%=objDuAn.getTenDuan()%></a>
					</h4>
					<p class="text-muted"><%=objDuAn.getMotaDuan()%></p>
				</div>
			</div>
			<%
				}
			%>

		</div>
	</div>
</section>

<!--counter up area -->
<div class="counterup_area" id="work">
	<div class="container">
		<div class="row">
			<!--single counterup item-->
			<div class=" col-sm-4 col-md-4 col-lg-4">
				<div class="counter_up">
					<div class="iconcounter">
						<i class="fa fa-coffee"></i>
					</div>
					<%
					ViewHome objVH = (ViewHome)request.getAttribute("objVH");
						TinTucDAO tintucDAO = new TinTucDAO();
						int countLuotView = tintucDAO.CountLuotView();
						
						ViewHomeDAO viewhomeDAO = new ViewHomeDAO();
						int countLuotView1 = viewhomeDAO.CountLuotView1();
						int sum = countLuotView+countLuotView1;
					%>
					<div class="counter">
						<h1 class="number"><%=sum %></h1> 
						<p class="text">Lượt xem</p>
					</div>
				</div>
			</div>
			<!--end single counterup item-->
			<!--single counterup item-->
			<div class=" col-sm-4 col-md-4 col-lg-4">
				<div class="counter_up">
					<div class="iconcounter cb2">
						<i class="fa fa-download"></i>
					</div>
					<%
						int countBaiViet = tintucDAO.countBaiViet();
					%>
					<div class="counter ">
						<h1 class="number cn2"><%=countBaiViet %></h1>
						<p class="text">Số bài viết</p>
					</div>
				</div>
			</div>
			<!--end single counterup item-->
			<!--single counterup item-->
			<div class=" col-sm-4 col-md-4 col-lg-4">
				<div class="counter_up">
					<div class="iconcounter cb3">
						<i class="fa fa-heart"></i>
					</div>
					<%
						DuAnDAO duanDAO = new DuAnDAO();
						int countDuAn = duanDAO.countDuAn();
					%>
					<div class="counter">
						<h1 class="number cn3"><%=countDuAn %></h1>
						<p class="text">Số dự án</p>
					</div>
				</div>
			</div>
			<!--end single counterup item-->
		</div>
	</div>
</div>
<!--end counterup area -->
<div class="footer_area" id="contact-me">
	<div class="container">
		<div class="row">
			<!--section title-->
			<div class=" col-sm-12 col-md-12 col-lg-12">
				<div class="section_title service_color">
					<h2 class="title">
						<span>Liên hệ</span>
					</h2>
				</div>
			</div>
			<!--end section title-->
		</div>
		<div class="row">
			<div class="col-sm-4 col-md-4 col-lg-4">
	<%
		ThongTin objThongTin = (ThongTin)request.getAttribute("objThongTin");
	%>

				<div class="single_address fix">
					<div class="address_icon">
						<span><i class="fa fa-map-marker"></i></span>
					</div>
					<div class="address_text">
						<p>
							<span>Address: </span><%=objThongTin.getDiachi() %>
						</p>
					</div>
				</div>

				<div class="single_address fix">
					<div class="address_icon">
						<span><i class="fa fa-phone"></i></span>
					</div>
					<div class="address_text">
						<p>
							<span>Phone: </span><%=objThongTin.getPhone()%>
						</p>
					</div>
				</div>
				<div class="single_address fix">
					<div class="address_icon">
						<span><i class="fa fa-envelope-o"></i></span>
					</div>
					<div class="address_text">
						<p>
							<span>Email: </span><%=objThongTin.getEmail() %>
						</p>
					</div>
				</div>
				<div class="single_address fix">
					<div class="address_icon">
						<span><i class="fa fa-skype"></i></span>
					</div>
					<div class="address_text">
						<p>
							<span>Skype: </span><%=objThongTin.getSkype() %>
						</p>
					</div>
				</div>

			</div>
			<div class="col-sm-4 col-md-4 col-lg-4">

				<div class="single_address fix">
					<div class="address_icon">
						<span><i class="fa fa-wordpress"></i></span>
					</div>
					<div class="address_text">
						<p>
							<span>Wordpress: </span> <a href="https://vinaenter.com"
								title="Wordpress" style="color: #dddddd"><%=objThongTin.getWordpress() %></a>
						</p>
					</div>
				</div>

				<div class="single_address fix">
					<div class="address_icon">
						<span><i class="fa fa-facebook"></i></span>
					</div>
					<div class="address_text">
						<p>
							<span>Facebook: </span><a
								href="<%=objThongTin.getLinkfacebook() %>"
								title="Wordpress" style="color: #dddddd"><%=objThongTin.getFacebook() %></a>
						</p>
					</div>
				</div>

				<div class="single_address fix">
					<div class="address_icon">
						<span><i class="fa fa-twitter"></i></span>
					</div>
					<div class="address_text">
						<p>
							<span>Twitter: </span><a
								href="<%=objThongTin.getLinktwitter() %>"
								title="Wordpress" style="color: #dddddd"> <%=objThongTin.getTwitter() %></a>
						</p>
					</div>
				</div>

				<div class="single_address fix">
					<div class="address_icon">
						<span><i class="fa fa-google-plus"></i></span>
					</div>
					<div class="address_text">
						<p>
							<span>Google Plus: </span><a
								href="<%=objThongTin.getLinkgoogleplus() %>"
								title="Wordpress" style="color: #dddddd"><%=objThongTin.getGoogleplus()%></a>
						</p>
					</div>
				</div>

			</div>
			<div class="col-sm-4 col-md-4 col-lg-4">
				<form id="formlienhe"
					action="javascript:void(0);" method="post"
					novalidate="novalidate">
					<div class="contract_us">
						<div class="inputt input_change">
							<input type="text" name="hoten" class="form-control" id="name"
								placeholder="Name"> <span class="message_icon"><i
								class="fa fa-user"></i></span>
						</div>
						<div class="inputt input_change">
							<input type="email" name="email" class="form-control" id="email"
								placeholder="Email"> <span class="message_icon"><i
								class="fa fa-envelope-o"></i></span>
						</div>
						<div class="inputt input_change">
							<input type="text" name="phone" class="form-control" id="phone"
								placeholder="Phone"> <span class="message_icon"><i
								class="fa fa-phone"></i></span>
						</div>
						<div class="inputt">
							<textarea class="form-control" name="noidung" rows="4" id="mes"
								placeholder="Message"></textarea>
							<span class="message_icon"><i class="fa fa-external-link"></i></span>
						</div>
						
						<div class="sunmite_button">
						
		<div id="success">
		
		</div>
							<!-- <input type="submit" name="sendcontact" value="Send Messeage" id="submit"  /> -->
							<button name="sendcontact" id="submit" onclick="return getResult()">Send Message</button>
						</div>
					</div>
				</form>
				
				<script type="text/javascript">
				function getResult(){
					var name=$("#name").val();//lấy id
					var email=$("#email").val();
					var phone=$("#phone").val();
					var mes=$("#mes").val();
					
					
					
					$.ajax({
						url: '<%=request.getContextPath() %>/sendmessage',
						type: 'post',
						cache: false,
						data: {
								//Dữ liệu gửi đi
								ahoten:name, //key
								aemail:email,
								aphone:phone,
								anoidung:mes,
								
								},
						success: function(data){
							// Xử lý thành công
							$("#success").html(data)
						},
						error: function (){
						// Xử lý nếu có lỗi
							alert("Làm ơn điền thông tin!");
						}
					});
					return false;
					}
				
						
			</script>
			

			</div>
		</div>
	</div>
</div>

<!-- Portfolio Modal Dự án -->
<%
	for (DuAn objDuAn1 : listDuAn) {
%>
<div class="portfolio-modal modal fade" id="<%=objDuAn1.getIdDuan()%>"
	tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<!-- Project Details Go Here -->
							<h2><%=objDuAn1.getTenDuan()%></h2>
							<p><%=objDuAn1.getMotaDuan()%></p>
							<img class="img-responsive img-centered"
								src="<%=request.getContextPath()%>/files/<%=objDuAn1.getHinhanhDuan()%>"
								alt="Bé Chì Màu">
							<p>
								Link dự án: <a href="<%=objDuAn1.getLinkDuan()%>" title=""
									target="_blank"><%=objDuAn1.getLinkDuan()%></a>
							</p>
							<button class="btn btn-primary" data-dismiss="modal">
								<i class="fa fa-times"></i> Đóng
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%
	}
%>

<!-- Clients Aside -->
<aside class="clients">
	<div class="container">
		<div class="row">
			<%
				ArrayList<QuangCao> listQC = (ArrayList<QuangCao>) request.getAttribute("listQC");
				for (QuangCao objQC : listQC) {
			%>
			<div class="col-md-3 col-sm-6">
				<a href="<%=objQC.getLinkQuangcao()%>"> <img
					src="<%=request.getContextPath()%>/files/<%=objQC.getHinhanhQuangcao()%>"
					class="img-responsive img-centered" alt="">
				</a>
			</div>

			<%
				}
			%>
		</div>
	</div>
</aside>

<div class="lentren">
	<a href="#" title="Về đầu trang">
		<button class="btn btn-default" aria-label="Left Align">
			<i class="fa fa-chevron-up"></i>
		</button>
	</a>
</div>
<%@include file="/public/inc/footer.jsp"%>

