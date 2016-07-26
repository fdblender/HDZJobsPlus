package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUser;
import model.HdzApplicant;
import model.HdzEmployee;
import model.Huser;

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
		
		String useremail = request.getParameter("email");
		String userpassword = request.getParameter("password");
		String role = request.getParameter("role");
		//String nextURL = "/loginerror.jsp";

		if (action.equals("createaccount")) {
			// create an account for a new user
			System.out.println("Login: creating an account for a new user");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			user = DBUser.addNewUser(firstname, lastname, useremail, userpassword);
		} else {
			// validate the user for login
			System.out.println("Login: validating a user");
			user = DBUser.getValidUser(useremail, userpassword);
		}
		if (user != null) {
			System.out.println("found valid user" + useremail + " " + userpassword);
			session.setAttribute("user", user);
			session.setAttribute("firstname", String.valueOf(user.getFirstname()));
			session.setAttribute("lastname", String.valueOf(user.getLastname()));
			nextURL = "/Portal";
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
