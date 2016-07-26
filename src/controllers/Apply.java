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

/**
 * Servlet implementation class Apply
 */
@WebServlet("/Apply")
public class Apply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Apply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String jobid = request.getParameter("jobid");
		
		HdzApplicant applicant = (HdzApplicant)session.getAttribute("user");
		HdzJob job = ApplicantDao.getJobById(jobid);
		HdzApplication application = new HdzApplication();
		List<HdzApplication> myapps = applicant.getHdzApplications();
		
		application.setAppstatus("New");
		application.setCodingtest("N");
		application.setHdzJob(job);
		application.setHdzApplicant(applicant);
		myapps.add(application);
		applicant.setHdzApplications(myapps);
		session.setAttribute("user", applicant);
		
		request.getRequestDispatcher("/yourapplications.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
