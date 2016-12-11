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
import model.bean.QuangCao;
import model.bean.TinTuc;
import model.dao.QuangCaoDAO;
import model.dao.TinTucDAO;

/**
 * Servlet implementation class IndexTimKiemController
 */
//@WebServlet("/IndexTimKiemController")
public class IndexTimKiemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexTimKiemController() {
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
	
		QuangCaoDAO quangcaoDAO = new QuangCaoDAO();
		ArrayList<QuangCao> listQC = quangcaoDAO.getItems();
		request.setAttribute("listQC", listQC);
		TinTucDAO tintucDAO = new TinTucDAO();
		ArrayList<TinTuc> listTT = tintucDAO.getItemsTK();
		request.setAttribute("listTT", listTT);
		RequestDispatcher rd = request.getRequestDispatcher("/timkiem.jsp");
		rd.forward(request, response);
	}

}
