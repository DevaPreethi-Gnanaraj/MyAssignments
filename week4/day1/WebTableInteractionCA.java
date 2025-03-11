package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WebTableInteractionCA {

	public static void main(String[] args) throws InterruptedException {
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		//options.addArguments("--incognito");
		//ChromeDriver driver = new ChromeDriver(options);
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']"));
		checkBox.click();
		Thread.sleep(5000);
		List<WebElement> countOfRow = driver.findElements(By.xpath("//div[@id='divTrainsList']//tbody/tr/td[2]"));
		int rowSize = countOfRow.size();
		System.out.println(rowSize);
		//List<WebElement> trainNamecolumn = driver.findElements(By.xpath("//div[@id='divTrainsList']//tbody/tr/td[2]"));
		//int trainNamesize = trainNamecolumn.size();
		//System.out.println(trainNamesize);
		for (int i = 2; i < rowSize; i++) {
			WebElement trainelement = driver.findElement(By.xpath("//div[@id='divTrainsList']//tbody/tr["+ i +"]/td[2]"));
			String trainName = trainelement.getText();
			System.out.println(trainName);
		}
	}

}
