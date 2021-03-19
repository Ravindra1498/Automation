package variables;

import utilities.randomNumberGen;

public class RegisterUserDetails_Variables {
	
	static randomNumberGen randomUtil = new randomNumberGen();
	
	public static final String crateAnAccountText = "CREATE AN ACCOUNT";
	public static final String userFirstName = randomUtil.randomStringGenerator();
	public static final String userLastName = randomUtil.randomStringGenerator();
	public static final String userPassword = "Ravindra@11";
	public static final String BirthDay = "14  ";
	public static final String BirthMonth = "June ";
	public static final String BirthYear = "1988  ";
	public static final boolean IsSignUpForNewsLetter = true;
	public static final boolean IsspecialOfferEmailRec = true;
	public static final String AddressFirstName = userFirstName;
	public static final String AddressLastName = userLastName;
	public static final String AddressCompanyName = "demo company";
	public static final String AddressLine1 = "255 shramik nagar";
	public static final String AddressLine2 = "new apartment 5 floor";
	public static final String AddressCity = "Los Angeles";
	public static final String AddressState = "New York";
	public static final String AddressZipCode = "00000";
	public static final String AddressAdditionalInfo = "abcdefg";
	public static final String AddressHomePhone = "987654321";
	public static final String AddressMobilePhone = "123456789";
	public static final String AdddressAliasAddress = "newdemo@gmail.com";

}
