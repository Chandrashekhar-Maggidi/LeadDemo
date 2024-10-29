package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage (WebDriver driver)
	{
		super (driver);
	}
	
	//Locators
	@FindBy (xpath = "//h2[normalize-space()=\"My Account\"]") WebElement myaccount_head;
	
	@FindBy (xpath = "//a[@class=\"list-group-item\"][normalize-space()=\"Logout\"]") WebElement logout;
	
	//Action methods
	
	public boolean myAccountHeader ()
	{
		try {
			return(myaccount_head.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clkLogout()
	{
		logout.click();
	}
}
