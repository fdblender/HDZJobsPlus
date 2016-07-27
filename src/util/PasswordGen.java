package util;

import java.security.NoSuchAlgorithmException;

public class PasswordGen {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String salt1=PasswordUtil.getSalt();
		String salt2=PasswordUtil.getSalt();
		String salt3=PasswordUtil.getSalt();
		String salt4=PasswordUtil.getSalt();
		String salt5=PasswordUtil.getSalt();
		String salt6=PasswordUtil.getSalt();
		String salt7=PasswordUtil.getSalt();
		String salt8=PasswordUtil.getSalt();
		String salt9=PasswordUtil.getSalt();
		
		System.out.println("Random Salt "+salt1);
		System.out.println("Random Salt "+salt2);
		System.out.println("Random Salt "+salt3);
		System.out.println("Random Salt "+salt4);
		System.out.println("Random Salt "+salt5);
		System.out.println("Random Salt "+salt6);
		System.out.println("Random Salt "+salt7);
		System.out.println("Random Salt "+salt8);
		System.out.println("Random Salt "+salt9);
		
		String pwd1 = "admin123";
		String pwd2 = "dave123";
		String pwd3 = "sam123";
		String pwd4 = "juli123";
		String pwd5 = "sue123";
		String pwd6 = "dan123";
		String pwd7 = "add123";
		String pwd8 = "tim123";
		String pwd9 = "pwd123";
		
		String hashpwd1= PasswordUtil.hashPasswordPlusSalt(pwd1, salt1);

		String hashpwd2= PasswordUtil.hashPasswordPlusSalt(pwd2, salt2);

		String hashpwd3= PasswordUtil.hashPasswordPlusSalt(pwd3, salt3);

		String hashpwd4= PasswordUtil.hashPasswordPlusSalt(pwd4, salt4);

		String hashpwd5= PasswordUtil.hashPasswordPlusSalt(pwd5, salt5);
		
		String hashpwd6= PasswordUtil.hashPasswordPlusSalt(pwd6, salt6);
		
		String hashpwd7= PasswordUtil.hashPasswordPlusSalt(pwd7, salt7);
		
		String hashpwd8= PasswordUtil.hashPasswordPlusSalt(pwd8, salt8);
		
		String hashpwd9= PasswordUtil.hashPasswordPlusSalt(pwd9, salt9);
		
		System.out.println("");;
		System.out.println(pwd1 + " "+hashpwd1);
		System.out.println(pwd2 + " "+hashpwd2);
		System.out.println(pwd3 + " "+hashpwd3);
		System.out.println(pwd4 + " "+hashpwd4);
		System.out.println(pwd5 + " "+hashpwd5);
		System.out.println(pwd6 + " "+hashpwd6);
		System.out.println(pwd7 + " "+hashpwd7);
		System.out.println(pwd8 + " "+hashpwd8);
		System.out.println(pwd9 + " "+hashpwd9);		
		
		
		
	}

}
