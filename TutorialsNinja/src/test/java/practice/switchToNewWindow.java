package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class switchToNewWindow {
	
	@Test
	public void operation()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
//		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://www.instagram.com/accounts/login/");
		driver.manage().window().maximize();
		
		Set<String> windows =driver.getWindowHandles();
		List<String>windowsNu=new ArrayList(windows);
		
		System.out.println("Size : "+windows.size());
		
		driver.switchTo().window(windowsNu.get(0));
		WebElement forgot = driver.findElement(By.xpath("//a[normalize-space()='Forgotten password?']"));
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL).click(forgot).keyUp(Keys.CONTROL).perform();
		Set<String> multi = driver.getWindowHandles();
		List<String> multiple=new ArrayList(multi);
		System.out.println("Size1 : "+multi.size());
		driver.switchTo().window(multiple.get(1));
		
		
	}

}
