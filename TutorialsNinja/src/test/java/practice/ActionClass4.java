package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionClass4 {
	
	WebDriver driver = new ChromeDriver();

	@BeforeClass
	public void login ()
	{
		driver.get("https://demo.guru99.com/test/image_upload/");
		driver.manage().window().maximize();
	}
	@Test
	public void verify () throws Exception
	{

	WebElement file=	driver.findElement(By.xpath("//input[@id='photoimg']"));
	file.sendKeys("C:\\Users\\LENOVO\\Downloads\\Book1.xlsx");
	
	Thread.sleep(5000);
	WebElement success = driver.findElement(By.xpath("//font[@color='black']"));
	String Text =success.getText();
	System.out.println("Text : "+Text);
	if(Text.equals("File Upload Successful"))
	{
		System.out.println("Uploaded successfully");
	}
	else
	{
		System.out.println("Uploaded failed");
	}
		
	}
	@AfterClass
	public void logout ()
	{
		
	}
}
