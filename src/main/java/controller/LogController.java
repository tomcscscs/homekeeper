package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
public class LogController extends HttpServlet {// 여기 로그 컨트롤러는 포스트를 사용하지 않아. 오늘 목표는 날짜 검색 데이터를 찾는거야.

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SpendLogDao spendLogDao = new SpendLogDao();// 뭐하려고 뽑은거야?[모든 로그를 뽑기위해서 만드거야.]

		String begin = req.getParameter("begin");
		String end = req.getParameter("end");

		Users user = (Users) req.getSession().getAttribute("logonUser");// 로그온 세션을 이용하기 위해서 세션을 만들어둔 것.
		String userId = user.getId();// 결국에는 세션에 유저에서 겟아이디로 아이디를 뽑아냄. 이제 이걸가지고 요리한다.

		try {

			LocalDate now = LocalDate.now();
			Date endDate = (end == null || end.equals("")) ? Date.valueOf(now) : Date.valueOf(end);
			Date beginDate = (begin == null || begin.equals("")) ? Date.valueOf(now.minusYears(1)) : Date.valueOf(begin);

			List<SpendLog> list = spendLogDao.findUserDate(userId, beginDate, endDate);// 훑으면 특정 list가 나오게 되어 있음.
			req.setAttribute("logs", list);// 리스트를 로그라는 이름으로 셋을 한다.

			int total = 0;
			for (SpendLog one : list) {
				total += one.getAmt();
			}
			req.setAttribute("total", total);// 합계를 total로 내놓는.
			// 카테고리 아이디는 안뽑아도 될 듯 합니다. 지금은.
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/view/user/log.jsp").forward(req, resp);

	}

}
