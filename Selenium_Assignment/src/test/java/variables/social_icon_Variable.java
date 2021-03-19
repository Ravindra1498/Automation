package variables;

import utilities.randomNumberGen;

public class social_icon_Variable {
	
	static randomNumberGen randomUtil = new randomNumberGen();

	public static final String ExpectedFacebookPageName = "Selenium Framework";
	public static final String ExpectedTwitterPageName = "Selenium Framework";
	public static final String ExpectedYoutubePageName = "Selenium Framework";
	//public static final String ExpectedPageName = "Selenium Framework";
	
	public static final String NewLetterUserEmail = "User"+randomUtil.randomNumberGengerator_000_00()+"@gmail.com";
	
	public static final String ExpectedNewsLetterMsg = "Newsletter : You have successfully subscribed to this newsletter.";
	
}
