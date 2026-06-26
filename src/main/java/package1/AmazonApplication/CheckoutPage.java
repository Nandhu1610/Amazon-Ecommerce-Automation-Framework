package package1.AmazonApplication;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//a[@data-args='redirectReason=shipaddressselectChangeClicked']")
	private WebElement changeBtn;
	
	@FindBy(xpath="//div[@id='shipping-address-selection-panel-card-id']/descendant::h2")
	private WebElement selectAddressText;
	
	@FindBy(xpath="//span[@id='checkout-primary-continue-button-id']")
	private WebElement deliverToThisAddressBtn;
	
	@FindBy(xpath="//div[@id='checkout-paymentOptionPanel']/descendant::div[contains(@class,'padding-small')]")
	private List<WebElement> paymentOptions;
	
	@FindBy(xpath="//span[@id='checkout-primary-continue-button-id-announce']")
	private WebElement useThisPaymentMethod;
	
	@FindBy(xpath="//input[@value='Pay with UPI']/following::span[@id='submitOrderButtonId-announce']")
	private WebElement payWithUPIBtn;
	
	@FindBy(xpath="//div[@id='checkout-paymentOptionPanel']/descendant::input[@type='radio']")
	private List<WebElement> selectingPaymentOptions;
	
	public void clickOnChangeForAddress()
	{
		wait.until(ExpectedConditions.elementToBeClickable(changeBtn));
		changeBtn.click();
	}
	
	public String getVisibleTextOfSelectAddress()
	{
		wait.until(ExpectedConditions.visibilityOf(selectAddressText));
		return selectAddressText.getText();
	}
	
	public void clickOnDeliverToThisAddress()
	{
		wait.until(ExpectedConditions.visibilityOf(deliverToThisAddressBtn));
		deliverToThisAddressBtn.click();
	}
	
	public void clickOnPaymentMethodOptions(String paymentMethod)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(paymentOptions));
		for(WebElement eachPaymentOption:paymentOptions)
		{
			if(eachPaymentOption.isDisplayed()&&eachPaymentOption.isEnabled())
			{
				String text=eachPaymentOption.getText();
				System.out.println("Found payment option: " + text);
				//wait.until(ExpectedConditions.elementToBeClickable(eachPaymentOption));
				if(text.equalsIgnoreCase(paymentMethod))
				{
					wait.until(ExpectedConditions.elementToBeClickable(eachPaymentOption));
					eachPaymentOption.click();
					return;
				}
			}
			else
			{
				throw new RuntimeException("Payment Method "+paymentMethod+" is not available");
			}
		}
	}
	
	public void clickOnUseThisPaymentMethod()
	{
		wait.until(ExpectedConditions.elementToBeClickable(useThisPaymentMethod));
		useThisPaymentMethod.click();
	}
	
	public boolean visibilityOfPayWithUpiBtn()
	{
		wait.until(ExpectedConditions.visibilityOf(payWithUPIBtn));
		return true;
	}
	
	public int verifyAllPaymentMethodsAreSelectable()
	{
		int paymentMethodCount=0;
		wait.until(ExpectedConditions.visibilityOfAllElements(selectingPaymentOptions));
		for(WebElement eachPaymentMethod : selectingPaymentOptions)
        {
			wait.until(ExpectedConditions.elementToBeClickable(eachPaymentMethod));
        	eachPaymentMethod.click();
        	if(eachPaymentMethod.isSelected())
        	{
        		System.out.println("Selected Successfully");
        		paymentMethodCount++;
        	}
        	else
        	{
        		System.out.println("Selection Failed");
        	}
        }
		return paymentMethodCount;
	}
	public int getPaymentOptionsCount()
	{
	    return selectingPaymentOptions.size();
	}
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
}
