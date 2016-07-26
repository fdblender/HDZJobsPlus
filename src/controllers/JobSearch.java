package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApplicantDao;
import model.HdzJob;

@WebServlet("/JobSearch")
public class JobSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JobSearch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		
		List<HdzJob> jobs;
		if(search!=null){
			jobs = ApplicantDao.searchJobs(search);
		}
		else{
			jobs = ApplicantDao.getAllJobs();
		}
		request.setAttribute("jobs", jobs);
		
		request.getRequestDispatcher("/jobs.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
