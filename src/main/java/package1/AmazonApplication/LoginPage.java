package package1.AmazonApplication;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	WebDriver driver;
	WebDriverWait wait;
	//step 1: Locating of each components using FindBy annotation
	@FindBy(name="email")
	private WebElement username;
	
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement proceedToCreateAccount;
	
	@FindBy(xpath="//input[@id='ap_phone_number']")
	private WebElement mobileNo;
	
	@FindBy(id="ap_customer_name")
	private WebElement customerName;
	
	@FindBy(id="continue")
	private WebElement verifyMobileNo;
	
	@FindBy(id="ra-sign-in-link")
	private WebElement signinInstead;
	
	//Alert Messages WebElements
	@FindBy(xpath="//div[@class='a-box-inner a-alert-container']/h4[text()='There was a problem']")
	private WebElement incorrectPwdErrorMessage;
	
	@FindBy(id="invalid-email-alert")
	private WebElement invalidEmailAddress;
	
	//step 2: Creating seperate methods for each components to perform actions
	public void enteringUsername(String user)
	{
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(user);
	}
	public void clickOnContinue()
	{
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		continueBtn.click();
	}
	public void enteringPassword(String pass)
	{
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
	}
	public void clickOnSubmit()
	{
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
	}
	public void clickOnProceedToCreateAcc()
	{
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCreateAccount));
		proceedToCreateAccount.click();
	}
	
	public void enteringMobileNo()
	{
		wait.until(ExpectedConditions.visibilityOf(mobileNo));
		mobileNo.sendKeys("8248269536");
	}
	
	public void enteringCustomerName()
	{
		wait.until(ExpectedConditions.visibilityOf(customerName));
		customerName.sendKeys("Nandhini");
	}
	
	public void clickOnVerifyBtn()
	{
		wait.until(ExpectedConditions.visibilityOf(verifyMobileNo));
		verifyMobileNo.click();
	}
	
	public void clickOnSigninInstead()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signinInstead));
		signinInstead.click();
	}
	
	public String incorrectPwderrorMessage()
	{
		return incorrectPwdErrorMessage.getText();
	}
	
	public String invalidEmailerrorMessage()
	{
		return invalidEmailAddress.getText();
	}
	
	//step 3: Initialization of elements using PageFactory class inside the constructor
	public LoginPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);	
	}
}
