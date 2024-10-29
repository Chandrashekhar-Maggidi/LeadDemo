package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ActionClasses {
	
	WebDriver driver = new ChromeDriver();
	@BeforeClass
	public void login ()
	{
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
	}
	@Test
	public void verify ()
	{
		WebElement drag = driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
		WebElement drop = driver.findElement(By.xpath("//p[normalize-space()='Drop here']"));
		
		Actions action=new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
		
		WebElement dropped_Text = driver.findElement(By.xpath("//p[text()='Dropped!']"));
		
		System.out.println(dropped_Text.getText());
		if(dropped_Text.isDisplayed())
		{
			System.out.println("Drag and drop successfully completed");
		}
		else
		{
			System.out.println("Drag and drop  failed");
		}
		
	}
	@AfterClass
	public void logout ()
	{
		
	}

}
