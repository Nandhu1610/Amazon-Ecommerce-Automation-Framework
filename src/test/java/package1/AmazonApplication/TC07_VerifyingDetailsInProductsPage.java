package package1.AmazonApplication;

import java.util.Set;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ListenersLogic;
import utility.RetryLogic;

//Ensure that the product detail page displays all necessary information (price, reviews, description).
@Listeners(ListenersLogic.class)
public class TC07_VerifyingDetailsInProductsPage extends BaseClass
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void verifyingInfoProductsDetailsPage()
	{
		Reporter.log("Browser Launched Successfully");
		//SoftAssert s1=new SoftAssert();
		HomePage homepage=new HomePage(driver);
		homepage.enteringProductNameinSearch();
		Reporter.log("Product name is searched successfully");
		ProductsListPage productspage=new ProductsListPage(driver);
		productspage.listOfProducts();
		Reporter.log("Clicked on first product is successful");
		String parentWindow=driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		boolean childFound=false;
		for(String childWindow : allWindows)
		{
			if(!childWindow.equals(parentWindow))
			{
				driver.switchTo().window(childWindow);
				Reporter.log("Control is moved from parent to child window");
				childFound=true;
				break;
			}
		}
		if (!childFound)
		{
            throw new RuntimeException("Child window not found");
        }
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		pdp.verifyProductDetailsPage();
		//s1.assertAll();
		Reporter.log("TestCase is Pass");
	}
}
