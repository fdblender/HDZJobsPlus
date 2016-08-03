package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ApplicantDao;
import model.HdzApplicant;
import model.HdzApplication;
import model.HdzJob;
import util.Email;

/**
 * Servlet implementation class Apply
 * 
 * @author Brian
 */
@WebServlet("/Apply")
public class Apply extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Apply() {
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
		HttpSession session = request.getSession();
		String jobid = request.getParameter("jobid");
		String appid = request.getParameter("applicantid");
		HdzApplicant applicant = null;
		try {
			if (appid != null) {
				applicant = ApplicantDao.getApplicantById(appid);
				HdzJob job = ApplicantDao.getJobById(jobid);
				HdzApplication application = new HdzApplication();
				List<HdzApplication> myapps = applicant.getHdzApplications();
				if (ApplicantDao.checkPreviouslyApplied(applicant, jobid)) {
					request.setAttribute("message", "Already Applied for the Job");
					request.getRequestDispatcher("/PendingAction").forward(request, response);
				} else {
					if (ApplicantDao.checkFlags(applicant)) {
						if ((applicant.getEmployeeflag() != null && applicant.getEmployeeflag().equals("Y"))
								|| ApplicantDao.checkPositive(applicant)) {
							application.setAppstatus("WorkRefChecked");
						} else {
							application.setAppstatus("New");
						}
						application.setCodingtest("N");
						application.setHdzJob(job);
						application.setHdzApplicant(applicant);
						myapps.add(application);
						applicant.setHdzApplications(myapps);
						ApplicantDao.insert(application);
						request.setAttribute("message", "Job Applied");
						Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com", "Application Applied",
								"<html>Hi " + application.getHdzApplicant().getFirstname() + ",<br/><br/> "
										+ "Conratulation!! Your profile has been considered for the position:  "
										+ application.getHdzJob().getHdzPosition().getPosition() + "."
										+ "<br/><br/> Thanks,<br/>HDZ Team</html>",
								true);
					} else {
						request.setAttribute("message", "Background Check Failed");
					}

					request.getRequestDispatcher("/PendingAction").forward(request, response);

				}

			} else {
				applicant = (HdzApplicant) session.getAttribute("user");
				HdzJob job = ApplicantDao.getJobById(jobid);
				HdzApplication application = new HdzApplication();
				List<HdzApplication> myapps = applicant.getHdzApplications();
				if (ApplicantDao.checkPreviouslyApplied(applicant, jobid)) {
					request.setAttribute("message", "Already Applied for the Job");
					request.getRequestDispatcher("/YourApplications").forward(request, response);
				} else {
					if (ApplicantDao.checkFlags(applicant)) {
						if ((applicant.getEmployeeflag() != null && applicant.getEmployeeflag().equals("Y"))
								|| ApplicantDao.checkPositive(applicant)) {
							application.setAppstatus("WorkRefChecked");
						} else {
							application.setAppstatus("New");
						}
						application.setCodingtest("N");
						application.setHdzJob(job);
						application.setHdzApplicant(applicant);
						myapps.add(application);
						applicant.setHdzApplications(myapps);
						ApplicantDao.insert(application);
						request.setAttribute("message", "Job Applied");
					} else {
						request.setAttribute("message", "Background Check Failed");
					}
					session.setAttribute("user", applicant);

					request.getRequestDispatcher("/YourApplications").forward(request, response);
				}
			}

		} catch (Exception e) {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
