package processor;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import data.Category;
import data.SpendLog;
import data.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/writeComplex")
public class WriteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date now = new Date(System.currentTimeMillis());
		req.setAttribute("now", now);

		CategoryController categoryDao = new CategoryController();
		try {
			List<Category> list = categoryDao.findAll();
			req.setAttribute("categories", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/view/user/write.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date spendAt = Date.valueOf(req.getParameter("spendAt"));
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		int amt = Integer.parseInt(req.getParameter("amt"));
		String useDesc = req.getParameter("useDesc");

		Users user = (Users) req.getSession().getAttribute("logonUser");
		String userId = user.getId();

		SpendLog log = new SpendLog(0, userId, amt, spendAt, useDesc, categoryId, null);// 생성자 기준으로. 나열해야한다.

		SpendLogController spendLogDao = new SpendLogController();
		try {
			boolean result = spendLogDao.save(log);
			if (result) {
				resp.sendRedirect(req.getServletContext().getContextPath() + "/view/user/log");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
