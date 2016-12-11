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

import model.bean.QuangCao;
import model.bean.TinTuc;
import model.dao.DanhMucTinDAO;
import model.dao.QuangCaoDAO;
import model.dao.TinTucDAO;


/**
 * Servlet implementation class IndexPublicController
 */
//@WebServlet("/IndexPublicController")
public class IndexCatPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexCatPublicController() {
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
		
		
		
		DanhMucTinDAO dmtDAO = new DanhMucTinDAO();
		ArrayList<DanhMucTin> listDMT = dmtDAO.getItems();
		request.setAttribute("listDMT", listDMT);
		int idCat = Integer.parseInt(request.getParameter("cid"));
		DanhMucTin objDMT = dmtDAO.getItem(idCat);
		request.setAttribute("objDMT", objDMT);
		
		TinTucDAO tinTucDAO = new TinTucDAO();
		
		QuangCaoDAO quangcaoDAO = new QuangCaoDAO();
		ArrayList<QuangCao> listQC = quangcaoDAO.getItems();
		request.setAttribute("listQC",listQC);
		
		int page = 1;
		int countTT = tinTucDAO.countItem(idCat);
		System.out.println(countTT);
		int row_count = 6;
		int sumPage = (int)Math.ceil((float)countTT/row_count);
		request.setAttribute("sumPage", sumPage);
		//Lấy trang hiện tại - current page
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
			
		}
		//Tính offset
		int offset = (page-1)*row_count;
		request.setAttribute("page", page);
		request.setAttribute("listTT", tinTucDAO.getItemsPagition1(offset,row_count,idCat));
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/danhmuc.jsp");
		rd.forward(request, response);
		
		
	}

}
