package week3.day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TicketBooking {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listofAllWindows=new ArrayList<String>(windowHandles);
		driver.switchTo().window(listofAllWindows.get(1));
		String titleofChildWindow = driver.getTitle();
		System.out.println(titleofChildWindow);
		driver.switchTo().window(listofAllWindows.get(0));
		driver.close();

	}

}
