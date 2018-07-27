package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TestUtil testUtil;
public HomePageTest()
{
	super();
}
@BeforeMethod
public void setup()
{
	initialization();
	loginPage= new LoginPage();
	testUtil= new TestUtil();
	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
@Test(priority=1)
public void homePageTitleTest()
{
	String homepagetitle=homePage.verifyHomePageTitle();
	Assert.assertEquals(homepagetitle, "CRMPRO");
	}

@Test(priority=2)
public void verifyUserNameTest()
{
testUtil.switchToFrame();
Assert.assertTrue(homePage.verifyUserName());	
}
@Test(priority=3)
public void VerifyContactLinkTest()
{
	testUtil.switchToFrame();
	contactsPage=homePage.clickonContactsLink();
}
@Test(priority=4)
public void verifyDealsLinkTest()
{
	testUtil.switchToFrame();
	dealsPage=homePage.clickonDealsLink();
}
@AfterMethod
public void tearDown()
{
	driver.quit();
}
	
	
	
	
}
