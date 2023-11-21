package processor;

import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

import data.Avatars;
import data.KeepTickets;
import data.users;
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

		userController userCon = new userController();
		boolean loginResult;
		try {
			users found = userCon.findById(id);// found가 유저스.!!

			if (found == null || !found.getPassword().equals(password)) {
				loginResult = false;
				// System.out.println("AAAA");
				
			} else {
				loginResult = true;
				HttpSession session = req.getSession(true);
				session.setAttribute("logonUser", found);
				// System.out.println("BBBBB");
				
				AvatarsProcessor avatarDao = new AvatarsProcessor();
				Avatars foundAvatar = avatarDao.findByKey(found.getAvatarId());//항상 위의 데이터를 실어줘야해.
				req.getSession().setAttribute("logonUserAvatar", foundAvatar);
				
				resp.sendRedirect(req.getServletContext().getContextPath()+"/index");// 이거 뭐야.
				
				
				
				if (keep != null) {//로그인 유지. keep 체크박스.
					String code = UUID.randomUUID().toString();// uuid
					String userId = id;
					Date expiredAt = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30);

					KeepTickets ticket = new KeepTickets(code, userId, expiredAt);

					KeepTicketsController keepDao = new KeepTicketsController();
					keepDao.save(ticket);

					Cookie cookie = new Cookie("ticketCode", code);// uuid로 부여.
					cookie.setPath(req.getServletContext().getContextPath());// 쿠키 경로설정.
					cookie.setMaxAge(60 * 60 * 24 * 30);// 쿠키 지속시간.

					resp.addCookie(cookie);// 로그인 성공했을때 부여하는 쿠키.

				}

			}
			req.setAttribute("loginResult", loginResult);

		} catch (Exception e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("WEB-INF/view/user/loginHandle_form.jsp").forward(req, resp);

	}

}
