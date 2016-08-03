import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.PasswordUtil;

public class PasswordUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String salt1=PasswordUtil.getSalt();
		String pwd1 = "admin123";
		/*System.out.println("Password: "+pwd1+ "  Random Salt "+salt1);*/
		String hashpwd1;
		
		try {
			hashpwd1= PasswordUtil.hashPasswordPlusSalt(pwd1, salt1);
			assertTrue(PasswordUtil.compareSaltedHashWithUserEnteredPwd(salt1, pwd1, hashpwd1));
		} catch (NoSuchAlgorithmException e) {
		}	
	}
}
