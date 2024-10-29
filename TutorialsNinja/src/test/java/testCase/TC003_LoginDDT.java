package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginTestPage;
import pageObject.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass1 {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups = { "smoke", "FTP"}) //Getting from different class
	public void verify_LoginDDT (String email, String pswd, String exp)
	{
		logger1.info ("*****Test case is started********");
		try {
		HomePage hp =new HomePage (driver);
		hp.MyAccount();
		hp.Login();
		
		LoginTestPage lp = new LoginTestPage (driver);
		lp.enterMail(email);
		lp.enterPswd(pswd);
		lp.clkLogin();
		
		MyAccountPage mp =new MyAccountPage (driver);
		boolean targetpage = mp.myAccountHeader();
		
	
		if (exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
			
				mp.clkLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
			
				mp.clkLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		logger1.info ("*****Test case is started********");
	
		
	}
}
