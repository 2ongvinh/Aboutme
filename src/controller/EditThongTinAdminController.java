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
import model.bean.ThongTin;
import model.bean.Users;
import model.dao.DanhMucTinDAO;
import model.dao.ThongTinDAO;

/**
 * Servlet implementation class EditCatAdminController
 */
// @WebServlet("/EditCatAdminController")
public class EditThongTinAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditThongTinAdminController() {
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
			ThongTinDAO thongtinDAO = new ThongTinDAO();

			int idThT = Integer.parseInt(request.getParameter("id"));
			String diachi = request.getParameter("diachi");
			int sdt = Integer.parseInt(request.getParameter("sdt"));
			String email = request.getParameter("email");
			String skype = request.getParameter("skype");
			String wordpress = request.getParameter("wordpress");
			String facebook = request.getParameter("facebook");
			String linkfacebook = request.getParameter("linkfacebook");
			String twitter = request.getParameter("twitter");
			String linktwitter = request.getParameter("linktwitter");
			String googleplus = request.getParameter("googleplus");
			String linkgoogleplus = request.getParameter("linkgoogleplus");
			ThongTin objThongTin = new ThongTin(idThT, diachi, sdt, email, skype, wordpress, facebook, twitter,
					googleplus, linkfacebook, linktwitter, linkgoogleplus);

			if (thongtinDAO.editItem(objThongTin) > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/thongtin?msg=2");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/admin/thongtin?msg=0");
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/thongtin?msg=0");
		}
	}

}
