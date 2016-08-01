package controllers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import util.Email;

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
		String comment=request.getParameter("addcomment");
		
		
		if(applicationid!=null)
		{
			session.setAttribute("EduApplicationid", applicationid);
			
			HdzApplication application=dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);
			
			List<HdzEducation> educations=dao.PendingActionsDao.getEducationbyapplicantid(application.getHdzApplicant().getApplicantid());
			
			session.setAttribute("EducationCheck", educations);
			
			session.setAttribute("ApplicationComment", application);
			
			request.getRequestDispatcher("educationcheck.jsp").forward(request, response);
		}
		
		if(eduid!=null)
		{
			session.setAttribute("hiremessage", null);	
			HdzEducation myeducation=dao.PendingActionsDao.getEdubyEduid(eduid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("EduApplicationid").toString());
			
			myeducation.setEducationflag("Y");
			
			
			dao.PendingActionsDao.update(myeducation);

			if(dao.PendingActionsDao.checkAppStatus(myapplication))
			{
				
				
				dao.PendingActionsDao.update(myapplication);
				myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(myapplication.getApplicationid()+ "");
				
				session.setAttribute("ApplicationComment", myapplication);
				
				if(comment!=null)
				{
					
					HdzEmployee user=(HdzEmployee)session.getAttribute("user");
					myapplication.setComments(user.getEmpname()+" ("+user.getPosition()+"): "+comment);	
					
					dao.PendingActionsDao.update(myapplication);
					myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(myapplication.getApplicationid()+ "");
					session.setAttribute("ApplicationComment", myapplication);
					
				}
				
			}
			
			if(comment!=null)
			{
				
				HdzEmployee user=(HdzEmployee)session.getAttribute("user");
				myapplication.setComments(user.getEmpname()+" ("+user.getPosition()+"):"+comment);	
				
				dao.PendingActionsDao.update(myapplication);
				myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(myapplication.getApplicationid()+ "");
				session.setAttribute("ApplicationComment", myapplication);
				
			}
			
			List<HdzEducation> educations=dao.PendingActionsDao.getEducationbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(myapplication.getApplicationid()+ "");
			session.setAttribute("EducationCheck", educations);
			session.setAttribute("ApplicationComment", myapplication);
			
			request.getRequestDispatcher("educationcheck.jsp").forward(request, response);
			
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession();	
		String eduid=request.getParameter("eduid");
		String comment=request.getParameter("addcomment");
		if(eduid!=null)
		{
			
			HdzEducation myeducation=dao.PendingActionsDao.getEdubyEduid(eduid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("EduApplicationid").toString());
			
			myeducation.setEducationflag("N");
			
			dao.PendingActionsDao.update(myeducation);
			
			myapplication.setAppstatus("Fail");
			
			session.setAttribute("hiremessage", "The Applicant Failed!!!!");
			
			dao.PendingActionsDao.update(myapplication);
			
			session.setAttribute("ApplicationComment", myapplication);
			
			try {
				Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com",
						"Application status Info",
						"<html>Hi " + myapplication.getHdzApplicant().getFirstname() + ",<br/> "
								+ "We Regret to Inform you that we are not proceeding further with your Application at this point."
								+ "<br/> Thanks,<br/>HDZ Team</html>",
						true);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(comment!=null)
			{
				
				HdzEmployee user=(HdzEmployee)session.getAttribute("user");
				myapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
				
				dao.PendingActionsDao.update(myapplication);
				
				session.setAttribute("ApplicationComment", myapplication);
				
			}
			
			List<HdzEducation> educations=dao.PendingActionsDao.getEducationbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			
			session.setAttribute("EducationCheck", educations);
			
			session.setAttribute("ApplicationComment", myapplication);
			
			request.getRequestDispatcher("/PendingAction").forward(request, response);
			
		}
		
	}

}
