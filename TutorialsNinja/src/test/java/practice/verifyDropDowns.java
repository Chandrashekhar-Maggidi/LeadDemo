package practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class verifyDropDowns {

	WebDriver driver = new ChromeDriver();

	@BeforeClass
	public void login ()
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void close() 
	{

	}

	@Test
	public  void verify() throws IOException  {
		// Finding web elements:
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='username']"));
		username.clear();
		username.sendKeys("Admin");

		WebElement password = driver.findElement(By.xpath("//input[@placeholder='password']"));
		password.clear();
		password.sendKeys("admin123");

		WebElement login = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		login.click();

		driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();

		WebElement configuration = driver.findElement(By.xpath("//span[normalize-space()='Configuration']"));

		if(configuration.isDisplayed())
		{
			configuration.click();
		}
		List<WebElement>Config_Dropdowns=  configuration.findElements(By.xpath("//ul[@class=\"oxd-dropdown-menu\"]/li"));

		System.out.println("Size of  elements under configuration drop down :" +Config_Dropdowns.size());

		FileInputStream fs = new FileInputStream("C:\\Users\\LENOVO\\Downloads\\Book1.xlsx");   // (1)
		XSSFWorkbook wb = new XSSFWorkbook(fs);           // (2)
		XSSFSheet sheet = wb.getSheet("Sheet1");    // (3)
		int totl_xlrows = sheet.getLastRowNum()+1;

		System.out.println("Excel rows  : " +totl_xlrows);


		//Reading xl values into eclipse
		ArrayList<String> xlvalues = new ArrayList<String>();
		// ArrayList xlvalues = new ArrayList

		for (int i=0; i<totl_xlrows;i++)
		{
			xlvalues.add(sheet.getRow(i).getCell(0).getStringCellValue());
		}

		ArrayList<String> ddvalues = new ArrayList<String>();

		for(int j=0; j<Config_Dropdowns.size();j++)
		{
			ddvalues.add(Config_Dropdowns.get(j).getText());
		}


		if(totl_xlrows==Config_Dropdowns.size())
		{
			for (int k=0; k<totl_xlrows;k++)
			{
				for(int l=0; l<Config_Dropdowns.size();l++)
				{
					if(xlvalues.get(k).equals((ddvalues.get(l))))
					{
						System.out.println("matching each values: " +xlvalues.get(k));

						break;

					}
				}
			}
		}
		else
		{
			System.out.println("Not matched all values");	
			
		}
		
	}

}

