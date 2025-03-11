package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinanceYahooHA {

		public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		//opening the url
		driver.get("https://finance.yahoo.com/");
		//maximizing the window
		driver.manage().window().maximize();
		//applying implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		// using Actions Class
		Actions actions=new Actions(driver);
		WebElement moreOptions = driver.findElement(By.xpath("//nav[@role='navigation']//span[text()='More']"));
		// using the created object of Actions class performing the actions like movetoelement,click
		actions.moveToElement(moreOptions).perform();
		WebElement cryptoLink = driver.findElement(By.xpath("//a[contains(@href,'finance.yahoo.com/crypto/')]"));
		actions.click(cryptoLink).perform();
		WebElement tableValue = driver.findElement(By.xpath("//table[@data-testid='table-container']"));
		//using a explicit wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(d->tableValue.isDisplayed());
		// fetching all the row data present in the table and storing in list
		List<WebElement> row = driver.findElements(By.xpath("//table[@data-testid='table-container']//tbody/tr"));
		// finding the size of no. of rows
		int rowSize = row.size();
		System.out.println(rowSize);
		// using a for loop to iterate through the list to fetch all the crytovalues present in the table
		for (int i = 1; i <=rowSize; i++) {
			WebElement cryptoName = driver.findElement(By.xpath("//table[@data-testid='table-container']//tbody/tr["+i+"]/td[2]"));
			String displayCryptoName = cryptoName.getText();
			System.out.println(displayCryptoName);
		}
		System.out.println("Build-SUCCESS");
		driver.close();
	}

}
