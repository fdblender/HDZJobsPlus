package controllers;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.HdzApplication;
import model.HdzEmployee;
import model.HdzJob;
import services.InterviewService;
import services.RoleActionService;
import util.Email;

/**
 * Servlet implementation class ApplicantSelection
 */
@WebServlet("/ApplicantsHired")
public class ApplicantsHired extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplicantsHired() {
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
		HttpSession session = request.getSession();
		HdzEmployee employee = (HdzEmployee) session.getAttribute("user");
		try {
			if (employee == null) {
				request.setAttribute("message", "Log in!!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				String[] appIds = request.getParameterValues("appCheck");
				String jobId = request.getParameter("jobid");
				HdzJob job = RoleActionService.getJob(jobId);
				if (job.getNumberopenings().compareTo(new BigDecimal(appIds.length)) < 0) {
					request.setAttribute("message", "Not enough Openings for the position");
					request.getRequestDispatcher("/ApplicantSelect").forward(request, response);
				} else {
					for (String appId : appIds) {
						HdzApplication application = InterviewService.getHdzApplication(appId.substring(6));
						application.setAppstatus("Hired");
						InterviewService.updateApplication(application);
						HdzJob jobUpdate = application.getHdzJob();
						BigDecimal noOpenings = jobUpdate.getNumberopenings();
						jobUpdate.setNumberopenings(noOpenings.subtract(BigDecimal.ONE));
						InterviewService.updateJob(jobUpdate);
						Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com",
								"Application status Info",
								"<html>Hi " + application.getHdzApplicant().getFirstname() + ",<br/><br/> "
										+ "Conratulation!! You have been hired for the position:  "
										+ application.getHdzJob().getHdzPosition().getPosition() + "."
										+ "<br/><br/> Thanks,<br/>HDZ Team</html>",
								true);

					}
					request.getRequestDispatcher("/PendingAction").forward(request, response);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/PendingAction").forward(request, response);
		}
	}

}
