package com.crm.qa.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
 LoginPage loginPage;
 HomePage homePage;
public LoginPageTest()
{
super();
}	
@BeforeMethod
public void setup()
{
	initialization();
	loginPage= new LoginPage();
	}
@Test(priority=1)
public void loginPageTitleTest()
{
	String pageName=loginPage.validatePageTitle();
	Assert.assertTrue(pageName.contains("Free CRM software in the cloud powers"));
}
@Test(priority=2)
public void crmImageTest()
{
	boolean im=loginPage.validateCRMImage();
	Assert.assertTrue(im);
}
@Test(priority=3)
public void loginTest()
{
	homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	
}
@AfterMethod
public void tearDown()
{
	driver.quit();
}
	
	
}
