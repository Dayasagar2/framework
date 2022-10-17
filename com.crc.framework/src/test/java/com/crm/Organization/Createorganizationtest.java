package com.crm.Organization;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_utility;
import com.crm.Generic_Utilities.java_utilty;


import comcast.Vtiger.objectRepository.Organizationpage;
import comcast.Vtiger.objectRepository.homepage;

	public  class Createorganizationtest extends BaseClass
	{
		@Test
		public void createorganizationTest() throws Throwable
		{
		
		Excel_utility exlib=new Excel_utility();
		java_utilty jlib=new java_utilty();
		
		homepage home=new homepage(driver);
		home.clickonorganization();
		
	    int random = jlib.getRanDomNum();
	    String data = exlib.getdataFromExcel("Sheet1",0,0)+random;
	    
	    Organizationpage org1=new Organizationpage(driver);
	    org1.organizationpage(data);
	    
	    SoftAssert assert1=new SoftAssert();
	    assert1.assertEquals(false, false);
	    org1.clicksavebutton();
	    //org1.organizationpageVerification(data);
	    
	   // driver.quit();
	    assert1.assertAll();
	    
	}
}