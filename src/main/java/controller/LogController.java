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
		SpendLogDao spendLogDao = new SpendLogDao();
		
		
		Users user =(Users)req.getSession().getAttribute("logonUser");
		String userId=user.getId();// 세션의 유저를 여기서. getid를 뽑으려.
		try {
		List<SpendLog> list=spendLogDao.findUserId(userId);//스펜드로그다오 파인드유저아이디 뽑으려.
		req.setAttribute("logs", list);// logs는 여기에.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/view/user/log.jsp").forward(req, resp);
		
		
		
		
	}
	
	
	
}
		
		
