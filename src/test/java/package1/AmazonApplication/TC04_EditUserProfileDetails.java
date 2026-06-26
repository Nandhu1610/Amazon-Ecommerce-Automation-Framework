package package1.AmazonApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ExcelTestData;
import utility.ListenersLogic;
import utility.RetryLogic;

//Check if a user can successfully edit their profile information.
@Listeners(ListenersLogic.class)
public class TC04_EditUserProfileDetails extends BaseClass
{
	@Test(retryAnalyzer=RetryLogic.class,dataProviderClass = ExcelTestData.class, dataProvider = "validLoginData")
	public void editProfileInformation(String username, String password)
	{
		Reporter.log("Browser Launched Succesfully");
		SoftAssert s1=new SoftAssert();
		HomePage homepage=new HomePage(driver);
		homepage.hoveroverOnAccountsAndList(driver);
		Reporter.log("Hoverover on Accounts and Lists is successful");
		homepage.clickOnSignin();
		Reporter.log("Click on signin is successful");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enteringUsername(username);
		Reporter.log("Username is entered successfully");
		loginpage.clickOnContinue();
		Reporter.log("Click on continue button is successful");
		loginpage.enteringPassword(password);
		Reporter.log("Password is entered successfully");
		loginpage.clickOnSubmit();
		Reporter.log("Click on submit button is successful");
		homepage.hoveroverOnAccountsAndList(driver);
		Reporter.log("Hoverover on Accounts and Lists is successful");
		homepage.clickOnYourAccount();
		Reporter.log("Click on Your account is successful");
		MyAccountsPage accountspage=new MyAccountsPage(driver);
		accountspage.clickOnLoginAndSecurity();
		Reporter.log("Click on Login and Security is successful");
		accountspage.editName();
		Reporter.log("Click on name edit is successful");
		accountspage.updateName(driver);
		Reporter.log("Entering new customer name is successful");
		accountspage.clickOnSaveChanges();
		Reporter.log("Click on save changes button is successful");
		WebElement successMessage=driver.findElement(By.xpath("//div[@id='auth-success-message-box']"));
		s1.assertEquals(successMessage.getText().contains("Name updated."), true);
		s1.assertAll();
		Reporter.log("Testcase is pass");
	}
}
