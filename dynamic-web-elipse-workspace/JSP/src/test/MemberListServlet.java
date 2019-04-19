package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Member;
import domain.PageInfo;
import unit04.service.MemberService;
import unit04.service.MemberServiceImpl;
import unit04.util.ParseUtil;


/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/hi")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service; // 지역변수면 안되고 singleton으로 만들어준다.
       	
    public MemberListServlet() {
        super();
        //service = new MemberServiceImpl();
        service = MemberServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strPage = request.getParameter("page");
		/*if(strPage != null) {
			page = Integer.parseInt(strPage);
		}*/
		int page=ParseUtil.parseInt(strPage);
		PageInfo<Member> pi = service.getPage(page);
		
		 
		
		request.setAttribute("pi", pi);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
