package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"regression", "master"})
	public void verify_account_registration()
	{
		logger.info("***** starting TC_001_AccountRegistrationTest ****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("***** Clicked on My Account Link *****");
		hp.clickRegister();
		logger.info("***** Clicked on Registration Link *****");
		
		
		logger.info("***** Entering Customer ******");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("validating test");
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("test pass");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("test fail");
			Assert.fail();
		}
		
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		
		logger.info("****** Finished TC_001_AccountRegistrationTest *****");
		
	}
	
	
	
	
}








