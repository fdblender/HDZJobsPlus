package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HDZjobs");
	
	public static EntityManagerFactory getEmfFactory() {
		return emf;
	}

}
