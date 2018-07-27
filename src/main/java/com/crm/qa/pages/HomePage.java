package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
@FindBy(xpath="//td[contains(text(),'User: Kedar B')]")
WebElement userNameLabel;

@FindBy(xpath="//a[@title='Contacts']")
WebElement contactsLink;

@FindBy(xpath="//a[contains(text(),'Deals')]")
WebElement dealsLink;

@FindBy(xpath="//a[contains(text(),'Tasks')]")
WebElement taskLink;

@FindBy(xpath="//a[@title='New Contact']")
WebElement newContactLink;
public HomePage()
{
PageFactory.initElements(driver, this);
}

public String verifyHomePageTitle()
{
	return driver.getTitle();
}
public boolean verifyUserName()
{
	return userNameLabel.isDisplayed();
}
public ContactsPage clickonContactsLink()
{
	contactsLink.click();
	return new ContactsPage();
}
public DealsPage clickonDealsLink()
{
	dealsLink.click();
	return new DealsPage();
}
public TasksPage clickOnTasksLink()
{
	taskLink.click();
	return new TasksPage();

}
public void clickonNewContact()
{
	Actions action=new Actions(driver);
	action.moveToElement(contactsLink).perform();
	newContactLink.click();
}
}
