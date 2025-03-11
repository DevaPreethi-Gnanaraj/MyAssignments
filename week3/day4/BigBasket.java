package week3.day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdk.javadoc.internal.doclets.toolkit.taglets.InheritableTaglet.Output;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		//navigating to the given Url
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Actions actions=new Actions(driver);
		// clicking on Shop by using actions
		WebElement shopBycategory = driver.findElement(By.xpath("(//span[text()='Shop by'])[2]/ancestor::button"));
		actions.click(shopBycategory).perform();
		Thread.sleep(5000);
		//Mouse over "Foodgrains, Oil & Masala". 
		actions.moveToElement(driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"))).perform();
		//Mouse over "Rice & Rice Products". 
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"))).perform();
		//Click on "Boiled & Steam Rice". 
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']"))).click().perform();
		// Filter the results by selecting the brand "bb Royal". 
		actions.click(driver.findElement(By.id("i-BBRoyal"))).perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Thread.sleep(3000);
		// Click on "Tamil Ponni Boiled Rice". 
		wait.until(d->driver.findElement(By.xpath("//input[@id='i-PonniBoiledRice']")).isDisplayed());
		actions.click(driver.findElement(By.xpath("//input[@id='i-PonniBoiledRice']"))).perform();
		Thread.sleep(3000);
		//Select the 26 Kg bag. 
		WebElement kgBag = driver.findElement(By.xpath("//input[@id='i-26kgBag']"));
		actions.moveToElement(kgBag).click(kgBag).pause(3).perform();
		//Adding to cart
		WebElement addToCart = driver.findElement(By.xpath("(//div[@class='flex']//button[text()='Add'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
		// Verify the success message that confirms the item was added to your cart. 
		System.out.println(driver.findElement(By.xpath("//p[text()='An item has been added to your basket successfully']")).getText());
		//Take a snapshot of the current page 
		File src=driver.getScreenshotAs(OutputType.FILE);
		File target=new File("./screenshot/bigbasket.png");
		FileUtils.copyFile(src, target);
		System.out.println("BUILD-SUCCESS");
		//close the window
		driver.close();
		

	}

}
