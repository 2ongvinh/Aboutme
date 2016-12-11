<%@page import="library.ConvertStringLibrary"%>
<%@page import="model.bean.QuangCao"%>
<%@page import="model.bean.TinTuc"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.DanhMucTin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/public/inc/header.jsp"%>   
    	
<div class="cachtop"></div>
<div class="container">
<%
	DanhMucTin objDMT = (DanhMucTin)request.getAttribute("objDMT");
%>
    <h1 class="text-center">
        <%=objDMT.getTenDMT() %>     </h1>

</div>

<div class="container-fluid white-bg">
    <div class="container">
        <div class="row">
            <div class="tincohinh">
                <ul class="cacbaiviet">
                
                <%
                	ArrayList<TinTuc> listTT = (ArrayList<TinTuc>)request.getAttribute("listTT");
                	for(TinTuc objTT : listTT){
                		if(objTT.getStatus()==1){
                		String urlCat="danh-muc/"+ConvertStringLibrary.createSlug(objDMT.getTenDMT())+"/"+objDMT.getIdDMT();
                		String urlDetail="danh-muc/"+ConvertStringLibrary.createSlug(objTT.getTenDMT())+"/"+objTT.getIdDMT()+"/chi-tiet/"+objTT.getIdTT();
                %>
                    <li class="col-sm-4">
                        <div class="hinhanh">
                            <a href="<%=request.getContextPath() %>/<%=urlDetail %>" title="">
                                <img style="width: 400px;height: 300px" src="<%=request.getContextPath() %>/files/<%=objTT.getHinhanhTT() %>" alt="" class="img-responsive">
                            </a>
                            <div class="chuyenmuc">
                                <a href="<%=request.getContextPath() %>/<%=urlCat %>" title="Chuyên mục">
                                    <span class="label label-success"><%=objTT.getTenDMT() %> </span>
                                </a>
                            </div>
                        </div>
                        
                        <h3><a href="<%=request.getContextPath() %>/<%=urlDetail %>" title=""><%=objTT.getTenTT() %></a></h3>
                        <p class="motabaiviet">
                            <span><%=objTT.getMotaTT() %></span>
                            <a href="<%=request.getContextPath() %>/<%=urlDetail %>" title="" class="doctiep">Đọc tiếp</a>
                        </p>
                    </li>
                 <%}} %> 
                 </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="pagination-wrap"> 
                    <ul class="pagination">
                     <%
					int sumPage =(Integer)request.getAttribute("sumPage");
					int current_page = (Integer)request.getAttribute("page");
					int prev = current_page-1;
					int next = current_page+1;
					String urlCatprev="danh-muc/"+ConvertStringLibrary.createSlug(objDMT.getTenDMT())+"/"+objDMT.getIdDMT()+"/page/"+prev;
					String urlCatnext="danh-muc/"+ConvertStringLibrary.createSlug(objDMT.getTenDMT())+"/"+objDMT.getIdDMT()+"/page/"+next;
					%>
                     <li>
                <a href="<%=request.getContextPath()%>/<%=urlCatprev%>" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-next"><</i></span>
                </a>
              </li>
                        <!-- <li class="active"><a href="#" title="">1</a></li>-->
                        <!-- <li><a href="#" title="">2</a></li> -->
                       
					<% String cl= "";
					for(int i=1;i<=sumPage;i++){
						if(current_page == i){
							cl="class='active'";
						}else{
							cl="";
						}
						String urlCat="danh-muc/"+ConvertStringLibrary.createSlug(objDMT.getTenDMT())+"/"+objDMT.getIdDMT()+"/page/"+i;
						%> 
                        <li <%=cl %>><a href="<%=request.getContextPath()%>/<%=urlCat%>"><%=i %></a></li>
					<%} %>
					 <li>
                <a href="<%=request.getContextPath()%>/<%=urlCatnext %>" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-next">></i></span>
                </a>
              </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
    <!-- Clients Aside -->
    <aside class="clients">
        <div class="container">
            <div class="row" >
            <%
            	ArrayList<QuangCao> listQC = (ArrayList<QuangCao>)request.getAttribute("listQC");
            	for(QuangCao objQC : listQC){
            %>
                
                <div class="col-md-3 col-sm-6" >
                    <a href="<%=objQC.getLinkQuangcao()%>">
                        <img src="<%=request.getContextPath() %>/files/<%=objQC.getHinhanhQuangcao() %>" class="img-responsive img-centered" alt="">
                    </a>
                </div>
                <%} %>
              </div>
        </div>
    </aside>
    
    <div class="lentren">
        <a href="" title="Về đầu trang">
            <button class="btn btn-default" aria-label="Left Align">
                <i class="fa fa-chevron-up"></i>
            </button>
        </a>
    </div>
<%@include file="/public/inc/footer.jsp"%>