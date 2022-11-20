package forex.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import forex.model.ForexBean;
import utility.Helper;

public class DisplayViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html");
		
		PrintWriter out = response.getWriter();
		
		Cookie [] allCookies = request.getCookies();
		
		Cookie pesoCookie = null;
		Cookie selectedCurr = null;
		Cookie amountConverted = null;
		
		if (allCookies != null) {
			
			pesoCookie = Helper.getCookie(allCookies, "pesoInput");
			selectedCurr = Helper.getCookie(allCookies, "selectedCurr");
			amountConverted = Helper.getCookie(allCookies, "convertedAmount");
			
			if (pesoCookie != null && selectedCurr != null && amountConverted != null) {
				out.print("<html>");
				out.print("<head><title>BPI Forex Servlet Lifecycle Demo</title></head>");
				out.print("<body>");
				out.print("<img src='images/forex.jpg'/>");
				
				/*
				 Step 6 - Extract the data from the beans using the getter methods. 
				 */
				out.print("<p>The amount of <b>Php" + pesoCookie.getValue() + "</b> is equivalent to <b>" 
						+ selectedCurr.getValue()+ " " + amountConverted.getValue()  +"</b>");
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
		
		
		

	}

}
