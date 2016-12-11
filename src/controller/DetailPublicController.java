package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DanhMucTin;
import model.bean.DanhNgon;
import model.bean.QuangCao;
import model.bean.TinTuc;
import model.dao.DanhMucTinDAO;
import model.dao.DanhNgonDAO;
import model.dao.QuangCaoDAO;
import model.dao.TinTucDAO;

/**
 * Servlet implementation class DetailPublicController
 */
//@WebServlet("/DetailPublicController")
public class DetailPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailPublicController() {
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
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		TinTucDAO tintucDAO = new TinTucDAO();
		int idNews = Integer.parseInt(request.getParameter("dtid"));

		TinTuc objTT = tintucDAO.getItemByID(idNews);
		int luotview = tintucDAO.luotView(objTT);
		request.setAttribute("objTT",objTT);
		//int idCat=tintucDAO.getItemByID(idNews).getIdDMT();
		//request.setAttribute("Newslq", tintucDAO.getItemsByID(idCat));
		request.setAttribute("Newslq", tintucDAO.getItems());
	
		DanhMucTinDAO danhmuctinDAO = new DanhMucTinDAO();
		ArrayList<DanhMucTin> listDMT = danhmuctinDAO.getItems();
		request.setAttribute("listDMT", listDMT);
		
		DanhNgonDAO danhngonDAO = new DanhNgonDAO();
		ArrayList<DanhNgon> listDN = danhngonDAO.getItems();
		request.setAttribute("listDN", listDN);
		
		QuangCaoDAO quangcaoDAO = new QuangCaoDAO();
		ArrayList<QuangCao> listQC = quangcaoDAO.getItems();
		request.setAttribute("listQC", listQC);
		RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
		rd.forward(request, response);
	}

}
