package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
import library.StringLibrary;
import model.bean.DanhMucTin;
import model.bean.TinTuc;
import model.bean.Users;
import model.dao.DanhMucTinDAO;
import model.dao.TinTucDAO;
import model.dao.UsersDAO;

/**
 * Servlet implementation class IndexUsersAdminController
 */
//@WebServlet("/IndexUsersAdminController")
@MultipartConfig
public class AddUsersAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUsersAdminController() {
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
		HttpSession session=request.getSession();
		Users user = (Users)session.getAttribute("userInfo");
		if(user.getIdCapbac()==1){
		String username = request.getParameter("username");
		String password = StringLibrary.md5(request.getParameter("password"));
		
		request.getParameterValues("chon");
	
		String fullname = request.getParameter("fullname");
		
		int idCapbac = Integer.parseInt(request.getParameter("capbac"));
		final String path = request.getServletContext().getRealPath("files");
		File dirFile = new File(path);
		if (!dirFile.exists()) {
			dirFile.mkdir();
		}
		final Part filePart = request.getPart("hinhanh");
		final String fileName = FileNameLibrary.getFileName(filePart);
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
		
		UsersDAO usersDAO = new UsersDAO();
		PrintWriter out = response.getWriter();
		Users objUsers = new Users(0, username, password, fullname, picture, idCapbac, "");
		if(usersDAO.checkUsername(username) != null){
	   	   	 
	    	 response.sendRedirect(request.getContextPath()+"/admin/themnguoidung?msg=5");
	     }else{
		
			
		
		if(usersDAO.addItem(objUsers)>0){
			response.sendRedirect(request.getContextPath()+"/admin/nguoidung?msg=1");
			return;
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/nguoidung?msg=0");
				return;
			}
		}
	}else{
		response.sendRedirect(request.getContextPath()+"/admin/nguoidung?msg=0");
	}
	}

}
