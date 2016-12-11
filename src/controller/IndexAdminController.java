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
import model.bean.DanhMucTin;
import model.bean.Users;
import model.dao.DanhMucTinDAO;
import model.dao.TinTucDAO;
import model.dao.UsersDAO;

/**
 * Servlet implementation class IndexAdminController
 */
//@WebServlet("/IndexAdminController")
public class IndexAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexAdminController() {
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
		//doGet(request, response);
		
		
		if(!CheckLoginLibrary.CheckLogin(request, response)){
			return;
		}
		
		DanhMucTinDAO dmtDAO = new DanhMucTinDAO();
		ArrayList<DanhMucTin> listDMT = dmtDAO.getItems();
		request.setAttribute("listDMT", listDMT);
		
		UsersDAO usersDAO = new UsersDAO();
		ArrayList<String[]> listString = usersDAO.countUsers();
		request.setAttribute("listString",listString);
		
		TinTucDAO tintucDAO = new TinTucDAO();
		ArrayList<String[]> listStringTT = tintucDAO.countNews();
		request.setAttribute("listStringTTT",listStringTT);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/index.jsp");
		rd.forward(request, response);
	}

}
