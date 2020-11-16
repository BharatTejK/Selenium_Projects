package baseclasspracticing;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OtherPracticeStuffClass  
{
//	
//	
//		//This is to read and get the opened url from the browser and print on the console.
//			String url = GmailAppFrameworkPractice.getDriver().getCurrentUrl();
//			System.out.println("The URL opened in the browser is: "+url);
//		// Get title of the page
//			String title = GmailAppFrameworkPractice.getDriver().getTitle();
//			System.out.println("The Title of the webpage is: "+title);
//		//https://www.google.com/gmail/about/#
//			String url2 = driver.getCurrentUrl();
//			System.out.println("The URL opened in the browser is: "+url2);
//			js.executeScript("arguments[0].click()",signin);
//			String currWindowID = driver.getWindowHandle();
//			System.out.println(currWindowID);
//		
//			Row row = tabName.getRow(5);
//			System.out.println("First row no.: "+row);
//			
//			Cell cell = row.getCell(1);
//			System.out.println("First cell value: "+cell);
//			
//			int rowcount = tabName.getPhysicalNumberOfRows();
//			System.out.println("Row count is : "+rowcount);
//			
//			int cellcount = row.getPhysicalNumberOfCells();
//			System.out.println("Cell count is : "+cellcount);
//			
//			int type = cell.getCellType();
//			if(type == 1)
//			{
//				System.out.println("The value in the cell is of type 'String'");
//				String cellval = cell.getStringCellValue();
//				System.out.println("The value is : "+cellval);
//			}
//			else if (type == 0)
//			{
//				if (DateUtil.isCellDateFormatted(cell))
//				{
//					System.out.println("The value in the cell is of type 'Date'");
//					Date date = cell.getDateCellValue();
//					SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
//					String datecellval = sdf.format(date);
//					System.out.println("The date in the cell is : "+datecellval);		
//				}
//				else
//				{
//					System.out.println("The value in the cell is of type 'Numeric'");
//					double num = cell.getNumericCellValue();
//					long lg = (long)num;
//					String numval = String.valueOf(lg);
//					System.out.println("The numeric value in the cell is : "+numval);
//				}
//			}
//			
//			//print all data/cells from the excel saved
//			for (int i = 0; i < rowcount; i++)
//			{
//				Row allrow = tabName.getRow(i);
//				for (int j=0; j < allrow.getPhysicalNumberOfCells(); j++)
//				{
//					Cell allcell = allrow.getCell(j);
//					System.out.println(allcell);
//				}
//			}
//			
//			Thread.sleep(1000);
//			Row usernamerow = tabName.getRow(3);
//			Cell usernamevalue = usernamerow.getCell(1);
//			String UserID = String.valueOf(usernamevalue);
//			System.out.println("The userid value sent to the browser userid field is : "+UserID);
//			WebElement username = driver.findElement(By.xpath("//input[@id='identifierId']"));
//			username.sendKeys(UserID);
//			Thread.sleep(1000);
//			
//			WebElement btnClickUid = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
//			btnClickUid.click();
//			Thread.sleep(1000);
//			
//			Row passwordrow = tabName.getRow(4);
//			Cell passwordvalue = passwordrow.getCell(1);
//			String pass = String.valueOf(passwordvalue);
//			System.out.println("The password value sent to the browser password field is : "+pass);
//			WebElement password = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]"));
//			password.sendKeys(pass);
//			Thread.sleep(1000);
			
}
