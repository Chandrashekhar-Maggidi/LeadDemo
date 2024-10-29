package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginTestPage extends BasePage {
	
	public LoginTestPage (WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy (xpath = "//input[@id=\"input-email\"]") WebElement email_entr ;
	
	@FindBy (xpath = "//input[@id=\"input-password\"]") WebElement pswd_entr;
	
	@FindBy (xpath = "//input[@value=\"Login\"]") WebElement login_btn;
	
	//Action methods
	
	public void enterMail (String mail)
	{
		email_entr.sendKeys(mail);
	}
	public void enterPswd (String pwd)
	{
		pswd_entr.sendKeys(pwd);
	}
	public void clkLogin ()
	{
		login_btn.click();
	}

}
