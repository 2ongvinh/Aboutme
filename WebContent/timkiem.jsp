<%@page import="library.ConvertStringLibrary"%>
<%@page import="model.bean.QuangCao"%>
<%@page import="model.bean.TinTuc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/public/inc/header.jsp"%>

<div class="cachtop"></div>
<div class="container-fluid white-bg">
	<div class="container">
		<div class="table-responsive">
			<div id="myTable_wrapper" class="dataTables_wrapper no-footer">
				
				<table id="myTable"
					class="table-hover table-striped dataTable no-footer" role="grid"
					aria-describedby="myTable_info">
					<thead>
						<tr role="row">
							<th class="text-center sorting_asc" tabindex="0"
								aria-controls="myTable" rowspan="1" colspan="1"
								aria-sort="ascending"
								aria-label="Tên bài viết: activate to sort column descending"
								style="width: 589px;">Tên bài viết</th>
							<th class="text-center sorting" tabindex="0"
								aria-controls="myTable" rowspan="1" colspan="1"
								aria-label="Danh mục: activate to sort column ascending"
								style="width: 162px;">Danh mục</th>
							<th class="text-center sorting" tabindex="0"
								aria-controls="myTable" rowspan="1" colspan="1"
								aria-label="Ngày đăng: activate to sort column ascending"
								style="width: 111px;">Ngày đăng</th>
							<th class="text-center sorting" tabindex="0"
								aria-controls="myTable" rowspan="1" colspan="1"
								aria-label="Người đăng: activate to sort column ascending"
								style="width: 134px;">Người đăng</th>
						</tr>
					</thead>
					<tbody>

					<%
						ArrayList<TinTuc> listTT = (ArrayList<TinTuc>)request.getAttribute("listTT");
						for(TinTuc objTT : listTT){
							String urlDetail="danh-muc/"+ConvertStringLibrary.createSlug(objTT.getTenDMT())+"/"+objTT.getIdDMT()+"/chi-tiet/"+objTT.getIdTT();
							String urlCat="danh-muc/"+ConvertStringLibrary.createSlug(objTT.getTenDMT())+"/"+objTT.getIdDMT();
							if(objTT.getStatus()==1){
					%>

						<tr role="row" class="odd">
							<td class="sorting_1"><a
								href="<%=request.getContextPath() %>/<%=urlDetail %>"
								class="btn-open-popover"
								data-content="<%=objTT.getMotaTT() %>"
								data-placement="bottom" title=""
								data-original-title="<%=objTT.getTenTT()%>">
									<%=objTT.getTenTT()%></a> <span
								class="hidden"> <%=objTT.getChitietTT()%></span></td>
							<td class="text-center"><a
								href="<%=request.getContextPath()%>/<%=urlCat%>"><%=objTT.getTenDMT() %> </a> <span class="hidden">Bai viet cua toi</span></td>
							<td class="text-center"><%=objTT.getNgaydang() %></td>
							<td class="text-center"><%=objTT.getTenUsers() %></td>
						</tr>
						<%}}%>
					</tbody>
				</table>
				
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#myTable').DataTable();
	});
</script>
<script type="text/javascript">
	$(function() {
		//popover normal
		$('.btn-open-popover').popover({
			trigger : 'hover',
		});
	});
</script>
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
	<a href="<%=request.getContextPath() %>/timkiem#"
		title="Về đầu trang">
		<button class="btn btn-default" aria-label="Left Align">
			<i class="fa fa-chevron-up"></i>
		</button>
	</a>
</div>

<%@include file="/public/inc/footer.jsp"%>