package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionsDao;
import model.*;

/**
 * Servlet implementation class ApplicationDetail
 * 
 * @author Xiao
 */
@WebServlet("/ApplicationDetail")
public class ApplicationDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplicationDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String applicationid = request.getParameter("applicationid");
			String role = (String) session.getAttribute("role");
			String gi = (String) session.getAttribute("GI");
			List<HdzTest> questionlist = null;
			if (role.equals("HRManager")) {
				questionlist = QuestionsDao.getQuestionList("HR", applicationid);

			} else if (role.equals("HiringManager")) {
				questionlist = QuestionsDao.getQuestionList("HM", applicationid);

			} else if (gi.equals("Yes")) {
				questionlist = QuestionsDao.getQuestionList("GI", applicationid);
			}

			HdzApplication myapplication = dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);

			session.setAttribute("myapplicaitondetail", myapplication);
			session.setAttribute("questionlist", questionlist);

			request.getRequestDispatcher("applicationdetail.jsp").forward(request, response);

		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
