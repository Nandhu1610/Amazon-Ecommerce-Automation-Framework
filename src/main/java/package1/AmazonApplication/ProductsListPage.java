package package1.AmazonApplication;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsListPage 
{
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//div[@id='brandsRefinements']/descendant::span[text()='PUMA']/preceding-sibling::div/label/i")
	private WebElement brandsFilter;
	
	@FindBy(xpath="((//div[@id='sizeRefinements']/ul)[1]/descendant::button)[2]")
	private WebElement sizeFilter;
	
	@FindBy(xpath="((//div[@id='priceRefinements']/child::ul)[1]/span/span)[1]")
	private WebElement priceFilter;
	
	@FindBy(xpath="//a[@class='a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal']")
	private List<WebElement> allProducts;
	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base']")
	private List<WebElement> filteredProductsName;
	
	@FindBy(xpath="//span[@class='a-dropdown-container']/span")
	private WebElement sortByDropdown;
	
	@FindBy(xpath="//div[@class='a-popover-wrapper']/descendant::li")
	private List<WebElement> sortByOptions;
	
	@FindBy(xpath="(//button[text()='Add to cart'])[1]")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="(//div[@class='a-popover-wrapper']/descendant::div[@role='listitem']/descendant::button[@aria-label='Add to cart'])[1]")
	private WebElement addToCartBtnInPopup;
	
	@FindBy(id="nav-cart-count")
	private WebElement countOfCartItems;
	
	@FindBy(xpath="//a[@id='nav-cart']/child::div[@id='nav-cart-text-container']")
	private WebElement cartIcon;
	
	@FindBy(xpath="//span[@class='a-button a-button-span11 a-button-base a-button-small']")
	private WebElement goToCartBtn;
	
	public void selectingFilters()
	{
		wait.until(ExpectedConditions.elementToBeClickable(brandsFilter));
		brandsFilter.click();
		wait.until(ExpectedConditions.elementToBeClickable(sizeFilter));
		sizeFilter.click();
		wait.until(ExpectedConditions.elementToBeClickable(priceFilter));
		priceFilter.click();
	}
	/*
	public void filterByBrands()
	{
		wait.until(ExpectedConditions.elementToBeClickable(brandsFilter));
		brandsFilter.click();
	}
	
	public void filterBySize()
	{
		wait.until(ExpectedConditions.elementToBeClickable(sizeFilter));
		sizeFilter.click();
	}
	
	public void filterByPrice()
	{
		wait.until(ExpectedConditions.elementToBeClickable(priceFilter));
		priceFilter.click();
	}
	*/

	//Clicking on fist product from the list of products
	public void listOfProducts()
	{
		//wait.until(ExpectedConditions.visibilityOfAllElements(allProducts));
		if(!allProducts.isEmpty())
		{
			WebElement firstProduct=allProducts.get(0);
			wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
			firstProduct.click();
		}
		else
		{
			throw new RuntimeException("No products found");
		}
	}
	
	//Getting the count of products showing in the products list page
	public int countOfProducts()
	{
		return allProducts.size();
	}
	
	public List<String> getFilteredProductName()
	{
		List<String> productNames=new ArrayList<String>();
		for(WebElement productName:filteredProductsName)
		{
			productNames.add(productName.getText().trim());
		}
		return productNames;
	}
	//Clicking on SortBy option from Dropdown
	public void sortByDropdown(String optionText)
	{
		wait.until(ExpectedConditions.elementToBeClickable(sortByDropdown));
		sortByDropdown.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(sortByOptions));
		boolean optionFound=false;
		for(WebElement option:sortByOptions)
		{
			if(option.getText().trim().contains(optionText))
			{
				option.click();
				optionFound=true;
				break;
			}	
		}
		if(!optionFound)
		{
			throw new RuntimeException("Sort option not found: "+optionText);
		}
	}
	
	//Getting all the option from SortBy Dropdown
	public String getSelectedSortOption()
	{
		return sortByDropdown.getText();
	}
	
	public void clickOnAddToCart()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
		addToCartBtn.click();
	}
	
	public void clickOnAddToCartInPopup()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtnInPopup));
		addToCartBtnInPopup.click();
	}
	
	public void openCart()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
		cartIcon.click();
	}
	public int getCartCount()
	{
		String count=countOfCartItems.getText();
		if(count.isEmpty())
		{
			return 0;
		}
		wait.until(ExpectedConditions.visibilityOf(countOfCartItems));
		return Integer.parseInt(count);
	}
	
	public void clickOnGoToCart()
	{
		wait.until(ExpectedConditions.elementToBeClickable(goToCartBtn));
		goToCartBtn.click();
	}
	
	public ProductsListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
}
