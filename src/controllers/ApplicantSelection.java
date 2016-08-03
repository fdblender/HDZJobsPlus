package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HdzApplication;
import model.HdzEmployee;
import services.RoleActionService;

/**
 * Servlet implementation class ApplicantSelection
 * @author Navreet
 */
@WebServlet("/ApplicantSelection")
public class ApplicantSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplicantSelection() {
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
			HdzEmployee employee = (HdzEmployee) session.getAttribute("user");
			if (employee == null) {
				request.setAttribute("message", "Log in!!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				String jobId = request.getParameter("jobid");
				List<HdzApplication> hdzapplications = RoleActionService.getActiveApplications(jobId);
				if (hdzapplications == null) {
					request.setAttribute("message", "No application reached final stage for this job.");
					request.getRequestDispatcher("/PendingAction").forward(request, response);
				} else {
					request.setAttribute("applicationList", hdzapplications);
					request.setAttribute("job", hdzapplications.get(0).getHdzJob());
					request.getRequestDispatcher("selectApplicant.jsp").forward(request, response);
				}

			}
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
