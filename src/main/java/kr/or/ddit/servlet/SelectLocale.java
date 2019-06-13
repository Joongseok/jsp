package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectLocale")
public class SelectLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lan = request.getParameter("lan");
		lan = lan == null ? "ko" : lan;
		
		request.setAttribute("lan", lan);
		
		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lan = request.getParameter("lan");
		request.setAttribute("lan", lan);
		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request, response);
	}

}
