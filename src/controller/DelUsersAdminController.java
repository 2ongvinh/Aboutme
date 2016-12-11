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
import model.bean.Users;
import model.dao.DanhMucTinDAO;
import model.dao.TinTucDAO;
import model.dao.UsersDAO;

/**
 * Servlet implementation class DelCatAdminController
 */
// @WebServlet("/DelCatAdminController")
public class DelUsersAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelUsersAdminController() {
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
		int idUser = Integer.parseInt(request.getParameter("uid"));
		UsersDAO usersDAO = new UsersDAO();
		Users nd = usersDAO.getItemByID(idUser);
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("userInfo");
		PhanQuyen pq = new PhanQuyen();
		if (pq.PqUser(user, nd) == 2 || pq.PqUser(user, nd) == 4) {
			final String path = request.getServletContext().getRealPath("files");
			String picture_old = usersDAO.getItemByID(idUser).getPicture();
			if (!"".equals(picture_old)) {
				String urlDelFile = path + File.separator + picture_old;
				File delFile = new File(urlDelFile);
				delFile.delete();
			}
			TinTucDAO tintucDAO = new TinTucDAO();
			tintucDAO.delItemByIDUSER(idUser);
			if (usersDAO.delItem(idUser) > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/nguoidung?msg=3");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/admin/nguoidung?msg=0");
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/nguoidung?msg=0");
		}
	}

}
