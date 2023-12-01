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
		List<StatisticVO> maxAmt; // 앞에 이걸로 받아야 한다 타입을 좀.

		try {
			maxAmt = spendDao.statisticFindAll();// 변수 안에 요소들이 다 담긴상태.
			req.setAttribute("maxAmt", maxAmt);// 캐치 밖으로 빠지면 안돼. 일단 여기까지가 넣어준거야 결과값을.
			// 그래 지금까지 봤을때 여기까지는 동일해.

			String userId = "[";
			String maxA = "[";

			StatisticVO forChart = maxAmt.get(maxAmt.size() - 1);
			for (StatisticVO one : maxAmt) {
				userId += "'" + one.getUserId() + "'";
				maxA += one.getMaxA();
				if (one != forChart) {
					userId += ",";
					maxA += ",";
				}
			}

			userId += "]";
			maxA += "]";

			req.setAttribute("userId", userId);
			req.setAttribute("maxA", maxA);

		} catch (ClassNotFoundException e) {
			System.out.println("something wrong.");
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/view/user/statistic.jsp").forward(req, resp);
	}

}
