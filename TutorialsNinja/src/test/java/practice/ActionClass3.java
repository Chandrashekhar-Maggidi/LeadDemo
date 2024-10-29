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

public class ActionClass3 {
	
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
		WebElement rightClick =driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions action = new Actions(driver);
		action.contextClick(rightClick).perform();
		
		WebElement rtClickElement = driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']"));
		System.out.println("Elements found : "+rtClickElement.getText());
		
		driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
		Alert alert=driver.switchTo().alert();
		String text =alert.getText();
		
		if(text.equals("clicked: edit"))
		{
			System.out.println("Popu opened success");
		}
		else
		{
			System.out.println("Popup closed success");
		}
		
		alert.accept();
		
		
	}
	@AfterClass
	public void logout ()
	{
		
	}
}
