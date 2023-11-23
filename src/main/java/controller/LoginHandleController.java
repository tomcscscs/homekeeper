package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

import dao.KeepTicketsDao;
import dao.UsersDao;
import data.Avatars;
import data.KeepTickets;
import data.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginHandle")
public class LoginHandleController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");// 넘어온 파라미터 로그인아이디. 혼동금지.
		String password = req.getParameter("password");
		String keep = req.getParameter("keep");

		UsersDao userCon = new UsersDao();//뀽
		boolean loginResult;
		try {
			Users found = userCon.findWithAvatarById(id);// found가 유저스.!!

			if (found == null || !found.getPassword().equals(password)) {
				loginResult = false;
				// System.out.println("AAAA");
				resp.sendRedirect(req.getServletContext().getContextPath()+"/index");

				
				
			} else {
				loginResult = true;
				HttpSession session = req.getSession(true);
				session.setAttribute("logonUser", found);
				// System.out.println("BBBBB");
				
				if (keep != null) {//로그인 유지. keep 체크박스.
					String code = UUID.randomUUID().toString();// uuid
					String userId = id;
					Date expiredAt = new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 30);

					KeepTickets ticket = new KeepTickets(code, userId, expiredAt);

					KeepTicketsDao keepDao = new KeepTicketsDao();
					keepDao.save(ticket);

					Cookie cookie = new Cookie("ticketCode", code);// uuid로 부여.
					cookie.setPath(req.getServletContext().getContextPath());// 쿠키 경로설정.
					cookie.setMaxAge(60 * 60 * 24 * 30);// 쿠키 지속시간.

					resp.addCookie(cookie);// 로그인 성공했을때 부여하는 쿠키.

				}

				
			}//이프문의 끝이야.
			req.setAttribute("loginResult", loginResult);//근데 이건 둘중에 하나밖에 하면 안된다는 사실이다 이거 참. 
			req.getRequestDispatcher("WEB-INF/view/user/loginHandle_form.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
