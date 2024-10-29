package practice;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyBoardActions {

	WebDriver driver = new ChromeDriver();

	@Test
	public void login ()
	
	{
		WebElement about = driver.findElement(By.xpath("//a[normalize-space()='About']"));

		Actions a=new Actions(driver);
	
		a.contextClick(about).perform();
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
	}
	@BeforeClass
	public void verify ()

	{
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	public void logout ()
	{

	}

}
