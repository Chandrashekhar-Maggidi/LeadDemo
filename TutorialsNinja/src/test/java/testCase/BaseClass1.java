package testCase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass1 {
	
	

	public WebDriver driver;
	public Logger logger1;
	public Properties prop;

	@BeforeClass(groups = {"sanity","smoke","DataDriven","regression", "FTP"})
	@Parameters ({"os","browser"})
	public void setup (String os, String br) throws IOException
	{
		//loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop=new Properties();
		prop.load(file);
		
		logger1=LogManager.getLogger(this.getClass());
		
		switch (br){
		case "chrome" : driver=new ChromeDriver();break;
		case "edge" : driver=new EdgeDriver();break;
		case "firefox" : driver= new FirefoxDriver();break;
		default : System.out.println("Invalid browser");return;
 		
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("masterUrl")); //Reading Url from config.properties file
	}

	@AfterClass(groups ={"sanity","smoke","DataDriven","regression", "FTP"})
	public void tearDown ()
	{
		driver.quit();
	}

	public String randomeString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

	public String randomeNumberic()
	{
		String generatednumber = RandomStringUtils.randomNumeric(5);
		return generatednumber;
	}

	public String randomeAlphaNumeric()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		String generatednumber = RandomStringUtils.randomNumeric(5);
		return (generatedstring+"@"+generatednumber);
	}

}
