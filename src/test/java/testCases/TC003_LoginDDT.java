package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven")
	public void verify_loginDDT(String email,String pwd,String exp)
	{
	logger.info("Starting TC003_LoginDDT");
	
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			AccountLoginPage loginpage = new AccountLoginPage(driver);
			loginpage.setEmail(email);
			loginpage.setPassword(pwd);
			loginpage.clickLogin();
			
			MyAccountPage account = new MyAccountPage(driver);
			boolean targetPage = account.isLoginSuccessful();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					account.clickLogout();
					Assert.assertTrue(true);
					
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			else if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					account.clickLogout();
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
		logger.info("Finished TC003_LoginDDt");
	}
	

}
