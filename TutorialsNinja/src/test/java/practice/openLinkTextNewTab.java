package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class openLinkTextNewTab {
	
	@Test
	public void operation () throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebElement register =driver.findElement(By.xpath("//a[normalize-space()='Software']"));
		register.isDisplayed();
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL).click(register).keyUp(Keys.CONTROL).perform();
		
		//switching to registration page
		
		List<String>ids=new ArrayList(driver.getWindowHandles());
//		List<String> idsList = new ArrayList(ids);
		ids.get(1);
		driver.switchTo().window(ids.get(1));
		
		WebElement continu =driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
		act.keyDown(Keys.CONTROL).click(continu).keyUp(Keys.CONTROL).perform();
//		List<String>ids1=new ArrayList(driver.getWindowHandles());
		Set<String>tabs=driver.getWindowHandles();
		List<String>no_tabbs=new ArrayList(tabs);
		driver.switchTo().window(no_tabbs.get(2));
		Thread.sleep(6000);
		driver.close();
		driver.switchTo().window(no_tabbs.get(1));
	}

	
}
