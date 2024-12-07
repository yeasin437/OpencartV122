package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	//one single class - one test case
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("Starting TC001 AccountRegistrationTest");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("CLiked on Myaccount link");
		hp.clickRegister();
		logger.info("clicked on register link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("providing customer details ");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("validating expected message");
		String confmsg = regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			logger.error("Test failed...");
			logger.debug("debug logs...");
			Assert.fail();
		}
		logger.info("Finished TC001 AccountRegistrationTest");
	}
	
	
	

}
