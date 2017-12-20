package test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.SplashPage;
import scenarios.AndroidSetup;

public class StraitsTest extends AndroidSetup {

	@Test
	public void testArticleHomePage() {
		// SplashPage splashPage = new SplashPage(driver);
		// splashPage.getIAgreeButton().click();
		// swipeRightToLeft();
		// splashPage.getSkipButton().click();
	//	System.out.println("Current Activity: " + driver.currentActivity().toString());
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		HomePage page = new HomePage(driver);
		assertTrue(page.getMainAriticle().isDisplayed());
	}
}
