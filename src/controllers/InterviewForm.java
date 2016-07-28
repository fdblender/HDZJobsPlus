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
 * Servlet implementation class InterviewForm
 */
@WebServlet("/InterviewForm")
public class InterviewForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterviewForm() {
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
		HdzApplication hdzApplication = (HdzApplication) request.getAttribute("app");
		hdzApplication.setCodingtest(InterviewService.getCodingTest(hdzApplication.getApplicationid()));
		request.setAttribute("app", hdzApplication);
		if (employee == null) {
			request.setAttribute("message", "Log in!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String role = (String) session.getAttribute("role");
			if (role.equals("HiringManager")) {
				request.setAttribute("questions", InterviewService.getQuestions(hdzApplication,"HM"));
				request.setAttribute("interviewType", "HM Interview");
				request.setAttribute("coding", InterviewService.getCodingTest(hdzApplication.getApplicationid()));
			} else if (role.equals("HRManager")) {
				request.setAttribute("questions", InterviewService.getQuestions(hdzApplication,"HR"));
				request.setAttribute("interviewType", "HR Interview");				
			} else {
				request.setAttribute("questions", InterviewService.getQuestions(hdzApplication,"GI"));
				request.setAttribute("interviewType", "Group Interview");
				request.setAttribute("coding", InterviewService.getCodingTest(hdzApplication.getApplicationid()));
				
			} 
			request.getRequestDispatcher("interview.jsp").forward(request, response);
		}
	}

}
