package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginTestPage;
import pageObject.MyAccountPage;

public class TC002_LoginTest extends BaseClass1{

	@Test(groups = { "sanity","DatDriven","FTP"})
	public void verifyLogin ()
	{
		logger1.info ("*****Test case is started********");
		try {
		HomePage hp =new HomePage (driver);
		hp.MyAccount();
		hp.Login();
		
		LoginTestPage lp = new LoginTestPage (driver);
		lp.enterMail(prop.getProperty("email"));
		lp.enterPswd(prop.getProperty("password"));
		lp.clkLogin();
		
		MyAccountPage mp =new MyAccountPage (driver);
		boolean targetpage = mp.myAccountHeader();
		//Assert.assertEquals(targetpage, true, "Login failed");
		Assert.assertTrue(targetpage);
		System.out.print("Login test is completed successfuly");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		logger1.info ("*****Test case is started********");
	}
}
