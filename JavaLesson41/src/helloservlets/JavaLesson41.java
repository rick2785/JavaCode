package helloservlets;

import java.io.IOException;
import java.io.PrintWriter; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JavaLesson41
 */
@WebServlet("/JavaLesson41")
public class JavaLesson41 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usersName = request.getParameter("yourname");
		
		String theLang = request.getParameter("Language");
		
		int firstNum = Integer.parseInt(request.getParameter("firstnum"));
		int secondNum = Integer.parseInt(request.getParameter("secondnum"));
		int sumONum = firstNum + secondNum;
		
		response.setContentType("text/html");
		
		PrintWriter output = response.getWriter();
		
		output.println("<html><body><h3>Hello " + usersName);
		
		output.println("</h3><br />" + firstNum + " + " + secondNum);
		output.println(" = " + sumONum + "<br />Speaks " + theLang + "</body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
