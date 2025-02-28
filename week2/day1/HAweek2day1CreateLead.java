package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HAweek2day1CreateLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver(); 
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//div[@class='x-panel-header']/a[contains(@href,'myHomeMain')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'createLeadForm')]")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("DevaLead");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("LastnameGnana");
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Acc");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Test");
		driver.findElement(By.className("smallSubmit")).click();
		String leadPageTitle= driver.getTitle();
		String actualPageTitle = "View Lead | opentaps CRM";

		if(leadPageTitle.equals(actualPageTitle))
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
