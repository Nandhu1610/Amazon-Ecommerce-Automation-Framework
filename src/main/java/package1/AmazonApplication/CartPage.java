package package1.AmazonApplication;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage 
{
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(id="nav-cart-count")
	private WebElement cartIcon;
	
	@FindBy(xpath="//span[@data-a-selector='increment-icon']")
	private WebElement incrementIcon;
	
	@FindBy(xpath="//span[@data-a-selector='inner-value']")
	private WebElement qtyValue;
	
	@FindBy(xpath="//span[@data-a-selector='decrement-icon']")
	private WebElement decrementIcon;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteOption;
	
	@FindBy(xpath="//span[text()=' was removed from Shopping Cart. ']")
	private WebElement deleteSuccessMessage;
	
	@FindBy(name="proceedToRetailCheckout")
	private WebElement proceedToBuyBtn;
	
	public void openCart()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
		cartIcon.click();
	}
	
	public int getCartItemsCount()
	{
		wait.until(ExpectedConditions.visibilityOf(cartIcon));
		String count=cartIcon.getText().trim();
		return Integer.parseInt(count);
	}
	
	public int getItemCount()
	{
		wait.until(ExpectedConditions.visibilityOf(qtyValue));
		String count=qtyValue.getText();
		return Integer.parseInt(count);
	}
	
	public void clickOnPlusIcon()
	{
		wait.until(ExpectedConditions.elementToBeClickable(incrementIcon));
		incrementIcon.click();
	}
	
	public void clickOnMinusIcon()
	{
		wait.until(ExpectedConditions.elementToBeClickable(decrementIcon));
		decrementIcon.click();
	}
	
	public void clickOnDelete()
	{
		wait.until(ExpectedConditions.elementToBeClickable(deleteOption));
		deleteOption.click();
	}
	
	public boolean successMessageOfDelete()
	{
		wait.until(ExpectedConditions.visibilityOf(deleteSuccessMessage));
		return deleteSuccessMessage.getText().contains("was removed from Shopping Cart.");
	}
	
	public void clickOnProceedToBuy()
	{
		wait.until(ExpectedConditions.elementToBeClickable(proceedToBuyBtn));
		proceedToBuyBtn.click();
	}
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
}
