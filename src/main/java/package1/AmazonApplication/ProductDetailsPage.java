package package1.AmazonApplication;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductDetailsPage 
{
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	@FindBy(xpath="//div[@class='a-section apex-core-price-identifier']")
	private WebElement price;
	
	@FindBy(xpath = "//div[@id='customerReviews']")
	private WebElement customerRatings;
	
	@FindBy(xpath="//div[@id='detailBulletsWrapper_feature_div']")
	private WebElement productDescription;
	
	public void verifyProductDetailsPage()
	{
		wait.until(ExpectedConditions.visibilityOf(price));
		wait.until(ExpectedConditions.visibilityOf(customerRatings));
		wait.until(ExpectedConditions.visibilityOf(productDescription));
		
		Assert.assertTrue(price.isDisplayed(), "Price is not present");
		Assert.assertTrue(customerRatings.isDisplayed(), "Customer Ratings are not available");
		Assert.assertTrue(productDescription.isDisplayed(),"Product description is not available");
	}
	/*
	public void productPrice()
	{
		wait.until(ExpectedConditions.visibilityOf(price));
		Assert.assertTrue(price.isDisplayed(), "Price is not present");
	}
	
	public void productReviews()
	{
		wait.until(ExpectedConditions.visibilityOf(customerRatings));
		Assert.assertTrue(customerRatings.isDisplayed(), "Customer Ratings are not available");
	}
	
	public void productDetails()
	{
		wait.until(ExpectedConditions.visibilityOf(productDescription));
		Assert.assertTrue(productDescription.isDisplayed(),"Product description is not available");
	}
	*/
	public ProductDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
