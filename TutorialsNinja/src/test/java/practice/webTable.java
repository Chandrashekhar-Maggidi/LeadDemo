package practice;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class webTable {
	 WebDriver driver = new ChromeDriver();
	@BeforeClass
	public  void login ()
	{
	
		driver.get("file:///C:/Users/LENOVO/Downloads/webtable.html");
	}
	
	
	@Test
	public  void countRowTest() throws IOException
	{
		int allRows =driver.findElements(By.xpath("//table//tr")).size();
		
		System.out.println("All rows in WebTable : " +allRows);
		
		
		int allCoumns=driver.findElements(By.xpath("//table//h3")).size();
		System.out.println("All columns in WebTable : " +allCoumns);
		
		
		FileInputStream file = new FileInputStream("C:\\Users\\LENOVO\\Downloads\\Book1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("sheet2");
	
		
		int allXRows=sheet.getLastRowNum()+1;
		System.out.println("total rows in xl : " +allXRows);
		
		int allXColumns =sheet.getRow(0).getLastCellNum();
		System.out.println("total column in xl : " +allXColumns);
		
		ArrayList<String> xlvalues = new ArrayList<String> ();
		
		for (int i=0; i<allXRows;i++)
		{
			for(int j=0;j<allXColumns;j++)
			{
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue() + " ");
				xlvalues.add(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
		
		ArrayList<String> tableValues = new ArrayList<String> ();
		for (int m=0; m<allRows;m++)
		{
			for(int n=0;n<allCoumns;n++)
			{
				System.out.println(sheet.getRow(m).getCell(n).getStringCellValue() + " ");
				tableValues.add(sheet.getRow(m).getCell(n).getStringCellValue());
			}
		}
		
		int total_rows_columns = allRows*allCoumns;
		for(int k=0; k<total_rows_columns;k++)
		{
			if(xlvalues.get(k).equals(tableValues.get(k)))
			{
				System.out.println(tableValues.get(k) + " maching with   "+xlvalues.get(k));
			}
			else
			{
				System.out.println(tableValues.get(k) + " not maching with   "+xlvalues.get(k));
			}
		}
		
	}
	
	
	
	@AfterClass
	public void close ()
	{
		driver.close();
	}

}
