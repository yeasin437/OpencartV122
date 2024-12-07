package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass{
	@Test(groups={"sanity","Master"})
	public void verify_account_login()
	{
		logger.info("Starting TC_002 Login Test");

		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			AccountLoginPage loginpage = new AccountLoginPage(driver);
			loginpage.setEmail(p.getProperty("email"));
			loginpage.setPassword(p.getProperty("password"));
			loginpage.clickLogin();
			MyAccountPage account = new MyAccountPage(driver);
			Assert.assertEquals(account.isLoginSuccessful(), true,"Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished TC_002 LoginTest");
		
	}

}
