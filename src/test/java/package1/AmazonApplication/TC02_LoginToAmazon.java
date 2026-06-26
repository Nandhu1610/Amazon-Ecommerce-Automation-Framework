package package1.AmazonApplication;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ExcelTestData;
import utility.ListenersLogic;
import utility.RetryLogic;

//Verify login is successful with correct email and password.
@Listeners(ListenersLogic.class)
public class TC02_LoginToAmazon extends BaseClass 
{
	@Test(retryAnalyzer = RetryLogic.class, dataProviderClass = ExcelTestData.class, dataProvider = "validLoginData")
	public void withValidCredential(String username, String password)
	{
		Reporter.log("Browser and URL launched Successfully");
		SoftAssert s1 = new SoftAssert();
		HomePage homepage = new HomePage(driver);
		homepage.hoveroverOnAccountsAndList(driver);
		Reporter.log("Hoverover Account and List is Successful");
		homepage.clickOnSignin();
		Reporter.log("Click on Signin is Successful");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enteringUsername(username);
		Reporter.log("Email id is entered Successfully");
		loginpage.clickOnContinue();
		Reporter.log("Browser and URL launched Successfully");
		loginpage.enteringPassword(password);
		Reporter.log("Password is entered Successfully");
		loginpage.clickOnSubmit();
		Reporter.log("Login is Successfully done");
		s1.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		s1.assertAll();
		Reporter.log("Testcase is pass");
	}
}
