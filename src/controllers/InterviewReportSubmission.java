package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PendingActionsDao;
import model.HdzApplication;
import model.HdzEmployee;
import services.InterviewService;
import util.Email;

/**
 * Servlet implementation class InterviewReportSubmission
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HdzEmployee employee = (HdzEmployee)session.getAttribute("user");
		HdzApplication hdzApplication = (HdzApplication) session.getAttribute("app");
		String url = "/PendingAction";
		
		
		if (employee == null) {
			request.setAttribute("message", "Log in!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String comment = (String) request.getParameter("commentInterview");
			String result = request.getParameter("result");
			Double score = Double.parseDouble(request.getParameter("score"));
			String hmInterviewCoding = request.getParameter("hmInterviewCoding");
			String hmInterview = request.getParameter("hmInterview");
			String hrInterview = request.getParameter("hrInterview");
			
			if (comment != null && !comment.equals("")) {
				String x = InterviewService.getComment(hdzApplication);
				if (x != null) {
					comment +=   "<br/>" + x;
				}
				
				hdzApplication.setComments(employee.getEmpname() + " ("+ 
						employee.getPosition()+"): " + comment);
			}
			if (score != null) {
				Double x = InterviewService.getScore(hdzApplication);
				if (x != null) {
					score += x;
				}				
				hdzApplication.setScores(score);
			}
			String role = (String) session.getAttribute("role");
			if (role.equals("HiringManager")) {
				List<HdzQuestions> questions = request.setAttribute("questions", InterviewService.getQuestions(hdzApplication,"HM"));
				for (HdzQuestions h: questions) {
					HdzTest test = new HdzTest();
					test.setResponse(request.getParameter("response" + h.getId()));
					test.setQuestionId(h.getId());
					InterviewService.InsertResponse(test);
				}
				hdzApplication.setCodingtest("G");
				if (result.equals("F")) {
					hdzApplication.setAppstatus("Fail");					
					InterviewService.updateApplication(hdzApplication);
					Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com", "Application status Info", 
							"<html>Hi " + hdzApplication.getHdzApplicant().getFirstname()+ ",<br/> "
									+ "We Regret to Inform you that we are not proceeding further with your Application at this point."
									+ "<br/> Thanks,<br/>HDZ Team</html>", true);
				} else {
					hdzApplication.setAppstatus("HMInterviewDone");		
					InterviewService.updateApplication(hdzApplication);
				}
			} else if (role.equals("HRManager")) {
				List<HdzQuestions> questions = request.setAttribute("questions", InterviewService.getQuestions(hdzApplication,"HM"));
				for (HdzQuestions h: questions) {
					HdzTest test = new HdzTest();
					test.setResponse(request.getParameter("response" + h.getId()));
					test.setQuestionId(h.getId());
					InterviewService.InsertResponse(test);
				}	
				if (result.equals("F")) {
					hdzApplication.setAppstatus("Fail");					
					InterviewService.updateApplication(hdzApplication);
					Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com", "Application status Info", 
							"<html>Hi " + hdzApplication.getHdzApplicant().getFirstname()+ ",<br/> "
									+ "We Regret to Inform you that we are not proceeding further with your Application at this point."
									+ "<br/> Thanks,<br/>HDZ Team</html>", true);
				} else {
					hdzApplication.setAppstatus("HRInterviewDone");		
					InterviewService.updateApplication(hdzApplication);
				}
			} else {
				List<HdzQuestions> questions = request.setAttribute("questions", InterviewService.getQuestions(hdzApplication,"HM"));
				for (HdzQuestions h: questions) {
					HdzTest test = new HdzTest();
					test.setResponse(request.getParameter("response" + h.getId()));
					test.setQuestionId(h.getId());
					InterviewService.InsertResponse(test);
				}	
				if (result.equals("F")) {
					hdzApplication.setAppstatus("Fail");					
					InterviewService.updateApplication(hdzApplication);
					Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com", "Application status Info", 
							"<html>Hi " + hdzApplication.getHdzApplicant().getFirstname()+ ",<br/> "
									+ "We Regret to Inform you that we are not proceeding further with your Application at this point."
									+ "<br/> Thanks,<br/>HDZ Team</html>", true);
				} else {
					hdzApplication.setAppstatus("GroupInterviewDone");	
					if (PendingActionsDao.checkAppStatus(hdzApplication)) {
						hdzApplication.setAppstatus("Hired");			
					}
					InterviewService.updateApplication(hdzApplication);
				}
			} 
			/*
			if (hrInterview != null) {
				if (hrInterview.equals("Pass")) {
					hdzApplication.setAppstatus("HRInterviewDone");					
					InterviewService.updateApplication(hdzApplication);
				} else {
					hdzApplication.setAppstatus("Fail");					
					InterviewService.updateApplication(hdzApplication);
					request.setAttribute("message", "Letter sent to Applicant");
				}
				
				
			}*/
			/*if (hmInterviewCoding != null) {
				hdzApplication.setCodingtest(hmInterviewCoding);
				if (hmInterviewCoding.equals("F")) {
					hdzApplication.setAppstatus("Fail");					
					InterviewService.updateApplication(hdzApplication);
					request.setAttribute("message", "Letter sent to Applicant");
				} else {
					InterviewService.updateApplication(hdzApplication);
				}
				
			} */
			
			/*if (hmInterview != null) {
				if (hmInterview.equals("Pass")) {
					hdzApplication.setAppstatus("HMInterviewDone");					
					InterviewService.updateApplication(hdzApplication);
				} else {
					hdzApplication.setAppstatus("Fail");					
					InterviewService.updateApplication(hdzApplication);
					request.setAttribute("message", "Letter sent to Applicant");
				}
				
			}*/
			/*if (groupInterviewCoding != null) {
				hdzApplication.setCodingtest(groupInterviewCoding);
				if (groupInterviewCoding.equals("F")) {
					hdzApplication.setAppstatus("Fail");					
					InterviewService.updateApplication(hdzApplication);
					request.setAttribute("message", "Letter sent to Applicant");
				} else {
					InterviewService.updateApplication(hdzApplication);
				}
				
			} */
			
			/*if (groupInterview != null) {
				if (groupInterview.equals("Pass")) {
					if (InterviewService.getCodingTest(hdzApplication.getApplicationid()).equals("N")) {
						request.setAttribute("message", "Coding Test has to be completed");
						url = "/InterviewForm";
					} else {
						hdzApplication.setAppstatus("GroupInterviewDone");					
						InterviewService.updateApplication(hdzApplication);
						if (PendingActionsDao.checkAppStatus(hdzApplication)) {
							hdzApplication.setAppstatus("Hired");					
							InterviewService.updateApplication(hdzApplication);
						}
						
					}
					
				} else {
					hdzApplication.setAppstatus("Fail");	
					request.setAttribute("message", "Letter sent to Applicant");
					InterviewService.updateApplication(hdzApplication);
					
				}
				
			}*/
			request.getRequestDispatcher(url).forward(request, response);
			
		}
	}

}
