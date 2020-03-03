package com.cms.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cms.qa.base.BaseTest;
import com.cms.qa.pages.HomePage;
import com.cms.qa.pages.LoginPage;
import com.cms.qa.pages.PostPage;
import com.cms.qa.util.UtilTest;

public class HomePageTest extends BaseTest {
	LoginPage loginPage;
	HomePage homePage;
	UtilTest utilTest;
	PostPage postPage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		BaseTest.initialization();
		loginPage = new LoginPage();
		postPage = new PostPage();
		utilTest = new UtilTest();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void VerifyHomePageTitleTest() {
		String VerifyHomePageTitle = homePage.VerifyHomePageTitle();
		Assert.assertEquals(VerifyHomePageTitle, "Dashboard ‹ opensourcecms — WordPress",
				"home page title not matched");

	}

	@Test(priority = 2)
	public void verifyCorrectUsernameTest() {
		// utilTest.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}

	@Test(priority = 3)
	public void verifyPostLinkTest() {
		postPage = homePage.clickOnPostLink();
	}

	@AfterMethod

	public void teardown() {
		driver.quit();
	}
}
