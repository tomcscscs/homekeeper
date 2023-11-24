package dummy;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import dao.SpendLogDao;
import data.SpendLog;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dummy")

public class DummyController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String[] desc = new String[] {};
		SpendLogDao dummyDao = new SpendLogDao();
		Random r = new Random();
		try {
			for (int cnt = 1; cnt <= 30; cnt++) {
				SpendLog log = new SpendLog();
				log.setUserId("김찬수");// 마스터라는 이름의 자료들 대량생산.
				log.setAmt(r.nextInt(1, 200) * 500);
				log.setCategoryId(r.nextInt(1, 14));
				int month = r.nextInt(1, 12);
				int day = r.nextInt(1, 30);
				String dateStr = "2023-" + String.format("%02d", month) + "-" + String.format("%02d", day);

				log.setSpendAt(Date.valueOf(dateStr));
				log.setUseDesc("테스트");

				dummyDao.save(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
