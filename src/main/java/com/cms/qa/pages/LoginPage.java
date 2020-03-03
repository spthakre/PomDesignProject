package com.cms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cms.qa.base.BaseTest;

public class LoginPage extends BaseTest {

	// PageFactory or ObjectRepo

	@FindBy(id = "user_login")
	WebElement username;

	@FindBy(id = "user_pass")
	WebElement password;

	@FindBy(id = "wp-submit")
	WebElement loginBtn;

	@FindBy(xpath = "//a[text()='Powered by WordPress']")
	WebElement WPLogo;

	// initializing the page object:
	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	// Action:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateWPImage() {
		return WPLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		return new HomePage();
	}
}
