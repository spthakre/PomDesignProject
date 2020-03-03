package com.cms.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cms.qa.base.BaseTest;

public class PostPage extends BaseTest {

	@FindBy(xpath = "//*[@id='wpbody-content']/div[5]/h1")
	WebElement postsLabel;

	@FindBy(id = "post-title-0")
	WebElement addTitle;

	// initializing the page object:
	public PostPage() {

		PageFactory.initElements(driver, this);

	}

	public boolean verifyPostsLabel() {
		return postsLabel.isDisplayed();
	}

	public void selectsPostsByName(String name) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='cb-select-all-2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("doaction2")).click();
	}
	/*
	 * public void createNewPost(String normal){ Select select = new
	 * Select(driver.findElement(By.xpath("//button[@type='button']"));
	 * select.selectByvisibleText(normal);
	 */
}
