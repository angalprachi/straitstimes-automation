package scenarios;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;

public class AndroidSetup {

	protected AndroidDriver driver;
	
	@BeforeSuite
	protected void prepareAndroidForAppium() throws MalformedURLException {
        File appDir = new File("./src/test/java/resources/");
        File app = new File(appDir, "straits.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appWaitActivity", "com.*");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("newCommandTimeout", 300);
        capabilities.setCapability("noSign", true);
        driver =  new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
	
	
	public AndroidDriver getWebDriver() {
		return driver;
	}
	
	public void swipeRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.5);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
}
}
