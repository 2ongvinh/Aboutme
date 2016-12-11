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
import model.bean.TinTuc;
import model.dao.DanhMucTinDAO;
import model.dao.TinTucDAO;

/**
 * Servlet implementation class IndexUsersAdminController
 */
//@WebServlet("/IndexUsersAdminController")
public class ShowEditNewsAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEditNewsAdminController() {
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
		DanhMucTinDAO dmtDAO = new DanhMucTinDAO();
		ArrayList<DanhMucTin> listDMT = dmtDAO.getItems();
		request.setAttribute("listDMT",listDMT);
		
		int idNews = Integer.parseInt(request.getParameter("nid"));
		TinTucDAO tintucDAO = new TinTucDAO();
		TinTuc objTT = tintucDAO.getItemByID(idNews);
		request.setAttribute("objTT", objTT);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/editNews.jsp");
		rd.forward(request, response);
	}

}
