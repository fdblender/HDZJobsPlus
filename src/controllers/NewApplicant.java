package controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Gravatar;
import dao.ValidateUserDao;
import model.HdzApplicant;
import model.HdzApplicantskill;
import model.HdzEducation;
import model.HdzJobhistory;
import model.HdzReftable;
import services.NewApplicantService;
import util.PasswordUtil;

/**Joshua Tucker
 * 
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String objective=request.getParameter("objective");
		String summary=request.getParameter("summary");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String bday = request.getParameter("dob");
		String veteran = request.getParameter("veteran");
		String citizen = request.getParameter("citizen");
		List<HdzApplicantskill> skills =new ArrayList<HdzApplicantskill>();
		List<HdzEducation> edhist = new ArrayList<HdzEducation>();
		List<HdzJobhistory> jobhist = new ArrayList<HdzJobhistory>();
		List<HdzReftable> references = new ArrayList<HdzReftable>();
		for (int i = 1; i <= 3; i++) {
			HdzApplicantskill skill=new HdzApplicantskill();
			HdzEducation edu = new HdzEducation();
			HdzJobhistory job = new HdzJobhistory();
			HdzReftable reference = new HdzReftable();
			String schoolname = request.getParameter("edu" + i);
			String degree = request.getParameter("degree" + i);
			String datecomp = request.getParameter("date" + i);
			
			if (!schoolname.equals("") && !degree.equals("") && !datecomp.equals("")) {
				edu.setDegreecompleted(degree);
				edu.setDatecompleted(datecomp);
				edu.setSchoolname(schoolname);
				edhist.add(edu);
			}

			String jobTitle = request.getParameter("job" + i);
			String company = request.getParameter("company" + i);
			String jobdesc = request.getParameter("jobdesc" + i);
			String startdate = request.getParameter("start" + i);
			String enddate = request.getParameter("leave" + i);

			if (!jobTitle.equals("") && !company.equals("") && !jobdesc.equals("")) {
				job.setCompanyname(company);
				job.setDescription(jobdesc);
				job.setStartdate(startdate);
				job.setPosition(jobTitle);
				job.setEnddate(enddate);
				jobhist.add(job);
			}

			String refname = request.getParameter("refname" + i);
			String refnumber = request.getParameter("refphone" + i);
			String refemail = request.getParameter("refemail" + i);
			String refposition = request.getParameter("refpos" + i);

			if (!refname.equals("") && !refnumber.equals("") && !refemail.equals("") && !refposition.equals("")) {
				reference.setRefemail(refemail);
				reference.setRefname(refname);
				reference.setRefphone(refnumber);
				reference.setRefposition(refposition);
				references.add(reference);
			}
			
			String applicantskill=request.getParameter("skill"+i);
			String exp=request.getParameter("exp"+i);
			if(!applicantskill.equals("")||!exp.equals("")){
			System.out.println("-" +exp + "-");
			BigDecimal experience = new BigDecimal(exp);
			skill.setExperience(experience);
			skill.setSkills(applicantskill);
			skills.add(skill);
			}
		}

		String salt = PasswordUtil.getSalt();
		String hashedPwd = "";
		try {
			hashedPwd = PasswordUtil.hashPasswordPlusSalt(password, salt);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HdzApplicant applicant = new HdzApplicant();
		applicant.setBday(bday);

		applicant.setEmail(email);
		applicant.setFirstname(firstname);
		applicant.setLastname(lastname);
		applicant.setHashedpwd(hashedPwd);
		applicant.setCitizen(citizen);
		applicant.setVeteran(veteran);
		applicant.setSalt(salt);
		applicant.setEmployeeflag("N");
		NewApplicantService.insertApplicant(applicant);
		applicant = ValidateUserDao.getValidApplicant(email, password);
		applicant.setHdzEducations(edhist);
		applicant.setHdzJobhistories(jobhist);
		applicant.setHdzReftables(references);
		applicant.setResumeobjective(objective);
		applicant.setResumesummary(summary);
		applicant.setGravatarurl(Gravatar.setGravatarURL(email, 80));
		for (HdzEducation e : edhist) {
			e.setHdzApplicant(applicant);
		}
		for (HdzJobhistory j : jobhist) {
			j.setHdzApplicant(applicant);
		}
		for (HdzReftable r : references) {
			r.setHdzApplicant(applicant);
		}
		for (HdzApplicantskill s :skills){
			s.setHdzApplicant(applicant);
		}
		
		
		NewApplicantService.updateApplicant(applicant);

		String nextURL = "/login.jsp";
		request.getRequestDispatcher(nextURL).forward(request, response);
	}

}
