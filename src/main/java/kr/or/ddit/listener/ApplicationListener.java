package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		application.setAttribute("cp", application.getContextPath());
		
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		
	}

}
