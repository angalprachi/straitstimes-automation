package website_navigation;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	static TakesScreenshot ts;

	public static WebElement waitForElement(WebDriver driver, By elmprop) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		return wait.until(ExpectedConditions.presenceOfElementLocated(elmprop));

	}

	public static String captureScreenShot(WebDriver driver) {

		ts = ((TakesScreenshot) driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destpath = System.getProperty("user.dir")
				+ "\\test-output\\screenshots\\" + System.currentTimeMillis()
				+ ".png";
		File dest = new File(destpath);
//		try {
//			// now copy the screenshot to desired location using copyFile method
//
//			//FileUtils.copyFile(src, dest);
//		}
//
//		catch (IOException e)
//
//		{
//
//			System.out.println(e.getMessage());
//
//		}

		return destpath;

	}
	
	

	public static void sleep(int sec) {

		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

