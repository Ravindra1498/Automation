package variables;

import utilities.randomNumberGen;

public class SignInPage_variable {
	
	static randomNumberGen randomUtil = new randomNumberGen();
	
	public static final String SignInPageTitle = "Login - My Store";
	public static final String UserEmail = "User"+randomUtil.randomNumberGengerator_000_00()+"@gmail.com";

}
