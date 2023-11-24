package filter;

import java.io.IOException;
import java.sql.Date;

import dao.AvatarsDao;
import dao.KeepTicketsDao;
import dao.UsersDao;
import data.Avatars;
import data.KeepTickets;
import data.Users;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class KeepTicketFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		Cookie[] cookies = request.getCookies();
		Cookie found = null;
		if (cookies != null && cookies.length > 0) {
			for (Cookie one : cookies) {
				if (one.getName().equals("ticketCode")) {
					found = one;
					break;

				} // 여기까지 쿠키를 찾은거 같은데 일치하는.

			}
		}
		if (found != null) {
			String code = found.getValue();
			KeepTicketsDao keepDao = new KeepTicketsDao();
			try {
				KeepTickets foundTicket = keepDao.findById(code);// 킵 해당 객체
				Date now = new Date(System.currentTimeMillis());
				System.out.println(foundTicket.getExpiredAt().after(now));

				if (foundTicket != null && foundTicket.getExpiredAt().after(now)) { // 밸류 무효x
					String userId = foundTicket.getUserId();
					UsersDao userDao = new UsersDao();

					Users foundUser = userDao.findById(userId);
					request.getSession().setAttribute("logonUser", foundUser);
					chain.doFilter(request, response);

				}
				chain.doFilter(request, response);
			} // if end
			catch (Exception e) {
				e.printStackTrace();

			}

		}

	}
}
