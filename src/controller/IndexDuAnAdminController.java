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
import model.bean.DanhNgon;
import model.bean.DuAn;
import model.dao.DanhNgonDAO;
import model.dao.DuAnDAO;

/**
 * Servlet implementation class IndexUsersAdminController
 */
//@WebServlet("/IndexUsersAdminController")
public class IndexDuAnAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexDuAnAdminController() {
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
		
		DuAnDAO duanDAO = new DuAnDAO();
		
		int page = 1;
		int countDA = duanDAO.countItem();
		int row_count = 5;
		int sumPage = (int)Math.ceil((float)countDA/row_count);
		request.setAttribute("sumPage", sumPage);
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (page-1)*row_count;
		request.setAttribute("page", page);
		request.setAttribute("listDuAn", duanDAO.getItemsPagination(offset,row_count));
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexDuan.jsp");
		rd.forward(request, response);
	}

}
