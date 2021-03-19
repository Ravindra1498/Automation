package variables;

import java.util.ArrayList;

public class Landing_pageVariable {
	
	public static final String ExpectedURL = "http://automationpractice.com/index.php";
	public static final String LandingPageTitle = "My Store";
	public static final String LogoHeight = "99";
	public static final String LogoWidth = "350";
	
	
	public static ArrayList<String> ExpectedProductCategories()
	{
		ArrayList<String> expectedCategory = new ArrayList<String>();
		expectedCategory.add("WOMEN");
		expectedCategory.add("DRESSES");
		expectedCategory.add("T-SHIRTS");
		
		return expectedCategory;
	}
	

}
