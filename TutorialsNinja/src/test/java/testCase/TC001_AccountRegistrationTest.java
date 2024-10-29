package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;


public class TC001_AccountRegistrationTest extends BaseClass1 {



	@Test (groups = {"sanity", "smoke", "regression","FTP"})
	public void verify_Account_Registration ()
	{

		try
		{
		logger1.info("********** Test case is starting *********");
		HomePage hp = new  HomePage (driver);
		hp.MyAccount();
		logger1.info("********** clicked on myaccount*********");
		hp.Reigister();

		AccountRegistrationPage arp =new AccountRegistrationPage (driver);
		logger1.info("**********Validating details*********");
		arp.ckFname(randomeString().toUpperCase());
		arp.ckLname(randomeString().toUpperCase());
		arp.clEmail(randomeString()+ "@gmail.com");
		arp.ckNumber(randomeNumberic());

		String password = randomeAlphaNumeric();
		arp.ckPwd(password);
		arp.ckCpwd(password);
		arp.chkAgree();
		arp.ckContinue();

		
		logger1.info("**********validating expected message*********");
		String status = arp.getConfirmMsg();
		Assert.assertEquals(status, "Your Account Has Been Created!");
		System.out.println(status);
	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger1.info("********** Test case is finished *********");

	}





}
