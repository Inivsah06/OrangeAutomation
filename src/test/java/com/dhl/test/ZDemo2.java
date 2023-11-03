package com.dhl.test;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZDemo2 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file= new FileInputStream("test_data/OrangeData.xlsx");
		
		@SuppressWarnings("resource")
		XSSFWorkbook book= new XSSFWorkbook(file);
		
		XSSFSheet sheet= book.getSheet("invalidLoginTest");
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] data=new String[rowCount-1][colCount];
		
		DataFormatter format=new DataFormatter();
		
		for(int r=1;r<rowCount;r++)
		{
			for(int c=0;c<colCount;c++)
			{
				data[r-1][c]=format.formatCellValue(sheet.getRow(r).getCell(c));
			}
		}
		
		//String cellValue = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(data);

	}

}
