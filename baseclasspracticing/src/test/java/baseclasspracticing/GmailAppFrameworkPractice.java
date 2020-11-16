package baseclasspracticing;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GmailAppFrameworkPractice {


	public static WebDriver driver;
	public static JavascriptExecutor js ;
	//Configure the browser and Create object for WebDriver interface, since we cannot create object for interface we will use its child class ChromeDriver constructor.	
	public static WebDriver getDriver()
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\baseclasspracticing\\Drivers\\chromedriver.exe");
		return driver = new ChromeDriver();
		}
		
	//This method get("url"), opens the browser and opens the page of the url given.
	public static void loadURL(String url)
	{
		//driver.get("https://www.google.com/");
		driver.get(url);
		//This will maximize the window
		driver.manage().window().maximize();
	}
	
	public static void btnCLick(WebElement element)
	{
		element.click();
	}
	
	public static void traverseOptTillGmailandEnter() throws AWTException, InterruptedException
	{
		//Finding element by id from the webpage
				Thread.sleep(2000);
				Robot r = new Robot();
				for(int i=0; i<6; i++)
				{
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				if (i==5)
				{
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
				}
				}
	}

	public static void moveToGmailLoginURL() throws InterruptedException
	{
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		WebElement signin = driver.findElement(By.xpath("(//a[@class='h-c-header__nav-li-link '])[4]"));
		js.executeScript("arguments[0].click()",signin);
		
		String currWindowID = driver.getWindowHandle();
		Set<String> allWindowIDs =driver.getWindowHandles();	
		for(String eachID : allWindowIDs)
		{
			if(!currWindowID.equals(eachID))
					driver.switchTo().window(eachID);
		}
		
	}

	public static void sendDataToWebpageElement(WebElement element, String value) throws InterruptedException
	{
		element.sendKeys(value);
	}
	
	public static String fetchDataFromExcel(int RowNo, int CellNo) throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		File location= new File("C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\gmailframeworknotthere\\Resources\\SeleniumPracticeExcel.xlsx");
		FileInputStream readExcel = new FileInputStream(location);
		Workbook excelFile = new XSSFWorkbook(readExcel);
		Sheet tabName = excelFile.getSheet("Sheet1");
		Row userIDorPWDrow = tabName.getRow(RowNo);
		Cell userIDorPWDvalue = userIDorPWDrow.getCell(CellNo);
		String data = String.valueOf(userIDorPWDvalue);
		excelFile.close();
		return data;
		
	}	

	public static String jsExec(WebElement element,String value) throws InterruptedException
	{	
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()",element);
		return value;
	}
	
	public static void jsExecClick(WebElement element) throws InterruptedException
	{	
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()",element);

	}
		
	
	public static String emailSubject()
	{	
		return "Automation Testing - login to Gmail and send email(datadriven)";
	}
	
	public static String emailBody()
	{	

		StringBuffer Bodyofemail = new StringBuffer()
				.append("Hi Lalisha Mallareddy,")
				.append("\n")
				.append("Did you see my email???? This is via automated selenium script... just testing... ")
				.append("\n")
				.append("Regards")
				.append("\n")
				.append("Selenium Automation By KBT.");
		
		return Bodyofemail.toString();
	}

	public static void closeBrowser()
	{    
		//close the driver
				driver.quit();
	}
		

		

	}

	

