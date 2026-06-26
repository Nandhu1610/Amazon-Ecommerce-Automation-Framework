package package1.AmazonApplication;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ExcelTestData;
import utility.ListenersLogic;
import utility.RetryLogic;

//Test if a new user can successfully register.
@Listeners(ListenersLogic.class)
public class TC01_NewUserRegistration extends BaseClass
{
	@Test(retryAnalyzer=RetryLogic.class, dataProviderClass = ExcelTestData.class, dataProvider = "validLoginData")
	public void registrationProcess(String username, String password)
	{
		Reporter.log("Browser and URL launched Successfully");
		SoftAssert s1 = new SoftAssert();
		HomePage homepage=new HomePage(driver);
		LoginPage loginpage=new LoginPage(driver);
		homepage.hoveroverOnAccountsAndList(driver);
		Reporter.log("Hoverover on Accounts and Lists is successful");
		homepage.clickOnStartHere();
		Reporter.log("Click on Start here is Successful");
		s1.assertEquals(driver.getTitle(), "Amazon Sign-In");
		loginpage.enteringUsername(username);
		Reporter.log("Username is entered successfully");
		loginpage.clickOnContinue();
		Reporter.log("Click on continue button is successful");
		if(driver.getTitle().equalsIgnoreCase("Amazon Intent Confirmation"))
		{
			loginpage.clickOnProceedToCreateAcc();
			Reporter.log("Click on proceed to create an account is successfull");
			s1.assertEquals(driver.getTitle(), "Amazon Registration");
			loginpage.enteringMobileNo();
			Reporter.log("Mobile number is entered successfully");
			loginpage.enteringCustomerName();
			Reporter.log("Customer Name is entered successfully");
			loginpage.clickOnVerifyBtn();
			Reporter.log("Click on Verify mobile no is successful");
		}
		else
		{
			loginpage.enteringPassword(password);
			Reporter.log("Password is entered Successfully");
			loginpage.clickOnSubmit();
			Reporter.log("Login is Successfully done");
			s1.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");	
		}
		s1.assertAll();
		Reporter.log("Testcase is pass");
	}
}
