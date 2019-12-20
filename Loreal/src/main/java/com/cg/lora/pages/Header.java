package com.cg.lora.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cg.lora.base.TestBase;

public class Header extends TestBase {

	@FindBy(xpath = "//div[@class='logo']")
	private WebElement headerLogo;

	@FindBy(id = "search-text")
	private WebElement searchBox;
	
	@FindBy(xpath = "(//div[@class = 'main-bottom-holder'])[2]")
	private WebElement sSFlyout;

	@FindBy(xpath = "//li//a[@href='login']")
	private WebElement loginLink;

	@FindBy(xpath = "//div[@class='icon-cart']")
	private WebElement miniCartIcon;

	@FindBy(xpath = "//a[@class='js-first-level-menu']")
	private WebElement rootCatLinks;

	public Header() {
		PageFactory.initElements(driver, this);
	}

	public boolean logoDisplay() {
		boolean logoIsDisplayed = headerLogo.isDisplayed();
		return logoIsDisplayed;
	}

	public String logoRederict() {
		headerLogo.click();
		String url = driver.getCurrentUrl();
		return url;
	}

	public String keyWordSearch(String keyword) {
		searchBox.sendKeys(keyword);

		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='pink-text'])[2]")));

		String url = driver.getCurrentUrl();
		return url;

	}
	
	public void searchSuggestions(String searchWord) {
		/*
		 * verifying for search suggestion flyout for <3, 3, 3> keywords must be implemented
		 * in test class
		 */
	}
}
