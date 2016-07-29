package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class Nationalityform
 */
@WebServlet("/Nationalityform")
public class Nationalityform extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nationalityform() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		HttpSession session = request.getSession();	
		String applicantid=request.getParameter("applicantid");	
		String applicationid=request.getParameter("applicationid");
		
		String comment=request.getParameter("addcomment");
		
		if(applicationid!=null)
		{
			session.setAttribute("Nationalityapplicationid", applicationid);
			HdzApplication nationalityapplication= dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);
			
			session.setAttribute("NationalityCheck", nationalityapplication);
			
			request.getRequestDispatcher("nationalitycheck.jsp").forward(request, response);
		}
		
		if(applicantid!=null)
		{
			//Validate nationality
			session.setAttribute("hiremessage", null);	
			HdzApplicant myapplicant=dao.PendingActionsDao.getapplicantbyapplicantid(applicantid);
			
			myapplicant.setCitizenflag("Y");
			myapplicant.setVisaflag("Y");
			
			dao.PendingActionsDao.update(myapplicant);	
			HdzApplication myapplication=(HdzApplication)session.getAttribute("NationalityCheck");
			
			if(dao.PendingActionsDao.checkAppStatus(myapplication))
			{
				
				
				dao.PendingActionsDao.update(myapplication);
				
				if(comment!=null)
				{
					
					HdzEmployee user=(HdzEmployee)session.getAttribute("user");
					myapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
					
					dao.PendingActionsDao.update(myapplication);
					
				}
				session.setAttribute("NationalityCheck", myapplication);
				
			}
			
			if(comment!=null)
			{
				
				HdzEmployee user=(HdzEmployee)session.getAttribute("user");
				myapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
				
				dao.PendingActionsDao.update(myapplication);
				
			}
			
			session.setAttribute("NationalityCheck", myapplication);
			
			request.getRequestDispatcher("nationalitycheck.jsp").forward(request, response);
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		String applicantid=request.getParameter("applicantid");	
		String applicationid=session.getAttribute("Nationalityapplicationid").toString();
		
		String comment=request.getParameter("addcomment");
		
		if(applicantid!=null)
		{
			HdzApplicant myapplicant=dao.PendingActionsDao.getapplicantbyapplicantid(applicantid);
			HdzApplication nationalityapplication= dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);
			
			myapplicant.setCitizenflag("N");
			myapplicant.setVisaflag("N");
			dao.PendingActionsDao.update(myapplicant);
			
			nationalityapplication.setAppstatus("Fail");
			
			session.setAttribute("hiremessage", "The Application is Failed!!!!");
			
			dao.PendingActionsDao.update(nationalityapplication);
			
			if(comment!=null)
			{
				
				HdzEmployee user=(HdzEmployee)session.getAttribute("user");
				nationalityapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
				
				dao.PendingActionsDao.update(nationalityapplication);
				
			}
			
			
			session.setAttribute("NationalityCheck", nationalityapplication);
			
			request.getRequestDispatcher("nationalitycheck.jsp").forward(request, response);
			
		}
		
		
		
		
		
	}

}
