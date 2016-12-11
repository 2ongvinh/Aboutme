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
import model.bean.DuAn;
import model.bean.QuangCao;
import model.dao.DuAnDAO;
import model.dao.QuangCaoDAO;
import model.dao.SliderDAO;

/**
 * Servlet implementation class IndexUsersAdminController
 */
//@WebServlet("/IndexUsersAdminController")
public class IndexSliderAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexSliderAdminController() {
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
		
		SliderDAO sliderDAO = new SliderDAO();
	
		int page = 1;
		int countS = sliderDAO.countItem();
		int row_count = 5;
		int sumPage = (int)Math.ceil((float)countS/row_count);
		request.setAttribute("sumPage", sumPage);
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (page-1)*row_count;
		request.setAttribute("page", page);
		request.setAttribute("listSlider", sliderDAO.getItemsPagination(offset,row_count));
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexSlider.jsp");
		rd.forward(request, response);
	}

}
