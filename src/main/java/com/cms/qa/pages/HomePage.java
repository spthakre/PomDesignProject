package com.cms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cms.qa.base.BaseTest;

public class HomePage extends BaseTest {

	@FindBy(xpath = "//span[contains(@class,'display-name')]//parent::a[@href='https:"

			+ "//s1.demo.opensourcecms.com/wordpress/wp-admin/profile.php'][text()='Howdy, ']")
	@CacheLookup
	WebElement usernameLabel;

	@FindBy(xpath = "//*[@id='menu-posts']/a/div[3]")
	WebElement postLink;

	@FindBy(xpath = "//*[@id='menu-media']/a/div[3]")
	WebElement mediaLink;

	@FindBy(xpath = "//*[@id='menu-users']/a/div[3]")
	WebElement userLink;

	@FindBy(xpath = "//*[@id='menu-users']/a/div[3]")
	WebElement addNewLink;

	// initializing the page object:
	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public String VerifyHomePageTitle() {
		return driver.getTitle();

	}

	public boolean verifyCorrectUsername() {
		usernameLabel.click();
		return usernameLabel.isDisplayed();
	}

	public PostPage clickOnPostLink() {
		postLink.click();
		return new PostPage();
	}

	public MediaPage clickOnMediaLink() {
		mediaLink.click();
		return new MediaPage();

	}

}
