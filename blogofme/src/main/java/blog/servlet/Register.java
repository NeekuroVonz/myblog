package blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.dao.BlogDao;
import blog.dao.BlogUserDao;
import blog.entity.BlogUser;
import blog.entity.ConnectionTest;
import blog.service.BlogWebService;

@WebServlet("/user/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogWebService service;
	
    public Register() {
        super();
        service = new BlogWebService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/user/register/register.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BlogUser user = new BlogUser();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		service.insert(user);
//		ConnectionTest.connect(user.getName(), user.getEmail());
		request.setAttribute("user", user);
		response.sendRedirect("/blogofme/user/login");
	}

}
