<%@page import="library.ConvertStringLibrary"%>
<%@page import="model.bean.QuangCao"%>
<%@page import="model.bean.DanhNgon"%>
<%@page import="model.bean.DanhMucTin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.TinTuc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/public/inc/header.jsp"%> 
    <!--Chèn comment Facebook-->
			<script>
			  window.fbAsyncInit = function() {
				FB.init({
				  appId      : '1768827193344936',
				  xfbml      : true,
				  version    : 'v2.5'
				});
			  };

			  (function(d, s, id){
				 var js, fjs = d.getElementsByTagName(s)[0];
				 if (d.getElementById(id)) {return;}
				 js = d.createElement(s); js.id = id;
				 js.src = "//connect.facebook.net/en_US/sdk.js";
				 fjs.parentNode.insertBefore(js, fjs);
			   }(document, 'script', 'facebook-jssdk'));
			</script>
			

<!--Chèn comment Facebook-->
<div class="cachtop"></div>
<div class="container-fluid white-bg">
	<div class="container">
		<div class="row">
		<%
			if(request.getAttribute("objTT")!=null){
			TinTuc objTT = (TinTuc)request.getAttribute("objTT");
			if(objTT.getStatus()==1){
		%>
	    	<div class="col-sm-8 noidungbaiviet">
	    		<h1 class="tieude"><%=objTT.getTenTT() %></h1>
	    		<p class="thoigian pull-left">Ngày <%=objTT.getNgaydang() %></p>
	    		<p class="luotxem pull-right icon-eye-open"><i class="fa fa-eye" aria-hidden="true"></i> <%=objTT.getLuotview()%></p>
	    		<p class="clearfix"></p>
	    		<hr>
	    		
    			<p><%=objTT.getChitietTT() %></p>
    			<div class="fb-comments fb_iframe_widget fb_iframe_widget_fluid" data-href="<%=request.getContextPath() %>/chitiet?dtid=<%=objTT.getIdTT() %>" data-width="100%" data-numposts="5" fb-xfbml-state="rendered"><span style="height: 173px;"><iframe id="f32f8c804b295" name="f9dc29e8e7e6ac" scrolling="no" title="Facebook Social Plugin" class="fb_ltr fb_iframe_widget_lift" src="https://www.facebook.com/plugins/comments.php?api_key=1768827193344936&amp;channel_url=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter%2Fr%2FfTmIQU3LxvB.js%3Fversion%3D42%23cb%3Dfffe6987b7be3%26domain%3Daboutmeex.vinaenter.edu.vn%26origin%3Dhttp%253A%252F%252Faboutmeex.vinaenter.edu.vn%252Ff3c273a494a288%26relation%3Dparent.parent&amp;href=http%3A%2F%2Faboutme.pro%2FTuoi-tho-toi-82.html&amp;locale=en_US&amp;numposts=5&amp;sdk=joey&amp;version=v2.5&amp;width=100%25" style="border: none; overflow: hidden; height: 173px; width: 100%;"></iframe></span></div>
	    	</div>
	    	<%}else{%>
	    	<div class="col-sm-8 noidungbaiviet">
	    	<p><h1>Bài viết ko tồn tại</h1></p>
	    		</div>
	    	<%} %>
	    	<div class="col-sm-4 right-bar">
	    		<div class="col-sm-12">
	    			<h4 class="cat-right-bar">Bài viết mới nhất</h4>
	    			<ul class="newpost">
	    			
	    			<%
					if(request.getAttribute("Newslq")!=null){
						ArrayList<TinTuc> listTT=(ArrayList<TinTuc>) request.getAttribute("Newslq");
						int sumTT = listTT.size();//đúng rồi, mà tại có 1 tin nên chổ đó không hiển thị. vãi lờ :)):))
						int limit=0;//cái ni để giới hạn số tin liên quan hiện 3 tin liên quan
						TinTuc objTT1 = (TinTuc)request.getAttribute("objTT");
						for(int j=sumTT-1;j>=0;j--){//cái ni l \à đém ngưuoc lấy tin mới nhất khúc ni copy qua đó sửa cía tên thôi
							if(limit>=5){break;}//=33 là thoát 
							TinTuc itemTT=listTT.get(j);
						if(objTT1.getIdTT()!=itemTT.getIdTT()){//nếu là tin hiện ở trên thì không xuất
							limit=limit+1;
							String urlDetail="danh-muc/"+ConvertStringLibrary.createSlug(objTT.getTenDMT())+"/"+objTT.getIdDMT()+"/chi-tiet/";
				%>
	    					    				<li class="btn-open-popover" data-content="<%=itemTT.getMotaTT()%>" data-placement="bottom" title="" data-original-title="<%=itemTT.getTenTT() %>">
	    					<h5><a href="<%=request.getContextPath() %>/<%=urlDetail %><%=itemTT.getIdTT() %>" title=""><%=itemTT.getTenTT() %></a>
	    						<span class="ngay-dang"> - <%=itemTT.getNgaydang() %></span>
	    					</h5>
	    				</li>
	    					    		<%}}} %>		
	    					    			</ul>
	    		</div>
	    		<div class="col-sm-12">
	    			<h4 class="cat-right-bar">Chuyên mục</h4>
	    			<ul class="chuyenmuc">
	    			<%
	    				ArrayList<DanhMucTin> listDMT = (ArrayList<DanhMucTin>)request.getAttribute("listDMT");
	    				for(DanhMucTin objDMT : listDMT){
	    					String urlCat="danh-muc/"+ConvertStringLibrary.createSlug(objDMT.getTenDMT())+"/"+objDMT.getIdDMT();
	    			%>
	    				                        <li><h5><a href="<%=request.getContextPath()%>/<%=urlCat %>" title="<%=objDMT.getTenDMT() %>"><%=objDMT.getTenDMT() %></a></h5></li>
                        	    			<%} %>
                        	    			</ul>
                        	    			
	    		</div>
	    		<div class="col-sm-12">
	    			<h4 class="cat-right-bar">Danh ngôn</h4>
	    			<ul class="trichdan">
	    			<%
	    				ArrayList<DanhNgon> listDN = (ArrayList<DanhNgon>)request.getAttribute("listDN");
	    				for(DanhNgon objDN : listDN){
	    			%>
	    					    				<li>
	    					<p class="text-justify"><%=objDN.getNoidungDN() %></p>
	    					<p class="text-right"><em><%=objDN.getTacgiaDN() %></em></p>
	    				</li>
	    				<%} %>
	    					    			</ul>
	    		</div>
	    	</div>
	    	<%} %>
    	</div>
	</div>
</div>
<!-- <script type="text/javascript"> -->
<%--     window.history.pushState('page2', 'Title', '<%=request.getContextPath() %>/chitiet?dtid=<%=objTT.getIdDMT() %>'); --%>
<!-- </script> -->
<script type="text/javascript">
    $(function () {
      //popover normal
      $('.btn-open-popover').popover({
        trigger: 'hover',
      });
    });
  </script>
    <!-- Clients Aside -->
    <center>
    <aside class="clients" >
        <div class="container" >
            <div class="row" >
                <%
	    				ArrayList<QuangCao> listQC = (ArrayList<QuangCao>)request.getAttribute("listQC");
	    				for(QuangCao objQC : listQC){
	    			%>
	    			
                <div class="col-md-3 col-sm-6" >
                    <a href="<%=objQC.getLinkQuangcao()%>">
                        <img src="<%=request.getContextPath() %>/files/<%=objQC.getHinhanhQuangcao() %>" class="img-responsive img-centered" alt="<%=objQC.getTenQuangcao()%>">
                    </a>
                </div>
                <%} %>
                            </div>
        </div>
    </aside>
 </center>
	
	<div class="lentren">
        <a href="#" title="Về đầu trang">
            <button class="btn btn-default" aria-label="Left Align">
                <i class="fa fa-chevron-up"></i>
            </button>
        </a>
    </div>

<%@include file="/public/inc/footer.jsp"%>
