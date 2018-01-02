package amazon;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class amazoneClass {
	 private static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		watches();

	}

	
	private static void watches() throws InterruptedException 
	{
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		Actions action= new Actions(driver);
		
		Thread.sleep(9000);
		WebElement cata= driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		action.moveToElement(cata).build().perform();
		System.out.println("done");
		
		Thread.sleep(9000);
		WebElement mens= driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]/span[7]/span"));
		action.moveToElement(mens).build().perform();
		System.out.println("done");
		
		Thread.sleep(9000);
		WebElement watche= driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[3]/div[7]/div[1]/div[2]/a[1]/span"));
		watche.click();
		System.out.println("done");
		
		

	}
}




