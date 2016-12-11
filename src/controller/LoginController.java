package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.StringLibrary;
import model.dao.UsersDAO;

/**
 * Servlet implementation class LoginController
 */
//@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request, response);
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
		
		String username1 = request.getParameter("username");
		String password1 = StringLibrary.md5(request.getParameter("password"));
		UsersDAO usersDAO = new UsersDAO();
		if(usersDAO.checkLogin(username1,password1)!=null){
			//Đăng nhập đúng ?
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", usersDAO.checkLogin(username1,password1));
			session.setAttribute("username", username1);
			
			response.sendRedirect(request.getContextPath()+"/admin?msg=1");
			return;
		}else{
			//Đăng nhập sai
			response.sendRedirect(request.getContextPath()+"/admin/login?msg=0");
			return;
		}
	}

}
