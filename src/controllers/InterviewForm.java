package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HdzEmployee;
import services.InterviewService;
import services.RoleActionService;

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
		String appid = (String) session.getAttribute("appid");
		if (employee == null) {
			request.setAttribute("message", "Log in!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String role = (String) session.getAttribute("role");
			if (role.equals("Employee")) {
				request.setAttribute("interviewType", "Group Interview");
				request.setAttribute("coding", InterviewService.getCodingTest(appid));
			} else if (role.equals("Hiring Manager")) {
				request.setAttribute("interviewType", "HM Interview");				
			} else if (role.equals("HR Manager")) {
				request.setAttribute("interviewType", "HR Interview");				
			}
			request.getRequestDispatcher("interview.jsp").forward(request, response);
		}
	}

}
