package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeaftapsHAday1CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver(); 
		 driver.get("http://leaftaps.com/opentaps/");
		 driver.manage().window().maximize();
		 driver.findElement(By.id("username")).sendKeys("democsr");
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		 driver.findElement(By.className("decorativeSubmit")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.partialLinkText("CRM/SFA")).click();
		 driver.findElement(By.linkText("Accounts")).click();
		 driver.findElement(By.linkText("Create Account")).click();
		 driver.findElement(By.id("accountName")).sendKeys("Deva02");
		 driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		 driver.findElement(By.id("numberEmployees")).sendKeys("5");
		 driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		driver.findElement(By.className("smallSubmit")).click();
		String pageTitle = driver.getTitle();
		System.out.println("Page Title is "+pageTitle);
		String actualPageTitle = "Account Details | opentaps CRM";
		                          //Account Details | opentaps CRM
		if(pageTitle.equals(actualPageTitle))
		{
			System.out.println("Title matched correctly");
		}
		else 
		{
			System.out.println("Title doesnot matched");
		}
		System.out.println("BUILD Success"); 
		 driver.close();
		 }

	}

