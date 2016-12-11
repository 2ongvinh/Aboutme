package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.CheckLoginLibrary;
import model.bean.CapBac;
import model.bean.DanhMucTin;
import model.dao.CapBacDAO;
import model.dao.DanhMucTinDAO;

/**
 * Servlet implementation class IndexUsersAdminController
 */
//@WebServlet("/IndexUsersAdminController")
public class ShowAddUsersAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAddUsersAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		if(!CheckLoginLibrary.CheckLogin(request, response)){
			return;
		}
		
		CapBacDAO capbacDAO = new CapBacDAO();
		ArrayList<CapBac> listCapBac = capbacDAO.getItems();
		request.setAttribute("listCapBac",listCapBac);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/addUsers.jsp");
		rd.forward(request, response);
	}

}
