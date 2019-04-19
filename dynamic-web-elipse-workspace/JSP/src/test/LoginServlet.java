package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = "pinksung";
		String pwd = "1234";
		String name = "이도훈";
		
		String target = request.getParameter("target");
		
		if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd"))) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
		
			if(target.isEmpty()) {
				response.sendRedirect("main.jsp");
			} else {
				response.sendRedirect(target);
			}
			
			response.sendRedirect("main.jsp");
			
		} else {
			request.setAttribute("error", "error");
			doGet(request, response);
		}
		
	}

}
