package package1.AmazonApplication;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ListenersLogic;
import utility.RetryLogic;

//Verify that items can be added to the shopping cart from product pages.
@Listeners(ListenersLogic.class)
public class TC09_AddProductToCart extends BaseClass
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void addToCart()
	{
		Reporter.log("Browser Launched Successfully");
		SoftAssert s1=new SoftAssert();
		HomePage homepage=new HomePage(driver);
		homepage.enteringProductNameinSearch();
		Reporter.log("Search product is successful");
		ProductsListPage productspage=new ProductsListPage(driver);
		int beforeCount=productspage.getCartCount();
		productspage.clickOnAddToCart();
		Reporter.log("Click on add to cart is successful");
		productspage.clickOnAddToCartInPopup();
		Reporter.log("Click on add to cart in popup is successful");
		homepage.openCart();
		CartPage cartpage=new CartPage(driver);
		int afterCount=cartpage.getCartItemsCount();
		s1.assertNotEquals(beforeCount, afterCount);
		s1.assertAll();
		Reporter.log("TestCase is pass");
	}
}
