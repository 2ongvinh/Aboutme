package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.PhanQuyen;
import model.bean.TinTuc;
import model.bean.Users;
import model.dao.DanhMucTinDAO;
import model.dao.TinTucDAO;
import model.dao.UsersDAO;

/**
 * Servlet implementation class DelCatAdminController
 */
//@WebServlet("/DelCatAdminController")
public class DelNewsAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelNewsAdminController() {
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
		int idNews = Integer.parseInt(request.getParameter("nid"));
		TinTucDAO tintucDAO = new TinTucDAO();
		UsersDAO usersDAO = new UsersDAO();
		TinTuc objTT = tintucDAO.getItemByID(idNews);
		Users nd=usersDAO.getItemByID(objTT.getIdUsers());
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("userInfo");
		PhanQuyen pq=new PhanQuyen();
		if(pq.PqUser(user, nd)!=0){
		final String path = request.getServletContext().getRealPath("files");
		String picture_old = tintucDAO.getItemByID(idNews).getHinhanhTT();
		if(!"".equals(picture_old)){
			String urlDelFile = path+File.separator+picture_old;
			File delFile = new File(urlDelFile);
			delFile.delete();
		}
		
		if(tintucDAO.delItem(idNews)>0){
			response.sendRedirect(request.getContextPath()+"/admin/baiviet?msg=3");
			return;
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/baiviet?msg=0");
			return;
		}}else{
			response.sendRedirect(request.getContextPath()+"/admin/baiviet?msg=0");
		}
		
	}

}
