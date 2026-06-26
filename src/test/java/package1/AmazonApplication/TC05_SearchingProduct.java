package package1.AmazonApplication;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;
import utility.ListenersLogic;
import utility.RetryLogic;

//Test searching for products using its name like shoe
@Listeners(ListenersLogic.class)
public class TC05_SearchingProduct extends BaseClass
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void searchingProduct()
	{
		Reporter.log("Browser and URL launched Successfully");
		SoftAssert s1 = new SoftAssert();
		HomePage homepage=new HomePage(driver);
		homepage.enteringProductNameinSearch();
		Reporter.log("Product name is entered successfully");
		List<WebElement> listOfProducts=driver.findElements(By.xpath("//a[@class='a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal']"));
		s1.assertEquals(listOfProducts.size()>50, true);
		s1.assertAll();
		Reporter.log("Testcase is Pass");
	}
}
