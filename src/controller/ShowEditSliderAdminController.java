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
import model.bean.CapBac;
import model.bean.DanhMucTin;
import model.bean.DanhNgon;
import model.bean.DuAn;
import model.bean.Gioithieu;
import model.bean.Slider;
import model.bean.Users;
import model.dao.CapBacDAO;
import model.dao.DanhMucTinDAO;
import model.dao.DanhNgonDAO;
import model.dao.DuAnDAO;
import model.dao.GioithieuDAO;
import model.dao.SliderDAO;
import model.dao.UsersDAO;

/**
 * Servlet implementation class IndexUsersAdminController
 */
//@WebServlet("/IndexUsersAdminController")
public class ShowEditSliderAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEditSliderAdminController() {
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
		int idS1 = Integer.parseInt(request.getParameter("id"));
		SliderDAO sliderDAO = new SliderDAO();
		Slider objSlider = sliderDAO.getItemByID(idS1);
		request.setAttribute("objSlider", objSlider);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/editSlider.jsp");
		rd.forward(request, response);
	}

}
