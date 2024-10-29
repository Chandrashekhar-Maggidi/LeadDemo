package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionClass1 {
	
	WebDriver driver = new ChromeDriver();

	@BeforeClass
	public void login ()
	{
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	@Test
	public void verify ()
	{
		WebElement component =driver.findElement(By.xpath("//a[normalize-space()='Components']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(component).perform();
		driver.findElement(By.xpath("//a[normalize-space()='Printers (0)']")).click();
		
		WebElement printer =driver.findElement(By.xpath("//h2[normalize-space()='Printers']"));
		if(printer.isDisplayed())
		{
			System.out.println("Shown element");
		}
		else
		{
			System.out.println("Not shown element");
		}
	}
	@AfterClass
	public void logout ()
	{
		
	}
}
