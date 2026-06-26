package package1.AmazonApplication;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ListenersLogic;
import utility.RetryLogic;

//Check if products can be sorted by relevance, price, rating, etc.
@Listeners(ListenersLogic.class)
public class TC08_SortingProducts extends BaseClass
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void sortTheProducts()
	{
		Reporter.log("Browser Launched Successfully");
		SoftAssert s1=new SoftAssert();
		HomePage homepage=new HomePage(driver);
		homepage.enteringProductNameinSearch();
		Reporter.log("Product name is searched successfully");
		ProductsListPage productspage=new ProductsListPage(driver);
		productspage.sortByDropdown("Price: Low to High");
		Reporter.log("Click on sort by option is successful");
		String actualOption=productspage.getSelectedSortOption();
		s1.assertTrue(actualOption.contains("Price: Low to High"),"Option not found");
		Reporter.log("TestCase is Pass");
		s1.assertAll();
	}
}
