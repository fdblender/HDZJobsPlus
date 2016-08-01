package dao;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import util.DBUtil;
import util.Gravatar;
import util.PasswordUtil;
import model.HdzApplicant;
import model.HdzApplicantskill;
import model.HdzApplication;
import model.HdzEducation;
import model.HdzEmployee;
import model.HdzJob;
import model.HdzJobhistory;
import model.HdzReftable;

public class ApplicantDao {
	public static void insert(HdzApplicant applicant) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(applicant);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static HdzApplicant getApplicantByName(String firstname, String lastname) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		HdzApplicant applicant = null;
		String qString = "select a from HdzApplicant a " + "where a.firstname = :firstname  and a.lastname= :lastname ";

		try {
			TypedQuery<HdzApplicant> query = em.createQuery(qString, HdzApplicant.class);
			query.setParameter("firstname", firstname);
			query.setParameter("lastname", lastname);
			applicant = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return applicant;

	}

	public static void update(HdzApplicant applicant) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(applicant);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void insert(HdzApplication app) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(app);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void insert(HdzEducation edu) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(edu);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(HdzEducation edu) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(edu);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void insert(HdzJobhistory job) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(job);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(HdzJobhistory job) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(job);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void insert(HdzReftable ref) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(ref);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(HdzReftable ref) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(ref);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void insert(HdzApplicantskill skill) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(skill);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(HdzApplicantskill skill) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(skill);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static HdzApplicant AddApplicantAsEmployee(HdzEmployee employee) {

		HdzApplicant applicant = new HdzApplicant();

		applicant.setEmail(employee.getEmail());
		applicant.setHashedpwd(employee.getHashedpwd());
		applicant.setSalt(employee.getSalt());

		// TO DO: add last name to employee table
		applicant.setFirstname(employee.getEmpname());
		applicant.setLastname("");
		applicant.setGravatarurl(employee.getGravatarurl());

		// change to below if not working
		//applicant.setGravatarurl(Gravatar.setGravatarURL(email, 80));
		
		// set background check to completed		

		applicant.setCitizenflag("Y");
		applicant.setVeteranflag("Y");
		applicant.setVisaflag("Y");
		applicant.setDrugtestflag("Y");
		applicant.setStdpanelflag("Y");
		applicant.setDottestflag("Y");
		applicant.setAlcoholtestflag("Y");
		applicant.setEmployeeflag("Y");

		insert(applicant);
		return applicant;
	}

	public static List<HdzJob> getAllJobs() {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String qString = "select j from HdzJob j";

		List<HdzJob> jobs = null;
		try {
			TypedQuery<HdzJob> query = em.createQuery(qString, HdzJob.class);
			jobs = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return jobs;
	}

	public static List<HdzJob> searchJobs(String search) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		List<HdzJob> searchposts = null;
		String qString = "select j from HdzJob j " + "where j.position like :search";

		try {
			TypedQuery<HdzJob> query = em.createQuery(qString, HdzJob.class);
			query.setParameter("search", "%" + search + "%");
			searchposts = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return searchposts;
	}

	public static HdzJob getJobById(String id) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		HdzJob searchposts = null;
		String qString = "select j from HdzJob j " + "where j.jobsid = :search";

		try {
			TypedQuery<HdzJob> query = em.createQuery(qString, HdzJob.class);
			query.setParameter("search", Long.parseLong(id));
			searchposts = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return searchposts;
	}

	public static HdzApplicant getApplicantById(String appid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		HdzApplicant applicant = null;
		String qString = "select a from HdzApplicant a " + "where a.applicantid = :id";

		try {
			TypedQuery<HdzApplicant> query = em.createQuery(qString, HdzApplicant.class);
			query.setParameter("id", Long.parseLong(appid));
			applicant = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return applicant;
	}

	public static boolean checkFlags(HdzApplicant applicant) {
		// TODO Auto-generated method stub
		boolean pass = true;
		System.out.println(applicant.getAlcoholtestflag());
		for (HdzEducation edu : applicant.getHdzEducations()) {
			if (edu.getEducationflag() != null && edu.getEducationflag().equals("N")) {
				pass = false;
			}
		}
		for (HdzJobhistory job : applicant.getHdzJobhistories()) {
			if (job.getJobhistoryflag() != null && job.getJobhistoryflag().equals("N")) {
				pass = false;
			}
		}
		for (HdzReftable ref : applicant.getHdzReftables()) {
			if (ref.getRefflag() != null && ref.getRefflag().equals("N")) {
				pass = false;
			}
		}
		if ((applicant.getAlcoholtestflag() != null && applicant.getAlcoholtestflag().equals("Y"))
				|| (applicant.getDottestflag() != null && applicant.getDottestflag().equals("Y"))
				|| (applicant.getStdpanelflag() != null && applicant.getStdpanelflag().equals("Y"))) {
			System.out.println("in condn");

			pass = false;
		}
		if ((applicant.getCitizenflag() != null && applicant.getCitizenflag().equals("N"))
				|| (applicant.getVeteranflag() != null && applicant.getVeteranflag().equals("N"))
				|| (applicant.getVisaflag() != null && applicant.getVisaflag().equals("N"))) {
			pass = false;
		}

		return pass;
	}

}
