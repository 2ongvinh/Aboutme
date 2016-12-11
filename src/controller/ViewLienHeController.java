package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.LienHe;
import model.dao.LienHeDAO;

/**
 * Servlet implementation class ViewLienHeController
 */
//@WebServlet("/ViewLienHeController")
public class ViewLienHeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLienHeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub up lại thử
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int idLH1 = Integer.parseInt(request.getParameter("aidLH1"));
		LienHeDAO lienheDAO = new LienHeDAO();
		LienHe objLH = lienheDAO.getItemById(idLH1);
		out.print(
				"  <div class='templatemo-content-widget white-bg' >"+"<h2 class='margin-bottom-10'>Chi Tiết Liên Hệ</h2>"+
		"<div class='row form-group'>"+
				"<div class='col-lg-12 form-group'>"+
				"<label for='inputFirstName'>Tên</label>"
				+ "<input type='text' class='form-control' id='inputFirstName' value='"+objLH.getTenLienhe()+"'>"
				
				+ "<label for='inputFirstName'>Email</label>"
				+ "<input type='text' class='form-control' id='inputFirstName' value='"+objLH.getEmailLienhe()+"'>"
				
				+ "<label for='inputFirstName'>Số điện thoại</label>"
				+ "<input type='text' class='form-control' id='inputFirstName' value='"+objLH.getSdtLienhe()+"'>"
				
				+ "<label for='inputFirstName'>nội dung</label>"
				+ "<textarea class='form-control' name='mota'>"+objLH.getNoidungLienhe()+"</textarea><br>"
				+"<a href='"+request.getContextPath()+"/admin/xoalienhe?id="+objLH.getIdLienhe()+"' class='templatemo-edit-btn'>Delete</a>"
				+ "<a href='"+request.getContextPath()+"/admin/lienhe' class='templatemo-edit-btn'>Back</a>"
				+"</div>"+"</div>"
				+"</div>");
			
		
	}

}
