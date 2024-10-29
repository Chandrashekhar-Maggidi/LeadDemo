package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage (WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy (xpath = "//input[@id=\"input-firstname\"]") WebElement firstname_txt;
	@FindBy (xpath = "//input[@id=\"input-lastname\"]") WebElement lastname_txt;
	@FindBy (xpath = "//input[@id=\"input-email\"]") WebElement emai_txt;
	@FindBy (xpath = "//input[@id=\"input-telephone\"]") WebElement number_txt;
	@FindBy (xpath = "//input[@id=\"input-password\"]") WebElement pwd_txt ;
	@FindBy (xpath = "//input[@id=\"input-confirm\"]") WebElement cpwd_txt;
	@FindBy (xpath = "//input[@name=\"agree\"]") WebElement agree_chkBx;
	@FindBy (xpath = "//input[@value=\"Continue\"]") WebElement continue_btn;
	@FindBy (xpath = "//h1[normalize-space()=\"Your Account Has Been Created!\"]") WebElement verify_Txt;
	
	//Action Methods
	
	public void ckFname (String fname )
	{
		firstname_txt.sendKeys(fname);
	}
	
	public void ckLname (String lname)
	{
		lastname_txt.sendKeys(lname);
	}
	
	public void clEmail (String email)
	{
		emai_txt.sendKeys(email);
	}
	
	public void ckNumber (String number)
	{
		number_txt.sendKeys(number);
	}
	
	public void ckPwd (String pwd)
	{
		pwd_txt.sendKeys(pwd);
	}
	
	public void ckCpwd (String cpwd)
	{
		cpwd_txt.sendKeys(cpwd);
	}
	
	public void chkAgree ()
	{
		agree_chkBx.click();
	}
	
	public void ckContinue ()
	{
		continue_btn.click();
	}
	
	public String getConfirmMsg ()
	{
		try {
			return (verify_Txt.getText());
		}
		catch (Exception e)
		{
			return (e.getMessage());
		}
	}

}
