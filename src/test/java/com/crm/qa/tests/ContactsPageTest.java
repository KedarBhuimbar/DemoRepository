package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TestUtil testUtil;
	
public ContactsPageTest()
{
	super();
}
@BeforeMethod
public void setup()
{
	initialization();
	loginPage= new LoginPage();
	testUtil=new TestUtil();
	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	testUtil.switchToFrame();
	contactsPage=homePage.clickonContactsLink();
}
@Test(priority=1)
public void verifyContactsLabelTest()
{
	Assert.assertTrue(contactsPage.verifyContactsLabel());
}
@Test(priority=2)
public void selectContactsTest()
{
	contactsPage.selectContacts("pradnyawant Y");
}
@Test(priority=3,dataProvider="exceldata")
public void creteContactTest(String title,String fName,String lName)
{	homePage.clickonNewContact();
	contactsPage.createNewContact(title, fName, lName);
	}
@DataProvider(name="exceldata")
public Object[][] testdata()
{
	testUtil= new TestUtil("C:\\Users\\Kedar\\Desktop\\TestData_FreeCRM.xlsx");
	int rowcount=testUtil.GetRowCount("Sheet1");
	Object[][] data=new Object[rowcount][3];
	
	for(int i=1;i<rowcount;i++)
	{
		data[i][0]=testUtil.GetData("Sheet1", i, 0);
		data[i][1]=testUtil.GetData("Sheet1", i, 1);
		data[i][2]=testUtil.GetData("Sheet1", i, 2);
	}
	
	return data;
	
	}
@AfterMethod
public void tearDown()
{
	driver.quit();
}

}		
