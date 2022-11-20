package forex.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text.html");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>BPI Forex Servlet Lifecycle Demo</title></head>");
		out.print("<body>");
		out.print("<img src='images/forex.jpg'/>");
		
		out.print("<h2><font color='red'>Error - you entered an invalid input. </font></h2>");
		out.print("<p>Please ensure that you will enter valid values only.</p>");
		out.print("<p>");
		out.print("<form action='index.html'>");
		out.print("	<input type='submit' value='<< GO BACK >>'>");
		out.print("</form>");
		out.print("<hr/>");
		out.print("<p><i>&copy; 2017 Bank of the Philippine Islands. All rights reserved.</i></p>");
		out.print("</body>");		
		out.print("</html>");
	out.close();
	}

}
