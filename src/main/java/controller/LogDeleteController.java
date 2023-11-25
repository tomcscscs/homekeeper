package controller;

import java.io.IOException;

import dao.SpendLogDao;
import data.SpendLog;
import data.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class LogDeleteController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] nos = req.getParameterValues("no");// 한두개가 넘어오는게 아니기때문에. 배열로 받음.(일단 이건 반드시 받아줘야하는거)
		Users user = (Users) req.getSession().getAttribute("logonUser");//세션을 이용해서, 유저데이터를 이용하려는거겠지?
		SpendLogDao spendLogDao = new SpendLogDao();//딜리트 파인드 메서드를 사용하기 위해. 

		if (nos != null) {
			for (String no : nos) {
				int n = Integer.parseInt(no);// no가 n 이야. 인트로 바꾼 이유가 있었네. no가지고 삭제하는법.
				try {
					SpendLog log = spendLogDao.findByNo(n);// log는 여기서 스펜드로그 양식으로 받았음.
					if (user.getId().equals(log.getUserId())) {//세션을 가지고 온 이유. 유저 아이디를 가져오기 위해.
						spendLogDao.deleteByNo(n);//이게 핵심이지.

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		resp.sendRedirect(req.getServletContext().getContextPath() + "/log");

	}

}
