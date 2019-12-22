package com.cg.lora.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cg.lora.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "email")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement pwd;

	@FindBy(xpath = "//a[@class='password-link']")
	private WebElement forgotPWD;

	@FindBy(xpath = "//input[@value='Me connecter']")
	private WebElement loginSubmitBtn;

	@FindBy(xpath = "//a[text()= 'Je m’inscris']")
	private WebElement signUpBtn;

}
