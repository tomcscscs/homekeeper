package processor;

import java.io.IOException;

import data.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/joinHandle")
public class JoinHandleController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		int birth = Integer.parseInt(req.getParameter("birth"));
		String gender = req.getParameter("gender");
		String nickname = req.getParameter("nickname");
		String avatarId = req.getParameter("avatarId");

		userController userCon = new userController();

		try {
			Users found = userCon.findById(id);
			if (found != null) {
				req.setAttribute("saveResult", false);
				req.setAttribute("existUser", found);
			} else {
				Users one = new Users(id, password, birth, gender, nickname, avatarId);
				userCon.save(one);
				req.setAttribute("saveResult", true);
				req.setAttribute("savedUser", one);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/view/user/joinHandle_form.jsp").forward(req, resp);

	}

}
