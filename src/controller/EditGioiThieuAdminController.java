package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;

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
import library.RenameFileLibrary;
import model.bean.DanhMucTin;
import model.bean.Gioithieu;
import model.bean.TinTuc;
import model.bean.Users;
import model.dao.DanhMucTinDAO;
import model.dao.GioithieuDAO;
import model.dao.TinTucDAO;
import model.dao.UsersDAO;

/**
 * Servlet implementation class EditCatAdminController
 */
// @WebServlet("/EditCatAdminController")
@MultipartConfig
public class EditGioiThieuAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditGioiThieuAdminController() {
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
		if (user.getIdCapbac() == 1) {

			int idGT = Integer.parseInt(request.getParameter("id"));
			GioithieuDAO gioithieuDAO = new GioithieuDAO();
			String ngay = request.getParameter("ngay");
			String tieude = request.getParameter("tieude");
			String noidung = request.getParameter("noidung");

			String picture = "";

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
				String picture_old = gioithieuDAO.getItemByID(idGT).getHinhanhGioithieu();
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
				picture = gioithieuDAO.getItemByID(idGT).getHinhanhGioithieu();

			}

			Gioithieu objGT = new Gioithieu(idGT, ngay, tieude, noidung, picture);

			if (gioithieuDAO.editItem(objGT) > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/gioithieu?msg=2");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/admin/gioithieu?msg=0");
				return;
			}
		}

		else {
			response.sendRedirect(request.getContextPath() + "/admin/gioithieu?msg=0");
		}
	}

}
