package package1.AmazonApplication;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountsPage 
{
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	@FindBy(xpath="//div[@data-card-identifier='SignInAndSecurity']")
	private WebElement loginandSecurity;
	
	@FindBy(id="auth-cnep-edit-name-button")
	private WebElement nameEdit;
	
	@FindBy(name="customerName")
	private WebElement updateName;
	
	@FindBy(xpath="//span[@id='cnep_1C_submit_button']")
	private WebElement saveChangesBtn;
	
	public void clickOnLoginAndSecurity()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginandSecurity));
		loginandSecurity.click();
	}
	public void editName()
	{
		wait.until(ExpectedConditions.elementToBeClickable(nameEdit));
		nameEdit.click();
	}
	
	public void updateName(WebDriver driver)
	{
		wait.until(ExpectedConditions.visibilityOf(updateName));
		Actions a1=new Actions(driver);
		a1.doubleClick(updateName).perform();
		updateName.sendKeys("Nandhini");
	}
	
	public void clickOnSaveChanges()
	{
		wait.until(ExpectedConditions.elementToBeClickable(saveChangesBtn));
		saveChangesBtn.click();
	}
	
	public MyAccountsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
