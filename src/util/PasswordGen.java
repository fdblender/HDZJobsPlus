package util;

import java.security.NoSuchAlgorithmException;

public class PasswordGen {
	
	public static void printUserCredentials(String firstname, String lastname) throws NoSuchAlgorithmException {
		String salt = PasswordUtil.getSalt();
		String password = firstname+"123";
		String hashpwd = PasswordUtil.hashPasswordPlusSalt(password, salt);
		String email = firstname+"123@gmail.com";
		System.out.println(email+"  "+hashpwd+" "+salt+" "+firstname +" "+lastname);		
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {		
		
		String firstname = "dave";
		String lastname = "won";
		printUserCredentials(firstname, lastname);
		
		String firstname1 = "sam";
		String lastname1 = "snapple";
		printUserCredentials(firstname1, lastname1);
		
		String firstname2 = "juli";
		String lastname2= "just";
		printUserCredentials(firstname2, lastname2);
		
		String firstname3 = "sue";
		String lastname3 = "sands";
		printUserCredentials(firstname3, lastname3);
		
		String firstname4 = "dan";
		String lastname4 = "danger";
		printUserCredentials(firstname4, lastname4);
		
		String firstname5 = "ann";
		String lastname5 = "anders";
		printUserCredentials(firstname5, lastname5);
		
		String firstname6 = "tim";
		String lastname6 = "tunes";
		printUserCredentials(firstname6, lastname6);
		
		String firstname7 = "alton";
		String lastname7 = "smith";
		printUserCredentials(firstname7, lastname7);
		
		String firstname8 = "chris";
		String lastname8 = "kristoff";
		printUserCredentials(firstname8, lastname8);
		
	}

}
