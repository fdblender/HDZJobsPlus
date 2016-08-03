package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApplicantDao;
import model.HdzJob;

/**
 * Servlet implementation class Jobs
 * 
 * @author Josh
 */
@WebServlet("/Jobs")
public class Jobs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Jobs() {
		super();
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
			List<HdzJob> jobs = ApplicantDao.getAllJobs();

			request.setAttribute("jobs", jobs);

			request.getRequestDispatcher("/jobs.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
