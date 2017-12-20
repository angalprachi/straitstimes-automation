package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	AndroidDriver driver;
	
	public HomePage(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getMainAriticle() {
		String activity = driver.currentActivity();
		System.out.println(activity);
		return driver.findElement(By.id("com.buuuk.st:id/tv_title"));
		
		//return website_navigation.CommonUtils.waitForElement(driver,
				
	}
}
