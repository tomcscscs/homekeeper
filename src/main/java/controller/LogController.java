package controller;

import java.io.IOException;
import java.util.List;

import dao.SpendLogDao;
import data.SpendLog;
import data.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/log")
public class LogController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SpendLogDao spendLogDao = new SpendLogDao();// 뭐하려고 뽑은거야?[모든 로그를 뽑기위해서 만드거야.]

		Users user = (Users)req.getSession().getAttribute("logonUser");// 로그온 세션을 이용하기 위해서 세션을 만들어둔 것.

		String userId = user.getId();// 결국에는 세션에 유저에서 겟아이디로 아이디를 뽑아냄. 이제 이걸가지고 요리한다.

		try {
			List<SpendLog> list = spendLogDao.findUserId(userId);// 훑으면 특정 list가 나오게 되어 있음.
			int total = 0;
			for (SpendLog one : list) {
				total += one.getAmt();
			}
			req.setAttribute("total", total);//합계를 total로 내놓는.
			req.setAttribute("logs", list);// 리스트를 로그라는 이름으로 셋을 한다.
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/view/user/log.jsp").forward(req, resp);

	}

}
