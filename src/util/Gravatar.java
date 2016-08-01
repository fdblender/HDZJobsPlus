package util;

import model.HdzApplicant;

public class Gravatar {
	//private static String gravatarUrl;
	
	public Gravatar(){
		
	}
	public static  String setGravatarUser(HdzApplicant applicant, int size) {
		// TODO Auto-generated method stub
		String email=applicant.getEmail();
		return "https://www.gravatar.com/avatar/" + MD5Util.md5Hex(email) + "=" + size;
	}
	public static  String setGravatarURL(String  email, int size) {
		// TODO Auto-generated method stub
		return "https://www.gravatar.com/avatar/" + MD5Util.md5Hex(email) + "=" + size;
	}
}
