package util;

import java.security.NoSuchAlgorithmException;

public class PasswordGen {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String salt0=PasswordUtil.getSalt();
		String salt1=PasswordUtil.getSalt();
		String salt2=PasswordUtil.getSalt();
		String salt3=PasswordUtil.getSalt();
		String salt4=PasswordUtil.getSalt();
		String salt5=PasswordUtil.getSalt();
		String salt6=PasswordUtil.getSalt();
		String salt7=PasswordUtil.getSalt();
		String salt8=PasswordUtil.getSalt();
		String salt9=PasswordUtil.getSalt();
		String salt10=PasswordUtil.getSalt();
		String salt11=PasswordUtil.getSalt();
		String salt12=PasswordUtil.getSalt();
		String salt13=PasswordUtil.getSalt();
		String salt14=PasswordUtil.getSalt();
		String salt15=PasswordUtil.getSalt();
		String salt16=PasswordUtil.getSalt();
		
		System.out.println("Random Salt 0 "+salt0);
		System.out.println("Random Salt 1 "+salt1);
		System.out.println("Random Salt 2 "+salt2);
		System.out.println("Random Salt 3 "+salt3);
		System.out.println("Random Salt 4 "+salt4);
		System.out.println("Random Salt 5 "+salt5);
		System.out.println("Random Salt 6 "+salt6);
		System.out.println("Random Salt 7 "+salt7);
		System.out.println("Random Salt 8 "+salt8);
		System.out.println("Random Salt 9 "+salt9);
		System.out.println("Random Salt 10 "+salt10);
		System.out.println("Random Salt 11 "+salt11);
		System.out.println("Random Salt 12 "+salt12);
		System.out.println("Random Salt 13 "+salt13);
		System.out.println("Random Salt 14 "+salt14);
		System.out.println("Random Salt 15 "+salt15);
		System.out.println("Random Salt 16 "+salt16);
		
		String pwd0 = "password";
		String pwd1 = "admin123";
		String pwd2 = "dave123";
		String pwd3 = "sam123";
		String pwd4 = "juli123";
		String pwd5 = "sue123";
		String pwd6 = "dan123";
		String pwd7 = "add123";
		String pwd8 = "tim123";
		String pwd9 = "pwd123";
		String pwd10 = "alton123";
		String pwd11= "ann123";
		String pwd12= "sal123";
		String pwd13= "roy123";
		String pwd14= "jerry123";
		String pwd15= "volker123";
		String pwd16= "tommy123";
		
		String hashpwd0= PasswordUtil.hashPasswordPlusSalt(pwd0, salt0);
		
		String hashpwd1= PasswordUtil.hashPasswordPlusSalt(pwd1, salt1);

		String hashpwd2= PasswordUtil.hashPasswordPlusSalt(pwd2, salt2);

		String hashpwd3= PasswordUtil.hashPasswordPlusSalt(pwd3, salt3);

		String hashpwd4= PasswordUtil.hashPasswordPlusSalt(pwd4, salt4);

		String hashpwd5= PasswordUtil.hashPasswordPlusSalt(pwd5, salt5);
		
		String hashpwd6= PasswordUtil.hashPasswordPlusSalt(pwd6, salt6);
		
		String hashpwd7= PasswordUtil.hashPasswordPlusSalt(pwd7, salt7);
		
		String hashpwd8= PasswordUtil.hashPasswordPlusSalt(pwd8, salt8);
		
		String hashpwd9= PasswordUtil.hashPasswordPlusSalt(pwd9, salt9);
		
		String hashpwd10= PasswordUtil.hashPasswordPlusSalt(pwd10, salt10);
		
		String hashpwd11= PasswordUtil.hashPasswordPlusSalt(pwd11, salt11);
		
		String hashpwd12= PasswordUtil.hashPasswordPlusSalt(pwd12, salt12);
		String hashpwd13= PasswordUtil.hashPasswordPlusSalt(pwd13, salt13);
		String hashpwd14= PasswordUtil.hashPasswordPlusSalt(pwd14, salt14);
		String hashpwd15= PasswordUtil.hashPasswordPlusSalt(pwd15, salt15);
		String hashpwd16= PasswordUtil.hashPasswordPlusSalt(pwd16, salt16);
		
		System.out.println("");
		System.out.println(pwd0 + " "+hashpwd0);
		System.out.println(pwd1 + " "+hashpwd1);
		System.out.println(pwd2 + " "+hashpwd2);
		System.out.println(pwd3 + " "+hashpwd3);
		System.out.println(pwd4 + " "+hashpwd4);
		System.out.println(pwd5 + " "+hashpwd5);
		System.out.println(pwd6 + " "+hashpwd6);
		System.out.println(pwd7 + " "+hashpwd7);
		System.out.println(pwd8 + " "+hashpwd8);
		System.out.println(pwd9 + " "+hashpwd9);		
		System.out.println(pwd10 + " "+hashpwd10);	
		System.out.println(pwd11 + " "+hashpwd11);	
		System.out.println(pwd12 + " "+hashpwd12);
		System.out.println(pwd13 + " "+hashpwd13);
		System.out.println(pwd14 + " "+hashpwd14);
		System.out.println(pwd15 + " "+hashpwd15);
		System.out.println(pwd16 + " "+hashpwd16);
		
		
	}

}
