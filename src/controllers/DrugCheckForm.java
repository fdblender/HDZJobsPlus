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
 * Servlet implementation class DrugCheckForm
 */
@WebServlet("/DrugCheckForm")
public class DrugCheckForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrugCheckForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		String stdid=request.getParameter("stdid");	
		
		String dotid=request.getParameter("dotid");	
		
		String alcoholid=request.getParameter("alcoholid");	
		String applicationid=request.getParameter("applicationid");
		
		String comment=request.getParameter("addcomment");
		
		if(applicationid!=null)
		{
			session.setAttribute("DrugApplicationid", applicationid);
			
			HdzApplication application=dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);
			
			session.setAttribute("DrugApplication",application);	
			
			request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);
		}
		
		if(stdid!=null)
		{
			session.setAttribute("hiremessage", null);	
			HdzApplicant applicant=dao.PendingActionsDao.getapplicantbyapplicantid(stdid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("DrugApplicationid").toString());
			
			applicant.setStdpanelflag("Y");
			
			dao.PendingActionsDao.update(applicant);
			
			session.setAttribute("DrugApplicant",applicant);
			
			if(applicant.getAlcoholtestflag()!=null&&applicant.getStdpanelflag()!=null&&applicant.getDottestflag()!=null)
			{
			if(applicant.getAlcoholtestflag().equals("Y")&&applicant.getStdpanelflag().equals("Y")&&applicant.getDottestflag().equals("Y"))
			{
				applicant.setDrugtestflag("Y");
				dao.PendingActionsDao.update(applicant);
			
				session.setAttribute("DrugApplicant",applicant);
				
				session.setAttribute("hiremessage", "The drug test is passed!!!!");			
			}
			}
			if(dao.PendingActionsDao.checkAppStatus(myapplication))
			{
				myapplication.setAppstatus("Hired");
				
				if(comment!=null)
				{
					
					HdzEmployee user=(HdzEmployee)session.getAttribute("user");
					myapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
					
				}
				
				session.setAttribute("hiremessage", "The Applicant is hired!!!!");
				
				dao.PendingActionsDao.update(myapplication);
				session.setAttribute("DrugApplication",myapplication);	
			}
			
			if(comment!=null)
			{
				
				HdzEmployee user=(HdzEmployee)session.getAttribute("user");
				myapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
				
				dao.PendingActionsDao.update(myapplication);
				
			}
				
			session.setAttribute("DrugApplication",myapplication);	
			
			request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);
			
		}
		
		if(dotid!=null)
		{
			session.setAttribute("hiremessage", null);	
			HdzApplicant applicant=dao.PendingActionsDao.getapplicantbyapplicantid(dotid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("DrugApplicationid").toString());
			
			applicant.setDottestflag("Y");
			
			
			dao.PendingActionsDao.update(applicant);
			session.setAttribute("DrugApplicant",applicant);
			
			if(applicant.getAlcoholtestflag()!=null&&applicant.getStdpanelflag()!=null&&applicant.getDottestflag()!=null)
			{
			if(applicant.getAlcoholtestflag().equals("Y")&&applicant.getStdpanelflag().equals("Y")&&applicant.getDottestflag().equals("Y"))
			{
				applicant.setDrugtestflag("Y");
				dao.PendingActionsDao.update(applicant);
				
				session.setAttribute("DrugApplicant",applicant);
				session.setAttribute("hiremessage", "The drug test is passed!!!!");
				
				
			}
			}

			if(dao.PendingActionsDao.checkAppStatus(myapplication))
			{
				myapplication.setAppstatus("Hired");
				
				if(comment!=null)
				{
					
					HdzEmployee user=(HdzEmployee)session.getAttribute("user");
					myapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
					
				}
				
				session.setAttribute("hiremessage", "The Applicant is hired!!!!");
				
				dao.PendingActionsDao.update(myapplication);
				session.setAttribute("DrugApplication",myapplication);	
				
			}
			if(comment!=null)
			{
				
				HdzEmployee user=(HdzEmployee)session.getAttribute("user");
				myapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
				
				dao.PendingActionsDao.update(myapplication);
				
			}
			
			session.setAttribute("DrugApplication",myapplication);	
			
			request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);
			
		}
		if(alcoholid!=null)
		{
			session.setAttribute("hiremessage", null);	
			HdzApplicant applicant=dao.PendingActionsDao.getapplicantbyapplicantid(alcoholid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("DrugApplicationid").toString());
			
			applicant.setAlcoholtestflag("Y");
					
			dao.PendingActionsDao.update(applicant);
			
			session.setAttribute("DrugApplicant",applicant);
			
			if(applicant.getAlcoholtestflag()!=null&&applicant.getStdpanelflag()!=null&&applicant.getDottestflag()!=null)
			{
				if(applicant.getAlcoholtestflag().equals("Y")&&applicant.getStdpanelflag().equals("Y")&&applicant.getDottestflag().equals("Y"))
			{
				applicant.setDrugtestflag("Y");
				dao.PendingActionsDao.update(applicant);
				
				
				session.setAttribute("DrugApplicant",applicant);
				session.setAttribute("hiremessage", "The drug test is passed!!!!");
				
				
			}
			}
			if(dao.PendingActionsDao.checkAppStatus(myapplication))
			{
				myapplication.setAppstatus("Hired");
				
				if(comment!=null)
				{
					
					HdzEmployee user=(HdzEmployee)session.getAttribute("user");
					myapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
					
				}
				
				session.setAttribute("hiremessage", "The Applicant is hired!!!!");
				
				dao.PendingActionsDao.update(myapplication);
				session.setAttribute("DrugApplication",myapplication);	
				
			}
			if(comment!=null)
			{
				
				HdzEmployee user=(HdzEmployee)session.getAttribute("user");
				myapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
				
				dao.PendingActionsDao.update(myapplication);
				
			}
			
			session.setAttribute("DrugApplication",myapplication);	
			
			request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		String stdid=request.getParameter("stdid");	
		
		String dotid=request.getParameter("dotid");	
		
		String alcoholid=request.getParameter("alcoholid");	
		String applicationid=session.getAttribute("DrugApplicationid").toString();
		
		String comment=request.getParameter("addcomment");
		
		if(stdid!=null)
		{
			HdzApplicant myapplicant=dao.PendingActionsDao.getapplicantbyapplicantid(stdid);
			HdzApplication myapplication= dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);
			
			
			myapplicant.setStdpanelflag("N");
			myapplicant.setDrugtestflag("N");
			
			dao.PendingActionsDao.update(myapplicant);
			
			session.setAttribute("DrugApplicant",myapplicant);
			
			myapplication.setAppstatus("Fail");
			dao.PendingActionsDao.update(myapplication);
			
			session.setAttribute("hiremessage", "The Application is Failed!!!!");
			
			if(comment!=null)
			{
				
				HdzEmployee user=(HdzEmployee)session.getAttribute("user");
				myapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
				
				dao.PendingActionsDao.update(myapplication);
				
			}
			
			session.setAttribute("DrugApplication",myapplication);	
			
			
			
			request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);
			
		}
		
		if(dotid!=null)
		{
			HdzApplicant myapplicant=dao.PendingActionsDao.getapplicantbyapplicantid(dotid);
			HdzApplication myapplication= dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);
			
			
			myapplicant.setDottestflag("N");
			myapplicant.setDrugtestflag("N");
			
			dao.PendingActionsDao.update(myapplicant);
			
			session.setAttribute("DrugApplicant",myapplicant);
			myapplication.setAppstatus("Fail");
			
			dao.PendingActionsDao.update(myapplication);
			
			session.setAttribute("hiremessage", "The Application is Failed!!!!");
			
			if(comment!=null)
			{
				
				HdzEmployee user=(HdzEmployee)session.getAttribute("user");
				myapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
				
				dao.PendingActionsDao.update(myapplication);
				
			}
			
			session.setAttribute("DrugApplication",myapplication);	
			
			
			
			request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);
			
		}
		
		if(alcoholid!=null)
		{
			HdzApplicant myapplicant=dao.PendingActionsDao.getapplicantbyapplicantid(alcoholid);
			HdzApplication myapplication= dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);
			
			
			myapplicant.setAlcoholtestflag("N");
			myapplicant.setDrugtestflag("N");
			
			dao.PendingActionsDao.update(myapplicant);
			
			session.setAttribute("DrugApplicant",myapplicant);
			
			myapplication.setAppstatus("Fail");
			
			session.setAttribute("hiremessage", "The Application is Failed!!!!");
			
			dao.PendingActionsDao.update(myapplication);
			
			if(comment!=null)
			{
				
				HdzEmployee user=(HdzEmployee)session.getAttribute("user");
				myapplication.setComments(user.getEmpname()+""+user.getPosition()+":"+comment);	
				
				dao.PendingActionsDao.update(myapplication);
				
			}
			
			session.setAttribute("DrugApplication",myapplication);	
			
			
			
			request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);
			
		}
	}

}
