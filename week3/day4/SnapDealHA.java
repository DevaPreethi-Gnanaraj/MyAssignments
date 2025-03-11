package week3.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapDealHA {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement mensFashion = driver.findElement(By.xpath("//span[@class='catText' and text()=\"Men's Fashion\"]"));
		WebElement sportsShoe = driver.findElement(By.xpath("//span[@class='linkTest' and text()=\"Sports Shoes\"]"));
		Actions actions=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(d->mensFashion.isDisplayed());
		actions.moveToElement(mensFashion).perform();
		actions.moveToElement(sportsShoe).click().perform();
		String sportsshoeCount = driver.findElement(By.xpath("//a[contains(@href,\"men-sports-footwear\")]/div[@class='child-cat-count ']")).getText();
		System.out.println("Sports Shoe count is "+sportsshoeCount);
		actions.click(driver.findElement(By.xpath("//a[contains(@href,\"mens-training-shoes\")]/div[@class='child-cat-name ']"))).perform();
		WebElement sortby = driver.findElement(By.xpath("//span[@class='sort-label']"));
		wait.until(ExpectedConditions.elementToBeClickable(sortby));
		actions.click(sortby).perform();
		WebElement sortLowToHigh = driver.findElement(By.xpath("//ul[@class='sort-value']/li[@data-index=1]"));
		actions.click(sortLowToHigh).perform();
		
	}

}
