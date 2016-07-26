package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ValidateUserDao;
import model.HdzApplicant;
import model.HdzEmployee;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HdzApplicant applicant = null;
		HdzEmployee employee = null;
		String nextURL = "/error.jsp";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String loginrole = request.getParameter("loginrole");		

		if (loginrole.equals("applicant")) {
		// validate an employee user
			System.out.println("Login: validating an applicant"+ email + " " + password);
			applicant = ValidateUserDao.getValidApplicant(email, password);
			if (applicant != null) {
				System.out.println("found valid user" + email + " " + password);
				session.setAttribute("user", applicant);
				session.setAttribute("role",  "applicant");
				session.setAttribute("userrole",  1);
				nextURL = "/yourapplications.jsp";
			} else {
				System.out.println("user not found: " + email + " " + password);
				nextURL = "/newapplicant.jsp";
			}
			
			
		} else {
			// validate an employee user	
			System.out.println("Login: validating an employee"+ email + " " + password);
			employee = ValidateUserDao.getValidEmployee(email, password);		
			if (employee != null) {
				System.out.println("found valid user" + email + " " + password);
				session.setAttribute("user", employee);
				session.setAttribute("role",  employee.getPosition().replaceAll(" ", ""));
				session.setAttribute("userrole",  2);
				nextURL = "/PendingAction";
			} else {
				System.out.println("user not found: " + email + " " + password);
				nextURL = "/login.jsp";
			}
		}
		request.getRequestDispatcher(nextURL).forward(request,response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
