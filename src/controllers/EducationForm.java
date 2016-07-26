package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class EducationForm
 */
@WebServlet("/EducationForm")
public class EducationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EducationForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();	
		String eduid=request.getParameter("eduid");	
		String applicationid=request.getParameter("applicationid");
		
		if(applicationid!=null)
		{
			session.setAttribute("EduApplicationid", applicationid);
			
			HdzApplication application=dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);
			
			List<HdzEducation> educations=dao.PendingActionsDao.getEducationbyapplicantid(application.getHdzApplicant().getApplicantid());
			
			session.setAttribute("EducationCheck", educations);
			
			
			
			request.getRequestDispatcher("educationcheck.jsp").forward(request, response);
		}
		
		if(eduid!=null)
		{
			HdzEducation myeducation=dao.PendingActionsDao.getEdubyEduid(eduid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("EduApplicationid").toString());
			
			myeducation.setEducationflag("Y");
			

			if(dao.PendingActionsDao.checkAppStatus(myapplication))
			{
				myapplication.setAppstatus("Hired");
				
				dao.PendingActionsDao.update(myapplication);
			}
			
			List<HdzEducation> educations=dao.PendingActionsDao.getEducationbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			
			session.setAttribute("EducationCheck", educations);
			
			request.getRequestDispatcher("educationcheck.jsp").forward(request, response);
			
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession();	
		String eduid=request.getParameter("eduid");	
		if(eduid!=null)
		{
			HdzEducation myeducation=dao.PendingActionsDao.getEdubyEduid(eduid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("EduApplicationid").toString());
			
			myeducation.setEducationflag("N");
			
			myapplication.setAppstatus("Fail");
			
			dao.PendingActionsDao.update(myapplication);
			
			List<HdzEducation> educations=dao.PendingActionsDao.getEducationbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			
			session.setAttribute("EducationCheck", educations);
			
			request.getRequestDispatcher("educationcheck.jsp").forward(request, response);
			
		}
		
	}

}
