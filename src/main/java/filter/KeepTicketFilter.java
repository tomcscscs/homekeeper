package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class KeepTicketFilter extends HttpFilter {
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Cookie[] cookies = request.getCookies();
		Cookie found= null;
		if(cookies != null && cookies.length >0) {
			for(Cookie one : cookies) {
				if(one.getName().equals("ticketCode")) {
					found= one;
					break;
					
				}//여기까지 쿠키를 찾은거 같은데 일치하는.
					
			}
		}
		if(found != null) {
			String code =  
		}
		
		
		
		
		
	}

}
