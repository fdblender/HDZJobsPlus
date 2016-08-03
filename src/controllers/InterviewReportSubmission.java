package controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.HdzApplication;
import model.HdzEmployee;
import model.HdzJobquestion;
import model.HdzTest;
import services.InterviewService;
import util.Email;

/**
 * Servlet implementation class InterviewReportSubmission
 * 
 * @author Navreet
 */
@WebServlet("/InterviewReportSubmission")
public class InterviewReportSubmission extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InterviewReportSubmission() {
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
		HdzApplication hdzApplication = InterviewService
				.getHdzApplication((String) request.getParameter("applicationInt"));
		String url = "/PendingAction";
		System.out.println(hdzApplication.getApplicationid());
		try {

			if (employee == null) {
				request.setAttribute("message", "Log in!!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				String comment = (String) request.getParameter("commentInterview");
				String result = request.getParameter("result");
				System.out.println((String) request.getParameter("score"));
				BigDecimal score = new BigDecimal((String) request.getParameter("score"));

				if (comment != null && !comment.equals("")) {
					String x = InterviewService.getComment(hdzApplication);
					if (x != null) {
						comment += "<br/>" + x;
					}

					hdzApplication.setComments(employee.getEmpname() + " (" + employee.getPosition() + "): " + comment);
				}
				if (score != null) {
					BigDecimal x = InterviewService.getScore(hdzApplication);
					if (x != null) {
						score = score.add(x);
					}
					hdzApplication.setScore(score);
				}
				String role = (String) session.getAttribute("role");
				if (role.equals("HiringManager")) {
					List<HdzJobquestion> questions = InterviewService.getQuestions(hdzApplication, "HM");
					for (HdzJobquestion h : questions) {
						HdzTest test = new HdzTest();
						test.setHdzApplication(hdzApplication);
						test.setTestresponse(request.getParameter("response" + h.getJobquestionsid()));
						test.setHdzJobquestion(h);
						InterviewService.InsertResponse(test);
					}
					if (InterviewService.checkPosition(hdzApplication)) {
						hdzApplication.setCodingtest("G");
						Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com",
								"Coding Test Challenge",
								"<html>Hi " + hdzApplication.getHdzApplicant().getFirstname() + ",<br/><br/> "
										+ "You are assigned a coding challenge. Pleae take it."
										+ "<br/><br/> Thanks,<br/>HDZ Team</html>",
								true);
					}

					if (result.equals("F")) {
						hdzApplication.setAppstatus("Fail");
						InterviewService.updateApplication(hdzApplication);
						Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com",
								"Application status Info",
								"<html>Hi " + hdzApplication.getHdzApplicant().getFirstname() + ",<br/> "
										+ "We Regret to Inform you that we are not proceeding further with your Application at this point."
										+ "<br/> Thanks,<br/>HDZ Team</html>",
								true);
					} else {
						hdzApplication.setAppstatus("HMInterviewDone");
						InterviewService.updateApplication(hdzApplication);
						Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com",
								"Application status Info",
								"<html>Hi Hiring Manager,<br/> " + "The Applicant "
										+ hdzApplication.getHdzApplicant().getFirstname()
										+ " cleared Hiring Manager round and moved to the Group Interview round."
										+ "<br/> Thanks,<br/>HDZ Team</html>",
								true);
					}
				} else if (role.equals("HRManager")) {
					List<HdzJobquestion> questions = InterviewService.getQuestions(hdzApplication, "HR");
					for (HdzJobquestion h : questions) {
						System.out.println(h.getJobquestionsid());
						HdzTest test = new HdzTest();
						test.setHdzApplication(hdzApplication);
						test.setTestresponse(request.getParameter("response" + h.getJobquestionsid()));
						test.setHdzJobquestion(h);
						InterviewService.InsertResponse(test);
					}
					if (result.equals("F")) {
						hdzApplication.setAppstatus("Fail");
						InterviewService.updateApplication(hdzApplication);
						Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com",
								"Application status Info",
								"<html>Hi " + hdzApplication.getHdzApplicant().getFirstname() + ",<br/> "
										+ "We Regret to Inform you that we are not proceeding further with your Application at this point."
										+ "<br/> Thanks,<br/>HDZ Team</html>",
								true);
					} else {
						hdzApplication.setAppstatus("HRInterviewDone");
						InterviewService.updateApplication(hdzApplication);
						Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com",
								"Application status Info",
								"<html>Hi Hiring Manager,<br/> " + "The Applicant "
										+ hdzApplication.getHdzApplicant().getFirstname()
										+ " cleared HR round and moved to the Hiring manager Interview round."
										+ "<br/> Thanks,<br/>HDZ Team</html>",
								true);
					}
				} else {
					List<HdzJobquestion> questions = InterviewService.getQuestions(hdzApplication, "GI");
					for (HdzJobquestion h : questions) {
						HdzTest test = new HdzTest();
						test.setTestresponse(request.getParameter("response" + h.getJobquestionsid()));
						test.setHdzJobquestion(h);
						test.setHdzApplication(hdzApplication);
						InterviewService.InsertResponse(test);
					}
					if (result.equals("F")) {
						hdzApplication.setAppstatus("Fail");
						InterviewService.updateApplication(hdzApplication);
						Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com",
								"Application status Info",
								"<html>Hi " + hdzApplication.getHdzApplicant().getFirstname() + ",<br/> "
										+ "We Regret to Inform you that we are not proceeding further with your Application at this point."
										+ "<br/> Thanks,<br/>HDZ Team</html>",
								true);
					} else {
						hdzApplication.setAppstatus("GroupInterviewDone");

						InterviewService.updateApplication(hdzApplication);
						Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com",
								"Application status Info",
								"<html>Hi Hiring Manager,<br/> " + "The Applicant "
										+ hdzApplication.getHdzApplicant().getFirstname()
										+ " cleared the Group Interview." + "<br/> Thanks,<br/>HDZ Team</html>",
								true);
					}
				}

				request.getRequestDispatcher(url).forward(request, response);

			}
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
