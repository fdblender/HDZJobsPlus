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
import model.HdzEmployee;
import model.HdzJob;
import services.InterviewService;

/**
 * Servlet implementation class FindApplicants
 */
@WebServlet("/FindApplicants")
public class FindApplicants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindApplicants() {
        super();
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
		if (employee == null) {
			request.setAttribute("message", "Log in!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String jobId = request.getParameter("jobid");
			if (jobId != null) {
				List<HdzApplicant> applicants =  InterviewService.getSkilledApplicants(jobId);
				request.setAttribute("applicantList", applicants);
				HdzJob job = ApplicantDao.getJobById(jobId);
				request.setAttribute("job", job);
				if (applicants == null || applicants.size() == 0) {
					request.setAttribute("message", "No Records!!");
					request.getRequestDispatcher("/PendingAction").forward(request, response);
				} else {
					request.getRequestDispatcher("applicantsHM.jsp").forward(request, response);
				}
			} else {
				String skill = request.getParameter("skill");
				String experience = request.getParameter("experience");
				if (skill == null || experience == null) {
					request.setAttribute("message", "Both Skill and experience are required for search!!");
					request.getRequestDispatcher("/PendingAction").forward(request, response);
				} else {
					request.setAttribute("job", null);
					List<HdzApplicant> applicants =  InterviewService.getSearchedApplicants(skill,experience);
					request.setAttribute("applicantList", applicants);					
					if (applicants == null || applicants.size() == 0) {
						request.setAttribute("message", "No Records!!");
						request.getRequestDispatcher("/PendingAction").forward(request, response);
					} else {
						request.getRequestDispatcher("applicantsHM.jsp").forward(request, response);
					}
				}
				
			}			
			
		}
	}

}
