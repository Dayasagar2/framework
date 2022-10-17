package com.crc.Products;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_utility;
import com.crm.Generic_Utilities.java_utilty;
import comcast.Vtiger.objectRepository.Productpage;
import comcast.Vtiger.objectRepository.homepage;

public class CreateProductstest extends BaseClass
{
	@Test
public void CreateProductsTest() throws Throwable
{
	Excel_utility exlib=new Excel_utility();
	java_utilty jlib=new java_utilty();
	
	int randnum = jlib.getRanDomNum();
	String exrandnum = exlib.getdataFromExcel("Sheet1", 0,0)+randnum;
	homepage home=new homepage(driver);
	home.clickonproduct();
	Productpage pd1= new Productpage(driver);
	pd1.Productpage(exrandnum);
	pd1.Deleteproductpage(driver);
    driver.quit();
}
}








