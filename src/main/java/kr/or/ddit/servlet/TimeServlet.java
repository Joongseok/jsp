package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimeServlet extends HttpServlet{
	
	private Logger logger = LoggerFactory.getLogger(TimeServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		
		// localhost/jsp/timeTable?param=6
		String param = req.getParameter("i");
		String param2 = req.getParameter("j");
		
//		System.out.println("param : " + param);
		
		logger.debug("param : {} ", param);
		logger.debug("param2 : {} ", param2);
		
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title> TimeServlet </title>");
		pw.write("	<style>");
		pw.write("		td{border : 1px solid black;}");
		pw.write("	</style>");
		pw.write("	</head>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("<table border='1'>");
//		for (int gop = 1; gop <= 9; gop++) {
//			pw.write("<tr>");
//			for (int dan = 2; dan <= 9; dan++) {
//				pw.write("<td>" + dan + " * " + gop + " = " +dan*gop+ "</td>");
//			}
//			pw.write("</tr>");
//		}
		for (int i = 1; i <= Integer.parseInt(param2); i++) {
			pw.write("<tr>");
			for (int j = 2; j <= Integer.parseInt(param); j++) {
				pw.write("<td>" + j + " * " + i + " = " + j * i + "</td>");
			}
			pw.write("</tr>");
		}
		pw.write("</table>");
		pw.write("	</body>");
		pw.write("</html>");
		
		pw.close();
	}
}
