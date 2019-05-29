package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/el")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//${userId} : request -> session -> application
		// 3가지 scpoe 객체에 같은 이름의 속성명으로 다른 값을 설정
		request.setAttribute("userId", "brown_request");
		request.getSession().setAttribute("userId", "cony_session");
		getServletContext().setAttribute("userId", "sally_application");
		
		request.getRequestDispatcher("/el/el.jsp").forward(request, response);
		
	}
}
