package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DanhMucTinDAO;
import model.dao.LienHeDAO;
import model.dao.TinTucDAO;

/**
 * Servlet implementation class DelCatAdminController
 */
//@WebServlet("/DelCatAdminController")
public class DelAllLienHeAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelAllLienHeAdminController() {
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
		
		LienHeDAO lienheDAO = new LienHeDAO();
		final String path = request.getServletContext().getRealPath("files");
		boolean check=true;
		String[]lienhe =request.getParameterValues("idCheckbox");
		for(int i=0;i<lienhe.length;i++){
			int idLH = Integer.parseInt(lienhe[i]);
			if(!(lienheDAO.delItem(idLH)>0)){
				check=false;
			}
		}
		if(check){
			response.sendRedirect(request.getContextPath()+"/admin/lienhe?msg=3");
			return;
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/lienhe?msg=0");
			return;
		}
	}

}
