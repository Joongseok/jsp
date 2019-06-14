package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class DefaultParamFilter implements Filter {

    public DefaultParamFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	DefaultParamWrapper requestWrapper = new DefaultParamWrapper((HttpServletRequest) request);

    	requestWrapper.setParameter("UNT_CD", new String[]{"LINE"});
    	chain.doFilter(requestWrapper, response);
    }
    
	public void destroy() {
	}


}
