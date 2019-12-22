package com.cg.lora.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cg.lora.base.TestBase;
import com.cg.lora.util.GenericUtilities;

public class Header extends TestBase {

	@FindBy(xpath = "//div[@class='logo']")
	private WebElement headerLogo;

	@FindBy(id = "search-text")
	private WebElement searchBox;

	@FindBy(xpath = "(//div[@class = 'main-bottom-holder'])[2]")
	private WebElement sSFlyout;

	@FindBy(xpath = "//li//a[@href='login']")
	private WebElement loginLink;

	@FindBy(xpath = "(//a[@href='/compte/accountdetails'])[1]")
	private WebElement myAccLink;

	@FindBy(xpath = "//div[@class='icon-cart']")
	private WebElement miniCartIcon;

	@FindBy(xpath = "//a[@class='js-first-level-menu']")
	private WebElement rootCatLinks;

	public Header() {
		PageFactory.initElements(driver, this);
	}

//1. Verify logo is displayed.
	public boolean brandLogoDisplay() {
		boolean logoIsDisplayed = headerLogo.isDisplayed();
		return logoIsDisplayed;
	}

//2. Verify when clicked on logo user is redirected to home page.
	public String brandLogoRederict() {
		headerLogo.click();
		String url = driver.getCurrentUrl();
		return url; // url: https://www.loreal-paris.fr/
	}

//3. Verify user can search for required products by entering search word in search box.
	public String productSearch(String keyword) {
		searchBox.sendKeys(keyword);

		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='pink-text'])[2]")));

		String url = driver.getCurrentUrl();
		return url;
// Verify whether the search page URL contains "search?query="
	}

//4. Verify search suggestion flyout is displayed when searched for product.
	public boolean searchSuggestionsFlyoutDisplay(String searchWord) {
		/*
		 * verifying for search suggestion flyout for <3, 3, 3> keywords must be
		 * implemented in test class
		 */

//		String exception = "";
		searchBox.sendKeys(searchWord);
//		WebDriverWait wait = new WebDriverWait(driver, 10);

//		try {
//			wait.until(ExpectedConditions.visibilityOf(sSFlyout));
//		} catch (TimeoutException e) {
//
//			/*
//			 * By using this method, we will only get name and description of an exception.
//			 * Note that this method is overridden in Throwable class.
//			 */
//			exception = e.toString();
//		}
//		
//		if(exception != null)
//			return true;
//		else return false;

		if (sSFlyout.isDisplayed())
			return true;
		else
			return false;
	}

//	5. Verify guest user is redirected to login page when clicked on login link.
	public String guestUserClicksOnLoginLink() {
		loginLink.click();
		String url = driver.getCurrentUrl();
		return url; // url: https://www.loreal-paris.fr/login
	}

//	6. Verify registered user is navigated to My account landing page upon clicking on My account link in header.
	public String regUserClicksOnMyAccLink() {
		GenericUtilities.loginUtil();
		myAccLink.click();
		String url = driver.getCurrentUrl();
		return url; // url: https://www.loreal-paris.fr/compte/accountdetails
	}

//	7.Verify whether the user is navigated to cart/empty cart when clicked on cart icon in header.
	public String clickOnCartIcon() {
		miniCartIcon.click();
		String url = driver.getCurrentUrl();
		return url; // url: https://www.loreal-paris.fr/cart/
	}

//	8.

}
