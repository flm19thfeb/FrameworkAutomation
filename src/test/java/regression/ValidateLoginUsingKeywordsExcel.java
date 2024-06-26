package regression;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class ValidateLoginUsingKeywordsExcel extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void validateLoginTest(HashMap<String, String> dataMap)
	{
		ApplicationKeywords app=new ApplicationKeywords();
		
		app.openBrowser();
		
		app.launchApp();
		
		app.type("username_textbox", dataMap.get("username"));
		
		app.type("password_textbox", dataMap.get("password"));
		
		app.click("login_button");
		
		app.validateTitle(dataMap.get("expTitle"));
		
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-101");
		
		return data;
	}

}
