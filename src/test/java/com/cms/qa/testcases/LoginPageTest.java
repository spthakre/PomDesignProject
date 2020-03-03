package com.cms.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cms.qa.base.BaseTest;
import com.cms.qa.pages.HomePage;
import com.cms.qa.pages.LoginPage;



public class LoginPageTest extends BaseTest {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		 loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Log In ‹ opensourcecms — WordPress");

	}

	@Test(priority = 2)
	public void WPLogoImageTest() {
		boolean flag = loginPage.validateWPImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)

	public void LoginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
