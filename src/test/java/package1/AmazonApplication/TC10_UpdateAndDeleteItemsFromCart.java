package package1.AmazonApplication;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ListenersLogic;
import utility.RetryLogic;

//Test updating item quantities and removing items from the cart.
@Listeners(ListenersLogic.class)
public class TC10_UpdateAndDeleteItemsFromCart extends BaseClass 
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void updatingCart()
	{
		Reporter.log("Browser Launched Successfully");
		SoftAssert s1=new SoftAssert();
		HomePage homepage=new HomePage(driver);
		homepage.enteringProductNameinSearch();
		Reporter.log("Product search is successful");
		ProductsListPage productspage=new ProductsListPage(driver);
		productspage.clickOnAddToCart();
		Reporter.log("Click on Add to cart is successful");
		productspage.clickOnAddToCartInPopup();
		Reporter.log("Click on Add to cart in popup is successful");
		homepage.openCart();
		Reporter.log("Click on cart icon is successfull");
		CartPage cartpage=new CartPage(driver);
		int beforeUpdate=cartpage.getItemCount();
		cartpage.clickOnPlusIcon();
		Reporter.log("Click on Increment item is successful");
		int afterUpdate=cartpage.getItemCount();
		s1.assertNotEquals(beforeUpdate, afterUpdate);
		Reporter.log("Item update is successful");
		cartpage.clickOnDelete();
		Reporter.log("Click on delete option is successful");
		boolean deleteMessage=cartpage.successMessageOfDelete();
		s1.assertTrue(deleteMessage, "Remove item failed");
		s1.assertAll();
		Reporter.log("TestCase is Pass");
	}
}
