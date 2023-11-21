package processor;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("date", new Date(System.currentTimeMillis()));

		if (req.getSession().getAttribute("logonUser") == null) {
			req.getRequestDispatcher("/WEB-INF/view/user/index2.jsp").forward(req, resp);

		} else {
			req.getRequestDispatcher("/index.jsp");
		}

		req.getRequestDispatcher("/index.jsp").forward(req, resp);

	}

}//여기까지
