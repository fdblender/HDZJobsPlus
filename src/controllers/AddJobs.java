package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddjobsDao;

import model.HdzJob;

/**
 * Servlet implementation class AddJobs
 */
@WebServlet("/AddJobs")
public class AddJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJobs() {
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
		try{
			String id = request.getParameter("jobsid");
			String posit = request.getParameter("position");
			String desc = request.getParameter("description");
			HdzJob jobs = new HdzJob();
			jobs.setJobsid(Long.parseLong(id));
			jobs.setPosition(posit);
			jobs.setDescription(desc);
			AddjobsDao.addjobs(jobs);
			request.setAttribute("message", "Updated Successfully");
		
			request.getRequestDispatcher("addjobs.jsp").forward(request, response);
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	}


