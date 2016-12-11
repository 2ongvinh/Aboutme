package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.LienHe;
import model.dao.LienHeDAO;

/**
 * Servlet implementation class SendMessageController
 */
//@WebServlet("/SendMessageController")
public class SendMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		
		LienHeDAO lienheDAO = new LienHeDAO();
		String tenLienhe = request.getParameter("ahoten");
		String emailLienhe = request.getParameter("aemail");
		int sdtLienhe = Integer.parseInt(request.getParameter("aphone"));
		String noidungLienhe = request.getParameter("anoidung");
		
		LienHe objLienhe = new LienHe(0,tenLienhe,emailLienhe,sdtLienhe,noidungLienhe);
		
		lienheDAO.addItems(objLienhe);
		
		PrintWriter out=response.getWriter();
		out.println("<div class='alert alert-success'>"+
		"<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button>"+
		"<strong>Cảm ơn bạn đã gửi tin nhắn. </strong></div>");
		
		
		
	}

}
