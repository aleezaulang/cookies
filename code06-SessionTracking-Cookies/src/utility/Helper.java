package utility;

import javax.servlet.http.*;

public class Helper {

	public static Cookie getCookie(Cookie [] cookies, String targetName) {
		Cookie targetCookie = null;
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(targetName)) {
					targetCookie = cookie;
					break;
				}
			}
		}
		return targetCookie;
	}
}
