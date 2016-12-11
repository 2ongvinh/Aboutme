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
import model.dao.QuangCaoDAO;
import model.dao.UsersDAO;

/**
 * Servlet implementation class DelCatAdminController
 */
// @WebServlet("/DelCatAdminController")
public class DelQuangCaoAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelQuangCaoAdminController() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		if (!CheckLoginLibrary.CheckLogin(request, response)) {
			return;
		}
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("userInfo");
		if (user.getIdCapbac() == 1) {
			int idQC1 = Integer.parseInt(request.getParameter("id"));
			QuangCaoDAO quangcaoDAO = new QuangCaoDAO();
			final String path = request.getServletContext().getRealPath("files");
			String picture_old = quangcaoDAO.getItemByID(idQC1).getHinhanhQuangcao();
			if (!"".equals(picture_old)) {
				String urlDelFile = path + File.separator + picture_old;
				File delFile = new File(urlDelFile);
				delFile.delete();
			}
			if (quangcaoDAO.delItem(idQC1) > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/quangcao?msg=3");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/admin/quangcao?msg=0");
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/quangcao?msg=0");
		}
	}

}
