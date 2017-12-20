package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import website_navigation.CommonUtils;

public class SplashPage {
	AndroidDriver driver;
	public SplashPage(AndroidDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getIAgreeButton() {
		return CommonUtils.waitForElement(driver, By.id("com.buuuk.st:id/btn_tnc_ok"));
	}
	
	public WebElement getSkipButton() {
		return CommonUtils.waitForElement(driver, By.id("com.buuuk.st:id/tv_skip_intro"));
	}
}
