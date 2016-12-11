package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Users;
import model.dao.UsersDAO;

/**
 * Servlet implementation class CheckUsername
 */
//@WebServlet("/CheckUsername")
public class CheckUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUsername() {
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
		PrintWriter out = response.getWriter();
		UsersDAO usersDAO = new UsersDAO();
		String username = request.getParameter("ausername");
		Users objUsers = (Users)usersDAO.checkUsername(username);
		if(objUsers == null){
				out.print("<label for=\"inputFirstName\">Username (*)</label>"
                    +"<input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" value=\""+username+"\" onchange =\"return checkUsername();\">"+  
                     "<span style=\"color:green\">"+"Username is available"+"</span>");
				
			}else{
				out.print("<label for=\"inputFirstName\">Username (*)</label>"
	                    +"<input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" value=\"\" onchange =\"return checkUsername();\">"+  
	                     "<span style=\"color:red\">"+"Username is already in use"+"</span>");
			}
		}
	
}

