package package1.AmazonApplication;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ExcelTestData;
import utility.ListenersLogic;
import utility.RetryLogic;

//Check if user is able to select each payment method
@Listeners(ListenersLogic.class)
public class TC12_ValidateSelectingPaymentOptions extends BaseClass
{
	@Test(retryAnalyzer=RetryLogic.class,dataProviderClass = ExcelTestData.class, dataProvider = "validLoginData")
	public void selectingPaymentOptions(String username, String password)
	{
		Reporter.log("Browser Launched Successfully");
		SoftAssert s1=new SoftAssert();
		HomePage homepage=new HomePage(driver);
		LoginPage loginpage=new LoginPage(driver);
		ProductsListPage productspage=new ProductsListPage(driver);
		CartPage cartpage=new CartPage(driver);
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		homepage.hoveroverOnAccountsAndList(driver);
		Reporter.log("Hoverover on Accounts and list is successful");
		homepage.clickOnSignin();
		Reporter.log("Click on signin is successful");
		loginpage.enteringUsername(username);
		Reporter.log("Username entered successfully");
		loginpage.clickOnContinue();
		Reporter.log("Click on continue button is successful");
		loginpage.enteringPassword(password);
		Reporter.log("Password entered successfully");
		loginpage.clickOnSubmit();
		Reporter.log("Click on submit is successful");
		homepage.enteringProductNameinSearch();
		Reporter.log("Product search is successful");
		productspage.clickOnAddToCart();
		Reporter.log("Click on add to cart is successful");
		productspage.clickOnGoToCart();
		Reporter.log("Click on go to cart is successful");
		cartpage.clickOnProceedToBuy();
		Reporter.log("Click on Proceed to buy is successful");
		s1.assertEquals(driver.getCurrentUrl().contains("checkout"), true, "Checkout page is not opened");
		if(driver.getPageSource().contains("This Item is currently unavailable"))
		{
			throw new RuntimeException("Checkout cannot continue because the product is unavailable");
		}
		int selectablePaymentMethods=checkoutpage.verifyAllPaymentMethodsAreSelectable();
		int totalMethods=checkoutpage.getPaymentOptionsCount();
		s1.assertEquals(selectablePaymentMethods, totalMethods, "Some payment methods could not be selected");
		s1.assertAll();
	}
}
