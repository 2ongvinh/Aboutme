package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TinTucDAO;

/**
 * Servlet implementation class ActiveController
 */
@WebServlet("/ActiveController")
public class ActiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		TinTucDAO tintucDAO = new TinTucDAO();
		int trangthai = Integer.parseInt(request.getParameter("atrangthai"));
		int idNews =Integer.parseInt(request.getParameter("anid"));
		if(trangthai==1){
			if(tintucDAO.changeTT(idNews, 0)>0){
			out.print(
					"<center><a href=\"javascript:void(0)\" onclick=\"getActive(0,"+idNews+")\"><center>"+
					"<img src=\""+request.getContextPath()+"/admin/images/minus-circle.gif \" />"+
					"</a></center>"
		);}
		}else{
			if(tintucDAO.changeTT(idNews, 1)>0){
				out.print(
						"<center><a href=\"javascript:void(0)\" onclick=\"getActive(1,"+idNews+")\">"+
								"<img src=\""+request.getContextPath()+"/admin/images/tick-circle.gif \" />"+
						"</a></center>"
			);
			}
			
			
		}
	}

}
