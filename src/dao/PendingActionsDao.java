package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import controllers.PendingAction;
import util.*;
import model.*;

public class PendingActionsDao {

	public static void update(HdzApplicant user) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(HdzJobhistory user) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(HdzReftable user) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(HdzEducation user) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(HdzApplication user) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static HdzApplication getapplicationbyapplicationid(String applicationid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String qString = "Select u from HdzApplication u " + "where u.applicationid=:applicationid";
		TypedQuery<HdzApplication> q = em.createQuery(qString, HdzApplication.class);
		q.setParameter("applicationid", Long.parseLong(applicationid));
		HdzApplication user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}

	public static HdzReftable getrefbyrefid(String refid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String qString = "Select u from HdzReftable u " + "where u.refid=:refid";
		TypedQuery<HdzReftable> q = em.createQuery(qString, HdzReftable.class);
		q.setParameter("refid", Long.parseLong(refid));
		HdzReftable user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}

	public static HdzJobhistory getjobhisbyjobhisid(String jobhisid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String qString = "Select u from HdzJobhistory u " + "where u.jobhistoryid=:jobhisid";
		TypedQuery<HdzJobhistory> q = em.createQuery(qString, HdzJobhistory.class);
		q.setParameter("jobhisid", Long.parseLong(jobhisid));
		HdzJobhistory user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}

	public static HdzEducation getEdubyEduid(String eduid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String qString = "Select u from HdzEducation u " + "where u.educationid=:eduid";
		TypedQuery<HdzEducation> q = em.createQuery(qString, HdzEducation.class);
		q.setParameter("eduid", Long.parseLong(eduid));
		HdzEducation user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}

	public static HdzApplicant getapplicantbyapplicantid(String applicantid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String qString = "Select u from HdzApplicant u " + "where u.applicantid=:applicantid";
		TypedQuery<HdzApplicant> q = em.createQuery(qString, HdzApplicant.class);
		q.setParameter("applicantid", Long.parseLong(applicantid));
		HdzApplicant user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}

	public static List<HdzJobhistory> getjobhistorybyapplicantid(long applicantid) {

		EntityManager em = DBUtil.getEmfFactory().createEntityManager();

		String qString = "Select p from HdzJobhistory p where p.hdzApplicant.applicantid=:applicantid"
				+ " and p.jobhistoryflag is null";

		Query q = em.createQuery(qString);
		q.setParameter("applicantid", applicantid);
		List<HdzJobhistory> post = new ArrayList<HdzJobhistory>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}

	public static List<HdzEducation> getEducationbyapplicantid(long applicantid) {

		EntityManager em = DBUtil.getEmfFactory().createEntityManager();

		String qString = "Select p from HdzEducation p where p.hdzApplicant.applicantid=:applicantid"
				+ " and p.educationflag is null";

		Query q = em.createQuery(qString);
		q.setParameter("applicantid", applicantid);
		List<HdzEducation> post = new ArrayList<HdzEducation>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}

	public static List<HdzReftable> getRefbyapplicantid(long applicantid) {

		EntityManager em = DBUtil.getEmfFactory().createEntityManager();

		String qString = "Select p from HdzReftable p where p.hdzApplicant.applicantid=:applicantid"
				+ " and p.refflag is null";

		Query q = em.createQuery(qString);
		q.setParameter("applicantid", applicantid);
		List<HdzReftable> post = new ArrayList<HdzReftable>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}

	public static boolean checkAppStatus(HdzApplication myapplication) {
		boolean appstatus = false;
		List<HdzReftable> references = dao.PendingActionsDao
				.getRefbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
		List<HdzEducation> educations = dao.PendingActionsDao
				.getEducationbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
		List<HdzJobhistory> jobs = dao.PendingActionsDao
				.getjobhistorybyapplicantid(myapplication.getHdzApplicant().getApplicantid());

		HdzApplicant myapplicant = myapplication.getHdzApplicant();

		boolean refcheck = true;
		boolean educheck = true;
		boolean jobcheck = true;
		for (HdzReftable ref : references) {
			if (ref.getRefflag() != null) {
				if (ref.getRefflag().equals("N")) {
					refcheck = false;
					break;
				}
			}
		}

		for (HdzEducation edu : educations) {
			if (edu.getEducationflag() != null) {
				if (edu.getEducationflag().equals("N")) {
					educheck = false;
					break;
				}
			}
		}

		for (HdzJobhistory job : jobs) {
			if (job.getJobhistoryflag() != null) {

				if (job.getJobhistoryflag().equals("N")) {
					jobcheck = false;
					break;
				}
			}
		}
		if (myapplicant.getCitizenflag() != null && myapplicant.getVisaflag() != null
				&& myapplicant.getVeteranflag() != null && myapplicant.getDrugtestflag() != null
				&& myapplicant.getStdpanelflag() != null && myapplicant.getDottestflag() != null
				&& myapplicant.getAlcoholtestflag() != null) {
			if (myapplicant.getCitizenflag().equals("Y") && myapplicant.getVisaflag().equals("Y")
					&& myapplicant.getVeteranflag().equals("Y") && myapplicant.getDrugtestflag().equals("Y")) {
				if (refcheck && educheck && jobcheck) {
					if (myapplication.getAppstatus().equals("GroupInterviewDone")) {
						appstatus = true;
					}
				}
			}
		}
		return appstatus;

	}
	
	public static boolean checkWorkStatus(HdzApplication myapplication) {
		boolean appstatus = false;
		List<HdzReftable> references = dao.PendingActionsDao
				.getRefbyapplicantid(myapplication.getHdzApplicant().getApplicantid());
		
		List<HdzJobhistory> jobs = dao.PendingActionsDao
				.getjobhistorybyapplicantid(myapplication.getHdzApplicant().getApplicantid());

		HdzApplicant myapplicant = myapplication.getHdzApplicant();

		boolean refcheck = true;
		
		boolean jobcheck = true;
		for (HdzReftable ref : references) {
			if (ref.getRefflag() != null) {
				if (ref.getRefflag().equals("N")) {
					refcheck = false;
					break;
				}
			}
		}

		

		for (HdzJobhistory job : jobs) {
			if (job.getJobhistoryflag() != null) {

				if (job.getJobhistoryflag().equals("N")) {
					jobcheck = false;
					break;
				}
			}
		}
		if ( myapplicant.getVeteranflag() != null ) {
			if (myapplicant.getVeteranflag().equals("Y") ) {
				if (refcheck && jobcheck) {
					
						appstatus = true;
					
				}
			}
		}
		return appstatus;

	}

	public static HdzApplication getapplicationbyappidNationality(String applicationid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String qString = "Select u from HdzApplication u " + "where u.applicationid=:applicationid"
				+ " and (u.hdzApplicant.citizenflag is null || u.hdzApplicant.visaflag is null)";
		TypedQuery<HdzApplication> q = em.createQuery(qString, HdzApplication.class);
		q.setParameter("applicationid", Long.parseLong(applicationid));
		HdzApplication hdzApplication = null;
		try {
			hdzApplication = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return hdzApplication;
	}

	public static HdzApplication getapplicationbyappifDrugTest(String applicationid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String qString = "Select u from HdzApplication u " + "where u.applicationid=:applicationid"
				+ " and u.hdzApplicant.drugtestflag is null";
		TypedQuery<HdzApplication> q = em.createQuery(qString, HdzApplication.class);
		q.setParameter("applicationid", Long.parseLong(applicationid));
		HdzApplication hdzApplication = null;
		try {
			hdzApplication = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return hdzApplication;
	}

	public static HdzApplication getapplicationbyappidVet(String applicationid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String qString = "Select u from HdzApplication u " + "where u.applicationid=:applicationid"
				+ " and u.hdzApplicant.veteranflag is null";
		TypedQuery<HdzApplication> q = em.createQuery(qString, HdzApplication.class);
		q.setParameter("applicationid", Long.parseLong(applicationid));
		HdzApplication hdzApplication = null;
		try {
			hdzApplication = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return hdzApplication;
	}

}
