package controller;

import java.io.IOException;
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
 * Servlet implementation class EditCatAdminController
 */
// @WebServlet("/EditCatAdminController")
public class EditCatAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCatAdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (!CheckLoginLibrary.CheckLogin(request, response)) {
			return;
		}
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("userInfo");
		if (user.getIdCapbac() == 1) {
			DanhMucTinDAO dmtDAO = new DanhMucTinDAO();
			int idCat = Integer.parseInt(request.getParameter("cid"));
			String tendanhmuc = request.getParameter("tendanhmuc");
			DanhMucTin objDMT = new DanhMucTin(idCat, tendanhmuc);
			if (dmtDAO.checkCat(tendanhmuc) != null) {

				response.sendRedirect(request.getContextPath() + "/admin/suadanhmuc?cid=" + idCat + "&msg=0");
			} else {
				if (dmtDAO.editItem(objDMT) > 0) {
					response.sendRedirect(request.getContextPath() + "/admin/danhmuc?msg=2");
					return;
				} else {
					response.sendRedirect(request.getContextPath() + "/admin/danhmuc?msg=0");
					return;
				}
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/danhmuc?msg=0");
		}
	}
}
