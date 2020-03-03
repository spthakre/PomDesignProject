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

public class PostPageTest extends BaseTest {

	LoginPage loginPage;
	HomePage homePage;
	UtilTest utilTest;
	PostPage postPage;

	public PostPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		BaseTest.initialization();
		loginPage = new LoginPage();
		postPage = new PostPage();
		utilTest = new UtilTest();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		postPage = homePage.clickOnPostLink();

	}

	@Test(priority = 1)
	public void verifyPostsPageLabelTest() {
		Assert.assertTrue(postPage.verifyPostsLabel(), "posts is missing on the page");

	}

	@Test(priority = 2)
	public void verifyselectsPostsTest() throws InterruptedException {
		postPage.selectsPostsByName("Title");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
