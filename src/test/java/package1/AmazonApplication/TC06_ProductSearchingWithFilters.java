package package1.AmazonApplication;

import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ListenersLogic;
import utility.RetryLogic;

//Verify that searching with filters (e.g., category, price range) yields accurate results.
@Listeners(ListenersLogic.class)
public class TC06_ProductSearchingWithFilters extends BaseClass
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void searchProductWithFilters()
	{
		Reporter.log("Browser Launched Successfully");
		SoftAssert s1=new SoftAssert();
		HomePage homepage=new HomePage(driver);
		homepage.enteringProductNameinSearch();
		Reporter.log("Product name is entered successfully");
		ProductsListPage productspage=new ProductsListPage(driver);
		int countofProducts=productspage.countOfProducts();
		s1.assertEquals(countofProducts>50, true);
		productspage.selectingFilters();
		/*
		productspage.filterByBrands();
		Reporter.log("Selected the brands from filter");
		productspage.filterBySize();
		Reporter.log("Selected the size from filter");
		productspage.filterByPrice();
		*/
		Reporter.log("Selected the price from filter");
		int countOfFilteredProducts=productspage.countOfProducts();
		s1.assertEquals(countOfFilteredProducts<countofProducts, true);
		List<String> products=productspage.getFilteredProductName();
		for(String product:products)
		{
			s1.assertTrue(product.toLowerCase().contains("puma"), "Puma product not found");
		}
		s1.assertAll();
		Reporter.log("Testcase is pass");
	}
}
