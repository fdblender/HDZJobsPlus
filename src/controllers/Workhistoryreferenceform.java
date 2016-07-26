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
 * Servlet implementation class Workhistoryreferenceform
 */
@WebServlet("/Workhistoryreferenceform")
public class Workhistoryreferenceform extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Workhistoryreferenceform() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		String refid=request.getParameter("refid");	
		String workid=request.getParameter("workid");	
		String veteranid=request.getParameter("veteranid");
		String applicationid=request.getParameter("applicationid");
		
		if(applicationid!=null)
		{
			session.setAttribute("WorkApplicationid", applicationid);
			HdzApplication application=dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);
			List<HdzJobhistory> myjobs=dao.PendingActionsDao.getjobhistorybyapplicantid(application.getHdzApplicant().getApplicantid());
			List<HdzReftable> myreferences=dao.PendingActionsDao.getRefbyapplicantid(application.getHdzApplicant().getApplicantid());
			
			session.setAttribute("VeteranApplication", application);
			
			session.setAttribute("WorkHistoryCheck", myjobs);
			
			session.setAttribute("ReferenceCheck", myreferences);
			
			request.getRequestDispatcher("workhistorycheck.jsp").forward(request, response);
		}
		
		if(refid!=null)
		{
			HdzReftable myref=dao.PendingActionsDao.getrefbyrefid(refid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("WorkApplicationid").toString());
			
			myref.setRefflag("Y");
			
			dao.PendingActionsDao.update(myref);
			
			if(dao.PendingActionsDao.checkAppStatus(myapplication))
			{
				myapplication.setAppstatus("Hired");
				
				dao.PendingActionsDao.update(myapplication);
			}
			
			List<HdzJobhistory> myjobs=dao.PendingActionsDao.getjobhistorybyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			List<HdzReftable> myreferences=dao.PendingActionsDao.getRefbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			
			session.setAttribute("VeteranApplication", myapplication);
			session.setAttribute("WorkHistoryCheck", myjobs);
			
			session.setAttribute("ReferenceCheck", myreferences);
			
			request.getRequestDispatcher("workhisrefercheck.jsp").forward(request, response);
			
			
		}
		
		if(workid!=null)
		{
			HdzJobhistory myjob=dao.PendingActionsDao.getjobhisbyjobhisid(workid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("WorkApplicationid").toString());
			
			myjob.setJobhistoryflag("Y");
			
			dao.PendingActionsDao.update(myjob);
			
			if(dao.PendingActionsDao.checkAppStatus(myapplication))
			{
				myapplication.setAppstatus("Hired");
				
				dao.PendingActionsDao.update(myapplication);
			}
			
			List<HdzJobhistory> myjobs=dao.PendingActionsDao.getjobhistorybyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			List<HdzReftable> myreferences=dao.PendingActionsDao.getRefbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			
			session.setAttribute("VeteranApplication", myapplication);
			session.setAttribute("WorkHistoryCheck", myjobs);
			
			session.setAttribute("ReferenceCheck", myreferences);
			
			request.getRequestDispatcher("workhisrefercheck.jsp").forward(request, response);
			
			
		}
		if(veteranid!=null)
		{
			HdzApplicant myapplicant=dao.PendingActionsDao.getapplicantbyapplicantid(veteranid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("WorkApplicationid").toString());
			
			myapplicant.setVeteranflag("Y");
			
			dao.PendingActionsDao.update(myapplicant);
			
			if(dao.PendingActionsDao.checkAppStatus(myapplication))
			{
				myapplication.setAppstatus("Hired");
				
				dao.PendingActionsDao.update(myapplication);
			}
			
			List<HdzJobhistory> myjobs=dao.PendingActionsDao.getjobhistorybyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			List<HdzReftable> myreferences=dao.PendingActionsDao.getRefbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			
			session.setAttribute("VeteranApplication", myapplication);
			session.setAttribute("WorkHistoryCheck", myjobs);
			
			session.setAttribute("ReferenceCheck", myreferences);
			
			request.getRequestDispatcher("workhisrefercheck.jsp").forward(request, response);
		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();	
		String refid=request.getParameter("refid");	
		String workid=request.getParameter("workid");
		String veteranid=request.getParameter("veteranid");
		
		if(refid!=null)
		{
			HdzReftable myref=dao.PendingActionsDao.getrefbyrefid(refid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("WorkApplicationid").toString());
			
			myref.setRefflag("N");
			
			dao.PendingActionsDao.update(myref);
			
			myapplication.setAppstatus("Fail");
			
			dao.PendingActionsDao.update(myapplication);
			
			List<HdzJobhistory> myjobs=dao.PendingActionsDao.getjobhistorybyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			List<HdzReftable> myreferences=dao.PendingActionsDao.getRefbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			
			session.setAttribute("VeteranApplication", myapplication);
			session.setAttribute("WorkHistoryCheck", myjobs);
			
			session.setAttribute("ReferenceCheck", myreferences);
			
			request.getRequestDispatcher("workhisrefercheck.jsp").forward(request, response);
			
			
		}
		
		if(workid!=null)
		{
			HdzJobhistory myjob=dao.PendingActionsDao.getjobhisbyjobhisid(workid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("WorkApplicationid").toString());
			
			myjob.setJobhistoryflag("N");
			
			dao.PendingActionsDao.update(myjob);
			
			myapplication.setAppstatus("Fail");
			
			dao.PendingActionsDao.update(myapplication);
			
			List<HdzJobhistory> myjobs=dao.PendingActionsDao.getjobhistorybyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			List<HdzReftable> myreferences=dao.PendingActionsDao.getRefbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			
			session.setAttribute("VeteranApplication", myapplication);
			session.setAttribute("WorkHistoryCheck", myjobs);
			
			session.setAttribute("ReferenceCheck", myreferences);
			
			request.getRequestDispatcher("workhisrefercheck.jsp").forward(request, response);
			
			
		}
		if(veteranid!=null)
		{
			HdzApplicant myapplicant=dao.PendingActionsDao.getapplicantbyapplicantid(veteranid);
			
			HdzApplication myapplication=dao.PendingActionsDao.getapplicationbyapplicationid(session.getAttribute("WorkApplicationid").toString());
			
			myapplicant.setVeteranflag("N");
			
			dao.PendingActionsDao.update(myapplicant);
			
			myapplication.setAppstatus("Fail");
			
			dao.PendingActionsDao.update(myapplication);
			
			List<HdzJobhistory> myjobs=dao.PendingActionsDao.getjobhistorybyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			List<HdzReftable> myreferences=dao.PendingActionsDao.getRefbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
			
			session.setAttribute("VeteranApplication", myapplication);
			session.setAttribute("WorkHistoryCheck", myjobs);
			
			session.setAttribute("ReferenceCheck", myreferences);
			
			request.getRequestDispatcher("workhisrefercheck.jsp").forward(request, response);
		}
		
	}

}
