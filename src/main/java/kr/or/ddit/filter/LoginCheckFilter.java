package kr.or.ddit.filter;

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
// 접속여부를 확니해서 (세션에 USER_INFO 속성이 존재하는지)
// 접속이 안되어 있으면 -->login화면으로 이동
// 접속이 되어있으면 정상적으로 최초요청한 리소스로 위임
@WebFilter(urlPatterns={"/*"})
public class LoginCheckFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String contextPath = req.getContextPath();
		String uri = req.getRequestURI();
		uri = uri.substring(contextPath.length());
		
		if (uri.startsWith("/login") || uri.startsWith("/js") || uri.startsWith("/css")|| uri.startsWith("/img")) {
			chain.doFilter(request, response);
		}else if(req.getSession().getAttribute("USER_INFO") != null){
			chain.doFilter(request, response);
			
		}else{
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect(contextPath + "/login");
		}
		
	}

	public void destroy() {
		
	}

}
