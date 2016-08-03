package util;

import java.security.NoSuchAlgorithmException;

public class PasswordGen {
	
	public static void printUserCredentials(String firstname, String lastname) throws NoSuchAlgorithmException {
		String salt = PasswordUtil.getSalt();
		String password = firstname+"123";
		String hashpwd = PasswordUtil.hashPasswordPlusSalt(password, salt);
		String email = firstname+"123@gmail.com";
		/*System.out.println(email+" hashed pwd: "+hashpwd+" salt: "+salt+" "+firstname +" "+lastname);*/		
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {		
		
		String firstname = "ada";
		String lastname = "won";
		printUserCredentials(firstname, lastname);
		
		String firstname1 = "amy";
		String lastname1 = "snapple";
		printUserCredentials(firstname1, lastname1);
		
		String firstname2 = "bea";
		String lastname2= "just";
		printUserCredentials(firstname2, lastname2);
		
		String firstname3 = "deb";
		String lastname3 = "sands";
		printUserCredentials(firstname3, lastname3);
		
		String firstname4 = "ben";
		String lastname4 = "danger";
		printUserCredentials(firstname4, lastname4);
		
		String firstname5 = "bud";
		String lastname5 = "anders";
		printUserCredentials(firstname5, lastname5);
		
		String firstname6 = "emma";
		String lastname6 = "tunes";
		printUserCredentials(firstname6, lastname6);
		
		String firstname7 = "dee";
		String lastname7 = "smith";
		printUserCredentials(firstname7, lastname7);
		
		String firstname8 = "mick";
		String lastname8 = "McClain";
		printUserCredentials(firstname8, lastname8);
		
		String firstname9 = "zordon";
		String lastname9 = "Zoom";
		printUserCredentials(firstname9, lastname9);
		
		
		
	}

}
