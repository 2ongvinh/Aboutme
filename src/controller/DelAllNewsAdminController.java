package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DanhMucTinDAO;
import model.dao.TinTucDAO;

/**
 * Servlet implementation class DelCatAdminController
 */
//@WebServlet("/DelCatAdminController")
public class DelAllNewsAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelAllNewsAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TinTucDAO tintucDAO = new TinTucDAO();
		final String path = request.getServletContext().getRealPath("files");
		boolean check=true;
		String[]news =request.getParameterValues("idCheckbox");
		for(int i=0;i<news.length;i++){
			int idNews = Integer.parseInt(news[i]);
			String picture_old = tintucDAO.getItemByID(idNews).getHinhanhTT();
			if(!"".equals(picture_old)){
				String urlDelFile = path+File.separator+picture_old;
				File delFile = new File(urlDelFile);
				delFile.delete();
			}
			if(!(tintucDAO.delItem(idNews)>0)){
				check=false;
			}
		}
		if(check){
			response.sendRedirect(request.getContextPath()+"/admin/baiviet?msg=3");
			return;
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/baiviet?msg=0");
			return;
		}
	}

}
