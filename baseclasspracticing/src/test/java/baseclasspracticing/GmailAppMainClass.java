package baseclasspracticing;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class GmailAppMainClass extends GmailAppFrameworkPractice
{

	public static void main(String[] args) throws InterruptedException, AWTException, IOException
	{
		getDriver();
		loadURL("https://www.google.com/");
		
		WebElement toOpenGoogleOptions = driver.findElement(By.xpath("//a[@class='gb_D gb_zc']"));
		btnCLick(toOpenGoogleOptions);
		
		traverseOptTillGmailandEnter();
		moveToGmailLoginURL();
		
		
		
		WebElement username = driver.findElement(By.xpath("//input[@id='identifierId']"));
		sendDataToWebpageElement(username, fetchDataFromExcel(3,1));
		
		WebElement btnClickpass = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
		btnCLick(btnClickpass);
		
		FluentWait<WebDriver> wt= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		WebElement password = driver.findElement(By.name("password"));
		sendDataToWebpageElement(password, fetchDataFromExcel(4,1));
		
		
		WebElement btnClickpass2 = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
		btnCLick(btnClickpass2);
								
		
		FluentWait<WebDriver> wtt= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);
		wtt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='T-I T-I-KE L3']")));
		WebElement identifyCompose = driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']"));
		btnCLick(identifyCompose);	
		
		FluentWait<WebDriver> wttt= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);
		wttt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='to']")));
		WebElement userid = driver.findElement(By.xpath("//textarea[@name='to']"));
		sendDataToWebpageElement(userid, jsExec(userid, fetchDataFromExcel(6,1)));

		WebElement subjectpath = driver.findElement(By.xpath("//input[@name='subjectbox']"));
		sendDataToWebpageElement(subjectpath, jsExec(subjectpath, emailSubject()));

		WebElement bodypath = driver.findElement(By.xpath("//div[@role='textbox']"));
		sendDataToWebpageElement(bodypath, jsExec(bodypath, emailBody()));

		WebElement sendBtn = driver.findElement(By.xpath("(//div[@role='button'])[50]"));
		jsExecClick(sendBtn);

	    WebElement signingoffimgclk = driver.findElement(By.xpath("//img[@class='gb_La gbii']"));
		jsExecClick(signingoffimgclk);

	    WebElement signingoffbtnclk = driver.findElement(By.xpath("(//a[@Target='_top'])[5]"));
		jsExecClick(signingoffbtnclk);

		closeBrowser();
	}

}
