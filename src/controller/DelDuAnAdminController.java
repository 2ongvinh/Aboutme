package controller;

import java.io.File;
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
import model.dao.DanhNgonDAO;
import model.dao.DuAnDAO;
import model.dao.UsersDAO;

/**
 * Servlet implementation class DelCatAdminController
 */
//@WebServlet("/DelCatAdminController")
public class DelDuAnAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelDuAnAdminController() {
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
		int idDA1 = Integer.parseInt(request.getParameter("id"));
		DuAnDAO duanDAO = new DuAnDAO();
		final String path = request.getServletContext().getRealPath("files");
		String picture_old = duanDAO.getItemByID(idDA1).getHinhanhDuan();
		if(!"".equals(picture_old)){
			String urlDelFile = path+File.separator+picture_old;
			File delFile = new File(urlDelFile);
			delFile.delete();
		}
		if(duanDAO.delItem(idDA1)>0){
			response.sendRedirect(request.getContextPath()+"/admin/duan?msg=3");
			return;
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/duan?msg=0");
			return;
		}
		}
		else{
			response.sendRedirect(request.getContextPath()+"/admin/duan?msg=0");
		}
	}

}
