package photoeditor.filter;

import java.io.IOException;
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


@WebFilter(
		filterName="myFilter",
		urlPatterns= {"/editor","/review"}
		)
public class MyFilter implements Filter {

    public MyFilter() { }

    public void init(FilterConfig fConfig) throws ServletException {
		
	}
    
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession(false);
		if(session == null) {
			res.sendRedirect("home");
			return;
		} else {
			chain.doFilter(request, response);
		}
	}

}
