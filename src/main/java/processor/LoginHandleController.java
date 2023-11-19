package processor;

import java.io.IOException;

import data.users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginHandle")
public class LoginHandleController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");

		userController userCon = new userController();
		boolean loginResult=false;
		try {
		users found = userCon.findById(id);
		
		if(found != null && found.getPassword().equals(password)) {
			loginResult=true;
			HttpSession session = req.getSession(true);
			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("loginResult", loginResult);
		req.getRequestDispatcher("WEB-INF/view/user/loginHandle_form.jsp").forward(req, resp);
		

		

	}

}
