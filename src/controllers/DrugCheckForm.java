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
		String drugid=request.getParameter("drugid");	
		String applicationid=request.getParameter("applicationid");
		
		if(applicationid!=null)
		{
			session.setAttribute("DrugApplicationid", applicationid);
			
			HdzApplication application=dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);
			
			session.setAttribute("DrugApplication",application);	
			
			request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);
		}
		
		if(drugid!=null)
		{
			HdzApplicant applicant=dao.PendingActionsDao.getapplicantbyapplicantid(drugid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("DrugApplicationid").toString());
			
			applicant.setDrugtestflag("Y");
			applicant.setAlcoholtestflag("Y");
			applicant.setDottestflag("Y");
			applicant.setStdpanelflag("Y");
			
			dao.PendingActionsDao.update(applicant);

			if(dao.PendingActionsDao.checkAppStatus(myapplication))
			{
				myapplication.setAppstatus("Hired");
				
				session.setAttribute("hiremessage", "The Applicant is hired!!!!");
				
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
		String drugid=request.getParameter("drugid");	
		String applicationid=session.getAttribute("DrugApplicationid").toString();
		
		
		if(drugid!=null)
		{
			HdzApplicant myapplicant=dao.PendingActionsDao.getapplicantbyapplicantid(drugid);
			HdzApplication myapplication= dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);
			
			myapplicant.setDottestflag("N");
			myapplicant.setAlcoholtestflag("N");
			myapplicant.setDottestflag("N");
			myapplicant.setDrugtestflag("N");
			
			dao.PendingActionsDao.update(myapplicant);
			
			myapplication.setAppstatus("Fail");
			
			session.setAttribute("hiremessage", "The Application is Failed!!!!");
			
			dao.PendingActionsDao.update(myapplication);
			
			session.setAttribute("DrugApplication",myapplication);	
			
			
			
			request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);
			
		}
	}

}
