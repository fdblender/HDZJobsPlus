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
import model.HdzEmployee;
import model.HdzJob;
import services.InterviewService;
import services.RoleActionService;

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
			} else {
				String skill = request.getParameter("skill");
				String experience = request.getParameter("experience");
				List<HdzApplicant> applicants =  InterviewService.getSearchedApplicants(skill,experience);
				request.setAttribute("applicantList", applicants);
			}			
			request.getRequestDispatcher("applicantsHM.jsp").forward(request, response);
		}
	}

}
