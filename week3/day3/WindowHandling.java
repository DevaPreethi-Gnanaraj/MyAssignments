package week3.day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[contains(@href,'contactsMain')]")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")).click();
		String windowHandle = driver.getWindowHandle();
		//displaying the current window-->parent window title
		System.out.println("Current window title");
		System.out.println(driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allopenwindowslist=new ArrayList<String>(windowHandles);
		System.out.println(windowHandles);
		driver.switchTo().window(allopenwindowslist.get(1));
		driver.findElement(By.xpath("//a[text()='DemoCustomer']")).click();
		driver.switchTo().window(allopenwindowslist.get(0));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a")).click();
		//driver.switchTo().window(allopenwindowslist.get(1));
		Set<String> childwindow2 = driver.getWindowHandles();
		List<String> childwindow2List =new ArrayList<String>(childwindow2);
		driver.switchTo().window(childwindow2List.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='DemoLBCust']")).click();
		driver.switchTo().window(childwindow2List.get(0));
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		driver.switchTo().alert().accept();
		String titleOfThePage = driver.getTitle();
		System.out.println(titleOfThePage);
		String ActualTitle="Merge Contacts | opentaps CRM";
		if(ActualTitle==titleOfThePage)
		{
		System.out.println("BUILD-SUCCESS");
		}
		else
		{
		System.out.println("BUILD-failed");
		}

	}

}
