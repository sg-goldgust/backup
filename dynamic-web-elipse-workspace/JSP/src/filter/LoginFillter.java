package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFillter
 */
@WebFilter(
		urlPatterns = { 
				"/main.jsp" ,"/view_images"
		})
public class LoginFillter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFillter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	private String getTarget(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String param =req.getQueryString();
		String target = param == null? uri : uri + "?" + param;
		return target;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		if (id != (null)) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse res = (HttpServletResponse)response;
			String appPath = req.getContextPath();
			
			Map<String,Object>map = new HashMap<>();
			map.put("reason","로그인필요");
			map.put("target",getTarget(req));
			session.setAttribute("flash", map);
			res.sendRedirect(appPath+"/login");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
