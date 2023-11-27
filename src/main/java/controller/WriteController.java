package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import dao.CategoryDao;
import dao.SpendLogDao;
import data.Category;
import data.SpendLog;
import data.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/writeComplex")
public class WriteController extends HttpServlet {// 두겟
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date now = new Date(System.currentTimeMillis());
		req.setAttribute("now", now);

		CategoryDao categoryDao = new CategoryDao();
		try {
			List<Category> list = categoryDao.findAll();//로그를 다 가지고 오는 부분입니다.
			req.setAttribute("categories", list);//어쨌든 메서드 덩어리에서 셋을 해줘서 write.jsp로 간다.
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/view/user/write.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {// 두포스트 결국엔 로그에 저장하는 역할을 담당한다.
		Date spendAt = Date.valueOf(req.getParameter("spendAt"));//요걸로 파라미터를 받는거야. 라이트 jsp로부터 알겠지?
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));//요걸로 파라미터를 받는거야. 라이트 jsp로부터 알겠지?
		int amt = Integer.parseInt(req.getParameter("amt"));//요걸로 파라미터를 받는거야. 라이트 jsp로부터 알겠지?
		String useDesc = req.getParameter("useDesc");// 객체만들기.
		

		Users user = (Users) req.getSession().getAttribute("logonUser");//세션을 뽑아서 로그인한 유저만.
		String userId = user.getId();//세션 이걸 유저아이디라는 곳에 넣어준다. 오케이? 이제부터 세션은 유저아이디.

		SpendLog log = new SpendLog(0, userId, amt, spendAt, useDesc, categoryId, null);// 생성자 기준으로. 나열해야한다. 필요없는건 null.

		SpendLogDao spendLogDao = new SpendLogDao();
		try {
			boolean result = spendLogDao.save(log);
			if (result) {
				resp.sendRedirect(req.getServletContext().getContextPath() + "/log");
			} else {
				resp.sendRedirect(req.getServletContext().getContextPath() + "/writeComplex?error=true");

			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect(req.getServletContext().getContextPath() + "/writeComplex?error=true");

		}

	}

}
