package test01;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.IndexControler;

/**
 * Servlet implementation class fc
 */
@WebServlet("*.do")
public class fc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, Controller> map;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public fc() {
		super();
		// TODO Auto-generated constructor stub
		map = new HashMap<String, Controller>();
		map.put("/index.do", new IndexControler());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private String getUri(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String path = uri.substring(ctxPath.length());
		return path;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = getUri(req);
		Controller controller = map.get(uri);
		if (controller != null) {
			String target;
			if (req.getMethod().equalsIgnoreCase("GET")) {
				target = controller.doGet(req, resp);
			} else {
				target = controller.doPost(req, resp);
			}
			move(req, resp, target);
		} else {
			resp.sendError(404, uri + "경로가 없습니다.");
		}
	}

	protected void move(HttpServletRequest req, HttpServletResponse resp, String target)
			throws ServletException, IOException {
		if (target.startsWith("redirect:")) {
			target = target.substring("redirect:".length());
			if (target.startsWith("/")) {
				target = req.getContextPath() + target;
			}
			resp.sendRedirect(target);
		} else {
			target += "jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(target);
			dispatcher.forward(req, resp);
		}
	}

}
