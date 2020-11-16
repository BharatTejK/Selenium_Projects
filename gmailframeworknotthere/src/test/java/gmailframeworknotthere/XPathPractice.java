package gmailframeworknotthere;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
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


public class XPathPractice {

	public static void main(String[] args) throws InterruptedException, AWTException
	{
		try {
//Configure the browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\gmailframeworknotthere\\Drivers\\chromedriver.exe");
//Create object for WebDriver interface, since we cannot create object for interface we will use its child class ChromeDriver constructor.
		WebDriver driver = new ChromeDriver();
//This method get("url"), opens the browser and opens the page of the url given.
		driver.get("https://www.google.com/");
//This will maximize the window
		driver.manage().window().maximize();
//This is to read and get the opened url from the browser and print on the console.
		String url = driver.getCurrentUrl();
		System.out.println("The URL opened in the browser is: "+url);
// Get title of the page
		String title = driver.getTitle();
		System.out.println("The Title of the webpage is: "+title);
//Finding element by id from the webpage
		WebElement toOpenGmail = driver.findElement(By.xpath("//a[@class='gb_D gb_zc']"));
//		Actions a = new Actions(driver);
		toOpenGmail.click();
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
		//https://www.google.com/gmail/about/#
		String url2 = driver.getCurrentUrl();
		System.out.println("The URL opened in the browser is: "+url2);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement signin = driver.findElement(By.xpath("(//a[@class='h-c-header__nav-li-link '])[4]"));
		js.executeScript("arguments[0].click()",signin);
		
		String currWindowID = driver.getWindowHandle();
		System.out.println(currWindowID);
				
		Set<String> allWindowIDs =driver.getWindowHandles();
		System.out.println(allWindowIDs);
		
		for(String eachID : allWindowIDs)
		{
			if(!currWindowID.equals(eachID))
					driver.switchTo().window(eachID);
		}
		

		
		File location= new File("C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\SeleniumPractice\\Resources\\SeleniumPracticeExcel.xlsx");
		FileInputStream readExcel = new FileInputStream(location);
		
		Workbook excelFile = new XSSFWorkbook(readExcel);
		
		Sheet tabName = excelFile.getSheet("Sheet1");
		
		Row row = tabName.getRow(5);
		System.out.println("First row no.: "+row);
		
		Cell cell = row.getCell(1);
		System.out.println("First cell value: "+cell);
		
		int rowcount = tabName.getPhysicalNumberOfRows();
		System.out.println("Row count is : "+rowcount);
		
		int cellcount = row.getPhysicalNumberOfCells();
		System.out.println("Cell count is : "+cellcount);
		
		int type = cell.getCellType();
		if(type == 1)
		{
			System.out.println("The value in the cell is of type 'String'");
			String cellval = cell.getStringCellValue();
			System.out.println("The value is : "+cellval);
		}
		else if (type == 0)
		{
			if (DateUtil.isCellDateFormatted(cell))
			{
				System.out.println("The value in the cell is of type 'Date'");
				Date date = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
				String datecellval = sdf.format(date);
				System.out.println("The date in the cell is : "+datecellval);		
			}
			else
			{
				System.out.println("The value in the cell is of type 'Numeric'");
				double num = cell.getNumericCellValue();
				long lg = (long)num;
				String numval = String.valueOf(lg);
				System.out.println("The numeric value in the cell is : "+numval);
			}
		}
		
		//print all data/cells from the excel saved
		for (int i = 0; i < rowcount; i++)
		{
			Row allrow = tabName.getRow(i);
			for (int j=0; j < allrow.getPhysicalNumberOfCells(); j++)
			{
				Cell allcell = allrow.getCell(j);
				System.out.println(allcell);
			}
		}
		
		Thread.sleep(1000);
		Row usernamerow = tabName.getRow(3);
		Cell usernamevalue = usernamerow.getCell(1);
		String UserID = String.valueOf(usernamevalue);
		System.out.println("The userid value sent to the browser userid field is : "+UserID);
		WebElement username = driver.findElement(By.xpath("//input[@id='identifierId']"));
		username.sendKeys(UserID);
		Thread.sleep(1000);
		
		WebElement btnClickUid = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
		btnClickUid.click();
		Thread.sleep(1000);
		
		Row passwordrow = tabName.getRow(4);
		Cell passwordvalue = passwordrow.getCell(1);
		String pass = String.valueOf(passwordvalue);
		System.out.println("The password value sent to the browser password field is : "+pass);
		WebElement password = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]"));
		password.sendKeys(pass);
		Thread.sleep(1000);

		WebElement btnClickpass = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
		btnClickpass.click();
		Thread.sleep(5000);
		
		
		WebElement identifyCompose = driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']"));
		identifyCompose.click();
		Thread.sleep(2000);

		
		Row usernameto = tabName.getRow(6);
		Cell usernametovalue = usernameto.getCell(1);
		String toUserID = String.valueOf(usernametovalue);
		System.out.println("The userid value sent to the browser userid field is : "+toUserID);
		WebElement userid = driver.findElement(By.xpath("//textarea[@name='to']"));
		js.executeScript("arguments[0].click()",userid);
		userid.sendKeys(toUserID);
		Thread.sleep(1000);
		
		WebElement subjectpath = driver.findElement(By.xpath("//input[@name='subjectbox']"));
	    js.executeScript("arguments[0].click()",subjectpath);
	    subjectpath.sendKeys("Automation Testing - login to Gmail and send email(datadriven)");
	    Thread.sleep(1000);
		

		StringBuffer Bodyofemail = new StringBuffer()
				.append("Hi Lalisha Mallareddy,")
				.append("\n")
				.append("Did you see my email???? This is via automated selenium script... just testing... ")
				.append("\n")
				.append("Regards")
				.append("\n")
				.append("Selenium Automation By KBT.");
		WebElement bodypath = driver.findElement(By.xpath("//div[@role='textbox']"));
	    js.executeScript("arguments[0].click()",bodypath);
	    bodypath.sendKeys(Bodyofemail);
	    Thread.sleep(2000);
	    
		WebElement sendBtn = driver.findElement(By.xpath("(//div[@role='button'])[50]"));
	    js.executeScript("arguments[0].click()",sendBtn);
	    Thread.sleep(3000);
	    
	    WebElement signingoffimgclk = driver.findElement(By.xpath("//img[@class='gb_La gbii']"));
	    js.executeScript("arguments[0].click()",signingoffimgclk);
	    Thread.sleep(1000);

	    WebElement signingoffbtnclk = driver.findElement(By.xpath("(//a[@Target='_top'])[5]"));
	    js.executeScript("arguments[0].click()",signingoffbtnclk);

		Thread.sleep(5000);
		
//close the driver
		driver.quit();
		
		}catch(Exception e)
		{
			System.out.println("Exception encountered is: "+e);
		}
	}
}
