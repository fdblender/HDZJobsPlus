package controllers;

import java.io.IOException;
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
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HdzEmployee employee = (HdzEmployee)session.getAttribute("employee");
		HdzApplication hdzApplication = (HdzApplication) session.getAttribute("app");
		if (employee == null) {
			request.setAttribute("message", "Log in!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String groupInterviewCoding = request.getParameter("groupInterviewCoding");
			String groupInterview = request.getParameter("groupInterviewCoding");
			String hmInterviewCoding = request.getParameter("groupInterviewCoding");
			String hmInterview = request.getParameter("groupInterviewCoding");
			String hrInterview = request.getParameter("hrInterview");
			System.out.println(hrInterview);
			if (hrInterview != null) {
				if (hmInterview.equals("Pass")) {
					hdzApplication.setAppstatus("HRInterviewDone");					
					InterviewService.updateApplication(hdzApplication);
				} else {
					hdzApplication.setAppstatus("Fail");					
					InterviewService.updateApplication(hdzApplication);
				}
				
			}
			if (hmInterviewCoding != null) {
				hdzApplication.setCodingtest(hmInterviewCoding);
				InterviewService.updateApplication(hdzApplication);
			} 
			
			if (hmInterview != null) {
				if (hmInterview.equals("Pass")) {
					hdzApplication.setAppstatus("HMInterviewDone");					
					InterviewService.updateApplication(hdzApplication);
				} else {
					hdzApplication.setAppstatus("Fail");					
					InterviewService.updateApplication(hdzApplication);
				}
				
			}
			if (groupInterviewCoding != null) {
				hdzApplication.setCodingtest(hmInterviewCoding);
				InterviewService.updateApplication(hdzApplication);
			} 
			
			if (groupInterview != null) {
				if (hmInterview.equals("Pass")) {
					hdzApplication.setAppstatus("GroupInterviewDone");					
					InterviewService.updateApplication(hdzApplication);
					if (PendingActionsDao.checkAppStatus(hdzApplication)) {
						hdzApplication.setAppstatus("Hired");					
						InterviewService.updateApplication(hdzApplication);
					}
				} else {
					hdzApplication.setAppstatus("Fail");					
					InterviewService.updateApplication(hdzApplication);
				}
				
			}
			
			request.getRequestDispatcher("interview.jsp").forward(request, response);
		}
	}

}
