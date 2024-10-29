package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage (WebDriver driver)
	{
		super(driver);
	}

	//Locators
	
	@FindBy (xpath = "//span[normalize-space()=\"My Account\"]") WebElement myaccount_lnk;
	@FindBy (xpath = "//a[normalize-space()=\"Register\"]") WebElement register_lnk ;
	@FindBy (xpath ="//a[normalize-space()=\"Login\"]") WebElement login_lnk;
	
	
	//Action methods
	
	public void MyAccount ()
	{
		myaccount_lnk.click();;
	}
	
	public void Reigister ()
	{
		register_lnk.click();;
	}
	public void Login ()
	{
		login_lnk.click();;
	}
}
