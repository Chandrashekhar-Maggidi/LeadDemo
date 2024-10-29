package practice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyBoardAction {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void verify()
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='username']"));
		username.sendKeys("Admin");

		WebElement password = driver.findElement(By.xpath("//input[@placeholder='password']"));
		password.sendKeys("admin123");
		
		Actions a= new Actions(driver);
		a.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
	}

}
