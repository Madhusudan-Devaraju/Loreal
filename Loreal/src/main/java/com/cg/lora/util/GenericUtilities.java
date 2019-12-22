package com.cg.lora.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cg.lora.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericUtilities extends TestBase {

	public static long pageLoadTimeOut = 30;
	public static long implicitlyWait = 30;

	public static void loginUtil() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("LoginPageUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));

		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));

		driver.findElement(By.xpath("//input[@value='Me connecter']")).click();

	}
}
