package dao;

import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import util.PasswordUtil;
import model.HdzApplicant;
import model.HdzEmployee;
import util.DBUtil;

public class ValidateUserDao {

	public static HdzApplicant getValidApplicant(String email, String password) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String qString = "Select u from HdzApplicant u where u.email=:email";
		TypedQuery<HdzApplicant> q = em.createQuery(qString, HdzApplicant.class);
		q.setParameter("email", email);
		HdzApplicant user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			em.close();
		}

		if (user != null) {
			try {
	
				// get the expected Hash of the password + the salt stored in the
				// database
				String expectedHash = user.getHashedpwd();
	
				// if the expected hash does not match the user entered password +
				// salt
				// then set user to null
				if (!PasswordUtil.compareSaltedHashWithUserEnteredPwd(user.getSalt(), password, expectedHash)) {
					user = null;
					//System.out.println("ValidateUserDao: password does not compare, setting user to null");
				} else {
					//System.out.println("ValidateUserDao: password validated: " + password);
				}
	
			} catch (NoSuchAlgorithmException e) {
				return null;
			}
		}

		return user;
	}
	

	public static HdzEmployee getValidEmployee(String email, String password) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String qString = "Select u from HdzEmployee u where u.email=:email";
		TypedQuery<HdzEmployee> q = em.createQuery(qString, HdzEmployee.class);
		q.setParameter("email", email);
		HdzEmployee user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			em.close();
		}

		if (user != null) {
			try {
	
				// get the expected Hash of the password + the salt stored in the
				// database
				String expectedHash = user.getHashedpwd();
	
				// if the expected hash does not match the user entered password +
				// salt
				// then set user to null
				if (!PasswordUtil.compareSaltedHashWithUserEnteredPwd(user.getSalt(), password, expectedHash)) {
					user = null;
					//System.out.println("ValidateUserDao: password does not compare, setting user to null");
				} else {
					//System.out.println("ValidateUserDao: password validated: " + password);
				}
	
			} catch (NoSuchAlgorithmException e) {
				return null;
			}
		}

		return user;
	}

}
