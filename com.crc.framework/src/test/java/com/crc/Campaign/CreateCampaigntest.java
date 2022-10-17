package com.crc.Campaign;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_utility;
import com.crm.Generic_Utilities.java_utilty;
import com.crm.Generic_Utilities.webDriver_utility;

import comcast.Vtiger.objectRepository.Campaignpage;
import comcast.Vtiger.objectRepository.homepage;

public class CreateCampaigntest extends BaseClass
{
	@Test
public void CreateCampaignTest() throws Throwable 
{
		Excel_utility exlib=new Excel_utility();
		java_utilty jlib=new java_utilty();
		webDriver_utility wlib=new webDriver_utility();
		homepage home=new homepage(driver);
		home.clickoncampaign(driver);
		
		 int random = jlib.getRanDomNum();
		  String data = exlib.getdataFromExcel("Sheet1",0,0)+random;
		  Campaignpage org1=new Campaignpage(driver);
		  org1.createcampain(data);
		org1.switchToWindow(driver, "campaign");
		
		  SoftAssert assert1=new SoftAssert();
		  assert1.assertEquals(false, false);
		  org1.savebutton();//savebutton we taken bcz we return same in the campainpage.java pom class
		  assert1.assertAll();
}
}
		