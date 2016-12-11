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
import model.bean.DanhNgon;
import model.bean.DuAn;
import model.bean.Gioithieu;
import model.bean.QuangCao;
import model.bean.Slider;
import model.bean.ThongTin;
import model.bean.TinTuc;
import model.bean.ViewHome;
import model.dao.DanhMucTinDAO;
import model.dao.DanhNgonDAO;
import model.dao.DuAnDAO;
import model.dao.GioithieuDAO;
import model.dao.QuangCaoDAO;
import model.dao.SliderDAO;
import model.dao.ThongTinDAO;
import model.dao.TinTucDAO;
import model.dao.ViewHomeDAO;
import model.dao.SliderDAO;

/**
 * Servlet implementation class IndexPublicController
 */
//@WebServlet("/IndexPublicController")
public class IndexPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexPublicController() {
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
		
		
		GioithieuDAO gioithieuDAO = new GioithieuDAO();
		ArrayList<Gioithieu> listGioithieu = gioithieuDAO.getItems();
		request.setAttribute("listGioithieu", listGioithieu);
		
		DanhMucTinDAO dmtDAO = new DanhMucTinDAO();
		ArrayList<DanhMucTin> listDMT = dmtDAO.getItems();
		request.setAttribute("listDMT", listDMT);
		
		TinTucDAO tintucDAO = new TinTucDAO();
		ArrayList<TinTuc> listTT = tintucDAO.getItems();
		request.setAttribute("listTT", listTT);
		
		DanhNgonDAO danhngonDAO = new DanhNgonDAO();
		ArrayList<DanhNgon> listDN = danhngonDAO.getItems();
		request.setAttribute("listDN", listDN);
		
		DuAnDAO duanDAO = new DuAnDAO();
		ArrayList<DuAn> listDuAn = duanDAO.getItems();
		request.setAttribute("listDuAn", listDuAn);
		
		QuangCaoDAO quangcaoDAO = new QuangCaoDAO();
		ArrayList<QuangCao> listQC = quangcaoDAO.getItems();
		request.setAttribute("listQC", listQC);
		
		ThongTinDAO thongtinDAO = new ThongTinDAO();
		ThongTin objThongTin = thongtinDAO.getItem();
		request.setAttribute("objThongTin",objThongTin);
		
		SliderDAO sliderDAO = new SliderDAO();
		ArrayList<Slider> listSlider = sliderDAO.getItems();
		request.setAttribute("listSlider",listSlider);
		
		ViewHomeDAO viewhomeDAO = new ViewHomeDAO();
		ViewHome objVH = null;
		int luotview1 = viewhomeDAO.luotView1(objVH);
		request.setAttribute("objVH",objVH);
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
		
	}

}
