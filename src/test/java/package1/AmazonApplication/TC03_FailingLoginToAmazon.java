package package1.AmazonApplication;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ExcelTestData;
import utility.ListenersLogic;
import utility.RetryLogic;

//Ensure login fails with incorrect email or password.
@Listeners(ListenersLogic.class)
public class TC03_FailingLoginToAmazon extends BaseClass 
{
	@Test(retryAnalyzer = RetryLogic.class,dataProviderClass = ExcelTestData.class, dataProvider = "invalidLoginData")
	public void withInvalidCredential(String username) 
	{
		Reporter.log("Browser Launched Successfully");
		SoftAssert s1=new SoftAssert();
		HomePage homepage=new HomePage(driver);
		homepage.hoveroverOnAccountsAndList(driver);
		Reporter.log("Hoverover on Accounts and Lists successful");
		homepage.clickOnSignin();
		Reporter.log("Click on Signin is successful");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enteringUsername(username);
		Reporter.log("Username is entered successfully");
		loginpage.clickOnContinue();
		Reporter.log("Click on continue button is successful");
		String actualError=loginpage.invalidEmailerrorMessage();
		s1.assertEquals(actualError,"Invalid email address");
		Reporter.log("Error message displayed");
		s1.assertAll();
		Reporter.log("Testcase is pass");
	}
}
