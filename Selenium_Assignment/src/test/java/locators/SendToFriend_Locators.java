
package locators;

import org.openqa.selenium.By;

public class SendToFriend_Locators {

		public static By SendToFriendNameOfFriendTextElement = By.xpath("//input[@id='friend_name']");
		public static By SendToFriendEmailOfFriendTextElement = By.xpath("//input[@id='friend_email']");
		public static By SendBtnElement = By.xpath("//button[@id='sendEmail']");
		public static By AfterEmailendMsg = By.xpath("//div[@class='fancybox-inner']/p[contains(text(),'Your e-mail has been sent successfully')]");
		public static By AfterSendEmailOkBtnElement = By.xpath("//p[@class='submit']/input");
}
