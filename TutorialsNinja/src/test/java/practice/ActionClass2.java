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

public class ActionClass2 {
	
	WebDriver driver = new ChromeDriver();

	@BeforeClass
	public void login ()
	{
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
	}
	@Test
	public void verify ()
	{
		WebElement dblClick =driver.findElement(By.xpath("//button[normalize-space()='Double-Click Me To See Alert']"));
		
		Actions action = new Actions(driver);
		action.doubleClick(dblClick).perform();
		Alert alert=driver.switchTo().alert();
		String alertText = alert.getText();
		if(alertText.equals("You double clicked me.. Thank You.."))
		{
			System.out.println("Alert popup opened successfully");
		}
		alert.accept();
		
		
	}
	@AfterClass
	public void logout ()
	{
		
	}
}
