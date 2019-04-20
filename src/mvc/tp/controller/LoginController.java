package mvc.tp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.tp.dao.LoginDao;
import mvc.tp.model.User;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	public LoginController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { //abro el dopost
		
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	RequestDispatcher rd = null;
	
	User loginUser = new User();
	
	loginUser.setUsername(username);
	loginUser.setPassword(password);
		
	LoginDao loginDao = new LoginDao();
	String result = loginDao.authenticateUser(loginUser);
	
	if (result.equals("success_adm")) {
		rd = request.getRequestDispatcher("/user.jsp");
		User user = new User(username, password);
		request.setAttribute("user", user); 
	} 
	else{
		if (result.equals("success_usr")) {
			rd = request.getRequestDispatcher("/index.jsp");		
		}
		else{
			rd = request.getRequestDispatcher("/error.jsp");
		}
		
	}
	
	rd.forward(request, response);
		
	}
	
}