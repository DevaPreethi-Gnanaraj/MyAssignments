package week3.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAndAlerts {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.switchTo().frame(0);
		//using String or Attribute
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		Alert alert = driver.switchTo().alert();
		String alertMsg= alert.getText();
		System.out.println(alertMsg);
		alert.sendKeys("Deva");
		alert.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());
		System.out.println("BUILD-SUCCESS");
		driver.close();
	}

}
