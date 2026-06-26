package package1.AmazonApplication;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ListenersLogic;
import utility.RetryLogic;

//Reach till cart page without login in amazon application
@Listeners(ListenersLogic.class)
public class TC15_ReachCartPageWithoutLogin extends BaseClass 
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void goToCartWithoutLogin()
	{
		Reporter.log("Browser Launched Successfully");
		SoftAssert s1=new SoftAssert();
		HomePage homepage=new HomePage(driver);
		homepage.enteringProductNameinSearch();
		Reporter.log("Product search is successfull");
		ProductsListPage productspage=new ProductsListPage(driver);
		productspage.clickOnAddToCart();
		Reporter.log("Click on add to cart is successful");
		productspage.clickOnAddToCartInPopup();
		Reporter.log("Click on add to cart in popup is successful");
		productspage.clickOnGoToCart();
		Reporter.log("Click on go to cart is successful");
		s1.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");
		s1.assertAll();
		Reporter.log("Testcase is Pass");
	}
}
