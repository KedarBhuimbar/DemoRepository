package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastName;
	@FindBy(xpath="//input[@type='submit']")
	WebElement save;
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	public void selectContacts(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	}
	public void createNewContact(String title,String fName,String lName)
	{
		Select dropdown=new Select(driver.findElement(By.name("title")));
		dropdown.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		save.click();
	}
}
