package controller;

import java.io.IOException;
import java.util.List;

import dao.SpendLogDao;
import data.SpendLog;
import data.StatisticVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/statisticHandle")
public class StatisticController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SpendLogDao spendDao = new SpendLogDao();
		List<StatisticVO> maxAmt;

		try {
			maxAmt = spendDao.statisticFindAll();
			req.setAttribute("maxAmt", maxAmt);// 캐치 밖으로 빠지면 안돼.
		} catch (ClassNotFoundException e) {
			System.out.println("something wrong.");
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/view/user/statistic.jsp").forward(req, resp);
	}

}
