package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.CalculatorPage;



public class BaseClass {
	//reused/reusable methods
	public static WebDriver driver;
	protected CalculatorPage calcObj;
	public Logger logger;
	public Properties p;
	

	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os,String browser) throws IOException 
	{
		logger = LogManager.getLogger(this.getClass()); //for fetching TCs dynamically
		//loading config.properties file
		FileReader file = new FileReader("./src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		switch(browser.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		default: System.out.println("Invalid browser"); return; //stops execution
		}
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

    @org.testng.annotations.BeforeMethod
    public void BeforeMethod() {
    	calcObj = new CalculatorPage(driver);
    }

    @org.testng.annotations.AfterMethod
    public void AfterMethod() {
        driver.navigate().refresh();
    }
    
    
    //screenshot method,used by extentReport onTestFailure 
    public String captureScreen(String tname) throws IOException {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		

		//sourceFile.renameTo(targetFile);
		FileUtils.copyFile(sourceFile, new File(targetFilePath));
		return targetFilePath;

	}
}
