package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HAweek2day1FBLogin {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		//maximizing browser
		driver.manage().window().maximize();
		//launching browser
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tuna@321");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("Find your account and log in.")).click();
		String curentFBtext = driver.getTitle();
		String actualFBtext="Forgotten Password | Can't Log In | Facebook";
		//verifying the title of the page using .equals
		if(curentFBtext.equals(actualFBtext))
		{
			System.out.println("Title Matched");
		}
		else 
		{
			System.out.println("Title doesnotMatched");
		}
		System.out.println("BUILD Success");
		driver.close();
	}

}
