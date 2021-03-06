package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.CheckLoginLibrary;
import model.bean.Users;
import model.dao.DanhMucTinDAO;
import model.dao.TinTucDAO;

/**
 * Servlet implementation class DelCatAdminController
 */
//@WebServlet("/DelCatAdminController")
public class DelCatAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCatAdminController() {
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
		HttpSession session=request.getSession();
		Users user = (Users)session.getAttribute("userInfo");
		if(user.getIdCapbac()==1){
		int idCat = Integer.parseInt(request.getParameter("cid"));
		DanhMucTinDAO dmtDAO = new DanhMucTinDAO();
		TinTucDAO tintucDAO = new TinTucDAO();
		tintucDAO.delItemByIDCAT(idCat);
		if(dmtDAO.delItem(idCat)>0){
			response.sendRedirect(request.getContextPath()+"/admin/danhmuc?msg=3");
			return;
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/danhmuc?msg=0");
			return;
		}
	}
	
	else{
		response.sendRedirect(request.getContextPath()+"/admin/danhmuc?msg=0");
	}
	}
}
