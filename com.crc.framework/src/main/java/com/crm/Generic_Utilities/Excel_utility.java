package com.crm.Generic_Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {	
public String getdataFromExcel(String sheetname,int RowNum,int cellNum) throws Throwable
	{
		FileInputStream fis1 = new FileInputStream("./readData.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet(sheetname);
		Row row = sh.getRow(RowNum);
		    Cell cel = row.getCell(cellNum);
		    String data = cel.getStringCellValue();
		    return data;
	}
}