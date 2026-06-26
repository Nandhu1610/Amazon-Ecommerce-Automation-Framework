package package1.AmazonApplication;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	WebDriver driver;
	WebDriverWait wait;
	//step 1: Locating of each components using FindBy annotation
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	private WebElement accountAndList;
	
	@FindBy(xpath="//a[@class='nav-action-signin-button']")
	private WebElement signIn;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement signOut;
	
	@FindBy(xpath="//a[@class='nav-a']")
	private WebElement newUser;
	
	@FindBy(xpath="//span[text()='Your Account']")
	private WebElement yourAccount;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(id="nav-cart-count")
	private WebElement cartIcon;
	
	//step 2: Creating seperate methods for each components to perform actions
	public void hoveroverOnAccountsAndList(WebDriver driver)
	{
		wait.until(ExpectedConditions.visibilityOf(accountAndList));
		Actions a1=new Actions(driver);
		a1.moveToElement(accountAndList).perform();
	}
	public void clickOnSignin()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signIn));
		signIn.click();
	}
	
	public void clickOnSignout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signOut));
		signOut.click();
	}
	
	public void clickOnStartHere()
	{
		wait.until(ExpectedConditions.elementToBeClickable(newUser));
		newUser.click();
	}
	
	public void clickOnYourAccount()
	{
		wait.until(ExpectedConditions.elementToBeClickable(yourAccount));
		yourAccount.click();
	}
	
	public void enteringProductNameinSearch()
	{
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys("Mouse"+Keys.ENTER);
	}
	
	public void openCart()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
		cartIcon.click();
	}
	
	//step 3: Initialization of elements using PageFactory class inside the constructor
	public HomePage(WebDriver driver)//constructor
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
}
