package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
import model.bean.TinTuc;
import model.bean.Users;
import model.dao.DanhMucTinDAO;
import model.dao.TinTucDAO;

/**
 * Servlet implementation class IndexUsersAdminController
 */
//@WebServlet("/IndexUsersAdminController")
@MultipartConfig
public class AddNewsAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsAdminController() {
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
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("userInfo");
		int id_users = user.getIdUsers();
		System.err.println(id_users);
		String tenbaiviet = request.getParameter("tenbaiviet");
		int idDMT = Integer.parseInt(request.getParameter("tendanhmuc"));
		Timestamp ngaydang = new Timestamp(System.currentTimeMillis());
		String mota = request.getParameter("mota");
		String noidung = request.getParameter("noidung");
		TinTucDAO tintucDAO = new TinTucDAO();
		
		final String path = request.getServletContext().getRealPath("files");
		File dirFile = new File(path);
		if (!dirFile.exists()) {
			dirFile.mkdir();
		}
		final Part filePart = request.getPart("hinhanh");
		final String fileName = FileNameLibrary.getFileName(filePart);
		System.out.println(filePart);
		String picture ="";
		if (!"".equals(fileName)) {
			// Người dùng chọn ảnh
			OutputStream out = null;
			InputStream filecontent = null;
			picture = RenameFileLibrary.renameFile(fileName);
			try {
				out = new FileOutputStream(new File(path + File.separator + picture));
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
		} 
		
		TinTuc objTT = new TinTuc(0, tenbaiviet, mota, noidung, picture, ngaydang, idDMT, id_users);
		if(tintucDAO.addItem(objTT)>0){
			response.sendRedirect(request.getContextPath()+"/admin/baiviet?msg=1");
			return;
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/baiviet?msg=0");
				return;
			}
	}

}
