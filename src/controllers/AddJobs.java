package controllers;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddjobsDao;

import model.HdzJob;
import model.HdzPosition;

/**
 * Servlet implementation class AddJobs
 */
@WebServlet("/AddJobs")
public class AddJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddJobs() {
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
			String posit = request.getParameter("position");
			String desc = request.getParameter("description");
			String type = request.getParameter("type");
			String noOfOpenings = request.getParameter("noOfOpenings");
			String exp = request.getParameter("exp");
			HdzPosition position = AddjobsDao.checkPosition(posit);
			if (position == null) {
				position = new HdzPosition();
				position.setPosition(posit);
				position.setPositiontype(type);
				AddjobsDao.insertPosition(position);
			}
			 
			HdzJob jobs = new HdzJob();
			jobs.setHdzPosition(position);
			jobs.setDescription(desc);
			jobs.setNumberopenings(new BigDecimal(noOfOpenings));
			jobs.setOverallexperience(new BigDecimal(exp));
			AddjobsDao.addjobs(jobs);
			request.setAttribute("message", "Updated Successfully");

			request.getRequestDispatcher("/PendingAction").forward(request, response);

		} catch (NullPointerException e) {
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);

		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);

		}
	}

}
