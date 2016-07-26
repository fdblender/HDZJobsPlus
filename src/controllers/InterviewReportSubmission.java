package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			if (hmInterviewCoding != null) {
				hdzApplication.setCodingtest(hmInterviewCoding);
				InterviewService.updateCodingTest(hdzApplication);
			} else if (hmInterview != null) {
				
			}
			
			request.getRequestDispatcher("interview.jsp").forward(request, response);
		}
	}

}
