package website_navigation;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**Author : Prachi Angal **/

public class NewTest {

	public WebDriver driver;
	boolean flag = false;
	Properties p = new Properties();
	String mainArticleLink = null;

	/*** 
	 * Starts he browser and navigates to url
	 */
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./libs/chromedriver");
		driver = new ChromeDriver();
		try {
			FileInputStream f = new FileInputStream("./src/configuration/config.properties");
			p.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		String url = p.getProperty("url");
		driver.get(url);
		driver.get(url);
		driver.manage().window().maximize();
		
		try {
			FileInputStream file = new FileInputStream("./src/configuration/ObjectRepository.properties");
			p.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/*** 
	 * Clicks on Login link, enters credentials on login page and signs in.
	 */
	@Test(priority = 1)
	public void login() throws InterruptedException {
		Thread.sleep(3000);
		WebElement loginlink = driver.findElement(By.xpath(p.getProperty("loginlink")));
		loginlink.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement username = driver.findElement(By.id("j_username"));
		username.sendKeys(p.getProperty("UserName"));

		WebElement password = driver.findElement(By.id("j_password"));
		password.sendKeys(p.getProperty("Password"));

		WebElement btn_signin = driver.findElement(By.xpath(p.getProperty("btn_signin")));
		btn_signin.click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		loginlink = driver.findElement(By.xpath(p.getProperty("loginlink")));
		assertTrue(loginlink.getText().contains(p.getProperty("UserName")));
	}

	/*** 
	 * Checks for picture/video on main article page and displays results
	 */
	@Test(priority = 2)
	public void verifyMainArticleHasMedia() {
		WebElement main_video = driver.findElement(By.xpath(p.getProperty("main_video")));
		assertTrue(main_video.isDisplayed());
		mainArticleLink = main_video.getAttribute("href");
		if (main_video.isDisplayed()) {
			System.out.println("The main article has a picture/video");
			Reporter.log("The main article has a picture/video. \n", true);
			flag = true;
		} else {
			System.out.println("The main article does not have a picture/video");
			Reporter.log("The main article does not have a picture/video", true);
		}
	}

	/*** 
	 * Clicks on picture/video on main article page, navigates and verifies url of same picture/video on next page
	 */
	@Test(priority = 3)
	public void verifyNavigationToMainArticle() {
		WebElement main_video = driver.findElement(By.xpath(p.getProperty("main_video")));
		main_video.click();
		assertTrue(driver.getCurrentUrl().contains(mainArticleLink));
	}
	
	/*** 
	 * Verifies picture/video is present in the main article page
	 */
	@Test(priority = 4)
	public void verifyArticlePageHasMedia() {
		if (flag == true) {
			System.out.println(
					"The page has been navigated to the main article, and the picture/video is present in the article.");
			Reporter.log(
					"The page has been navigated to the main article, and the picture/video is present in the article. \n",
					true);
		} else {
			System.out.println(
					"The page has been navigated to the main article, and the picture/video is NOT present in the article.");
			Reporter.log(
					"The page has been navigated to the main article, and the picture/video is NOT present in the article.",
					true);
		}

	}

	/*** 
	 * Closes the browser
	 */
	@AfterTest
	public void close() {
		driver.quit();
	}
}
