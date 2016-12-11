package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import library.CheckLoginLibrary;
import library.FileNameLibrary;
import library.PhanQuyen;
import library.RenameFileLibrary;
import library.StringLibrary;
import model.bean.DanhMucTin;
import model.bean.TinTuc;
import model.bean.Users;
import model.dao.DanhMucTinDAO;
import model.dao.TinTucDAO;
import model.dao.UsersDAO;

/**
 * Servlet implementation class EditCatAdminController
 */
// @WebServlet("/EditCatAdminController")
@MultipartConfig
public class EditUsersAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUsersAdminController() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (!CheckLoginLibrary.CheckLogin(request, response)) {
			return;
		}
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("userInfo");

		UsersDAO usersDAO = new UsersDAO();

		int idUser = Integer.parseInt(request.getParameter("uid"));
		
		String username = request.getParameter("username");
		String password = StringLibrary.md5(request.getParameter("password"));
		String fullname = request.getParameter("fullname");
		Users nd = usersDAO.getItemByID(idUser);
		String picture = "";
		PhanQuyen pq = new PhanQuyen();
		if (pq.PqUser(user, nd) != 0) {

			final String path = request.getServletContext().getRealPath("files");
			File dirFile = new File(path);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			final Part filePart = request.getPart("hinhanh");
			final String fileName = FileNameLibrary.getFileName(filePart);

			if (!"".equals(fileName)) {

				OutputStream out = null;
				InputStream filecontent = null;
				picture = RenameFileLibrary.renameFile(fileName);
				String picture_old = usersDAO.getItemByID(idUser).getPicture();
				if (!"".equals(picture_old)) {
					String urlDelFile = path + File.separator + picture_old;
					File delFile = new File(urlDelFile);
					delFile.delete();
				}
				try {
					out = new FileOutputStream(path + File.separator + picture);
					filecontent = filePart.getInputStream();

					int read = 0;
					final byte[] bytes = new byte[1024];

					while ((read = filecontent.read(bytes)) != -1) {
						out.write(bytes, 0, read);
					}
				} catch (FileNotFoundException fne) {
					fne.printStackTrace();
				} finally {
					if (out != null) {
						out.close();
					}
					if (filecontent != null) {
						filecontent.close();
					}
				}
			} else {
				picture = usersDAO.getItemByID(idUser).getPicture();

			}
			
			
			if(user.getIdCapbac()==1){
			int idCB = Integer.parseInt(request.getParameter("capbac"));
			Users objUsers = new Users(idUser, username, password, fullname, picture, idCB, "");
			
			if (usersDAO.editItem(objUsers) > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/nguoidung?msg=2");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/admin/nguoidung?msg=0");
				return;
			}
			}else{
				Users objUsers1 = new Users(idUser, username, password, fullname, picture);

				if (usersDAO.editItem1(objUsers1) > 0) {
					response.sendRedirect(request.getContextPath() + "/admin/nguoidung?msg=2");
					return;
				} else {
					response.sendRedirect(request.getContextPath() + "/admin/nguoidung?msg=0");
					return;
				}
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/nguoidung?msg=0");
		}
	}
}
