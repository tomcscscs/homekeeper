package controller;

import java.io.IOException;

import dao.SpendLogDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] no = req.getParameterValues("no");// 한두개가 넘어오는게 아니기때문에. 배열로 받음.

		SpendLogDao spendLogDao = new SpendLogDao();

		for (String n : no) {
			int k = Integer.parseInt(n);
			try {
				spendLogDao.deleteByNo(k);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		req.getRequestDispatcher("/log");

	}

}
