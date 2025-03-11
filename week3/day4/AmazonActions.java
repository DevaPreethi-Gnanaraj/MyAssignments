package week3.day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonActions {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver=new ChromeDriver();
		//Loading the Url
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//searching for One plus 9 pro
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("One plus 9 Pro");
		Actions actions= new Actions(driver);
		//actions.keyDown(Keys.ENTER);
		driver.findElement(By.id("nav-search-submit-button")).click();
		//getting the price of first product and displaying the price
		WebElement firstelePrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]"));
		System.out.println("Firstelement Price"+firstelePrice.getText());
		//printing the number of customer rating
		WebElement customerReview = driver.findElement(By.xpath("(//span[@class='a-declarative']/following-sibling::a/span)[1]"));
		System.out.println("Firstelement No. of reviews"+customerReview.getText());
		//clicking the first link to open first listed One plus mobile
		WebElement oneplus = driver.findElement(By.xpath("(//div[@class='a-row a-spacing-micro']/following-sibling::a//span)[1]"));
		oneplus.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(d->oneplus.isDisplayed());	
		//Navigating to new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> shiftwindowFocusTo=new ArrayList<String>(windowHandles);
		for (String windowsName : windowHandles) {
			System.out.println(windowsName);
		}
		driver.switchTo().window(shiftwindowFocusTo.get(1));
		WebElement onePlusImage = driver.findElement(By.id("imgTagWrapperId"));
		wait.until(d->onePlusImage.isDisplayed());
		//Taking screenshot
		File screenshotSrc = driver.getScreenshotAs(OutputType.FILE);
		File screenshotTarget = new File("./screenshot/Oneplus.png");
		FileUtils.copyFile(screenshotSrc, screenshotTarget);
		//WebElement addTocart = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]"));
		//wait.until(d->addTocart.isDisplayed());
		//actions.click(addTocart).perform();
		
		String actualAmount = driver.findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']//span[@class='a-price-whole']")).getText();
		System.out.println(actualAmount);
		//clicking on add to Cart
		WebElement addTocart = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addTocart);
		//driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click();
	
		//getting the cart subTotal
		WebElement subTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		wait.until(d->subTotal.isDisplayed());
		String subTotaltext = subTotal.getText();
		System.out.println("Subtotal is "+subTotaltext);
		//verifying the cart and SubTotal values
		if(actualAmount.contains(subTotaltext))
		{
			System.out.println("The cart subtotal is correct");
		}
		else
		{
			System.out.println("The cart subtotal is not correct");
		}
		System.out.println("BUILD-SUCCESS");
	}

}
