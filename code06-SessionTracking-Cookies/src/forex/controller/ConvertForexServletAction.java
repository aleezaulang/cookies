package forex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import forex.model.ForexBean;

/*
 Step 2 -  Use a servlet to handle requests. Servlet reads request parameters, checks for missing
and malformed data, calls business logic, etc
 */

public class ConvertForexServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		System.out.println("inside the init() method");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//The Integer.parseInt() method converts a String value to an equivalent int value
		int amountInPeso = Integer.parseInt(request.getParameter("pesoAmount"));
		
		//objective is to retrieve the selected currency
		String currency = request.getParameter("currencyTarget");
		
		//step 2 - validation of input data - checking malformed or invalid input
		if ( (amountInPeso > 500 && amountInPeso <= 100000)) {			
			if (currency.equals("USD") || currency.equals("EUR") || currency.equals("JPY")) {
				
				/*
				 Step 3 - Obtain bean instances The servlet invokes business logic (application-specific
				code) or data-access code to obtain the results.   
				 */
				ForexBean forex = new ForexBean(amountInPeso, currency);
				forex.convertAmount();
				
				//create multiple cookies
				Cookie pesoInputCookie = new Cookie("pesoInput", 
					new Integer(forex.getPesoAmount()).toString());
				Cookie selectedCurrencyCookie = new Cookie("selectedCurr", 
						forex.getCurrency());
				Cookie convertedAmountCookie = new Cookie("convertedAmount", 
					new Double(forex.getConvertedAmount()).toString());
				
				//set the age of the cookie to make it persistent
				pesoInputCookie.setMaxAge(30 * 24 * 60 * 60);
				selectedCurrencyCookie.setMaxAge(30 * 24 * 60 * 60);
				convertedAmountCookie.setMaxAge(30 * 24 * 60 * 60);
				
				//send all the created cookies to the user's browser
				response.addCookie(pesoInputCookie);
				response.addCookie(selectedCurrencyCookie);
				response.addCookie(convertedAmountCookie);
				
				response.getWriter().print("<p>Please click <a href='display.html'>here</a> to continue.</p>");
			} else {
				response.sendRedirect("error.action");
			}			
		} else {
			//redirect to another page if the condition above is valid
			response.sendRedirect("error.action");
		}
	}
	
	public void destroy() {
		System.out.println("inside the destroy() method");
	}
}
