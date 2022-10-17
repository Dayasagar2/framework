package com.crc.Contacts;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_utility;
import com.crm.Generic_Utilities.java_utilty;

import comcast.Vtiger.objectRepository.Contactspage;
import comcast.Vtiger.objectRepository.homepage;

public class Createcontactstest extends BaseClass 
{
	@Test
public  void CreatecontactsTest() throws Throwable
{

	Excel_utility exlib=new Excel_utility();
	java_utilty jlib=new java_utilty();

	homepage home=new homepage(driver);
	home.clickoncontacts();
	
	 int random = jlib.getRanDomNum();
	  String data = exlib.getdataFromExcel("Sheet1",0,0)+random;
	    
	  Contactspage org2=new Contactspage(driver);
	  org2.Contactspage(data);
	    
	  SoftAssert assert1=new SoftAssert();
	  assert1.assertEquals(false, false);
	  org2.clicksavebutton();
	  assert1.assertAll();
	    
}
}








