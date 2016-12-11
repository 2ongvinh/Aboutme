package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.CheckLoginLibrary;
import model.bean.DanhMucTin;
import model.bean.Users;
import model.dao.DanhMucTinDAO;

/**
 * Servlet implementation class IndexUsersAdminController
 */
//@WebServlet("/IndexUsersAdminController")
public class AddCatAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCatAdminController() {
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
		
		HttpSession session=request.getSession();
		Users user = (Users)session.getAttribute("userInfo");
		if(user.getIdCapbac()==1){
		DanhMucTinDAO dmtDAO = new DanhMucTinDAO();
		String tendanhmuc = request.getParameter("tendanhmuc");
		DanhMucTin objDMT = new DanhMucTin(0, tendanhmuc);
		
		if(dmtDAO.checkCat(tendanhmuc) != null){
   	   	 
	    	 response.sendRedirect(request.getContextPath()+"/admin/themdanhmuc?msg=0");
	     }else{
		if(dmtDAO.addItem(objDMT)>0){
			response.sendRedirect(request.getContextPath()+"/admin/danhmuc?msg=1");
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/danhmuc?msg=0");
		}
	     }}
		else{
			response.sendRedirect(request.getContextPath()+"/admin/danhmuc?msg=0");
		}
	}
}
