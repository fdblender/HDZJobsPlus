package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HdzApplicant;
import model.HdzEducation;
import model.HdzJobhistory;

/**
 * Servlet implementation class NewApplicant
 */
@WebServlet("/NewApplicant")
public class NewApplicant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewApplicant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String bday =request.getParameter("dob");
		String veteran=request.getParameter("veteran");
		String citizen=request.getParameter("citizen");
		
		List<HdzEducation>  edhist=new ArrayList<HdzEducation>();
		List<HdzJobhistory> job1=new ArrayList<HdzJobhistory>();
		
		HdzApplicant applicant= new HdzApplicant();
		applicant.setBday(bday);
		applicant.setEmail(email);
		applicant.setFirstname(firstname);
		applicant.setLastname(lastname);
		applicant.setPwd(password);
		applicant.setCitizen(citizen);
		applicant.setVeteran(veteran);
		
	}

}
