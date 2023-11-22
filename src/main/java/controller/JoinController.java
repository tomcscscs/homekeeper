package controller;

import java.io.IOException;
import java.util.List;

import dao.AvatarsDao;
import data.Avatars;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class JoinController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AvatarsDao avatarDao = new AvatarsDao();
		List<Avatars> avatars;
		try {
			avatars = avatarDao.findAll(); //avatarDao 라고 설정해준 것이 프로세서.
			req.setAttribute("avatars", avatars);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/view/user/join_form.jsp").forward(req, resp);

	}

}
