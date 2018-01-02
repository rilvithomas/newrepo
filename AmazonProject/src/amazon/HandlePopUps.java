package amazon;

import java.util.Set;

import org.bouncycastle.tsp.GenTimeAccuracy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.remote.server.handler.GetCurrentWindowHandle;
import org.testng.Assert;

public class HandlePopUps {
	
	WebDriver driver;
	String mainWindow=null;
	public static void main(String[] args) {
		
	}
	
	private void test_CloseAllWindowsExceptMainWindow() 
	{
		driver.get("");
	String 	WindowTitle=getCurrentWindowTitle();
	String 	mainWindow=getMainWindowHandle(driver);
		System.out.println(mainWindow);
		cloaseAllOtherwindows(mainWindow);
		//Assert.assertTrue(closeAllOtherWindows());

	}

	public String getMainWindowHandle(WebDriver driver)
	{
		return driver.getWindowHandle();
	}

	public boolean cloaseAllOtherwindows(String openWindowHandle)
	{
		Set< String> allWindowHandles=driver.getWindowHandles();
		for(String currentWindowHandle : allWindowHandles)
		{
			if(!currentWindowHandle.equals(openWindowHandle))
			{
				driver.switchTo().window(openWindowHandle);
				driver.close();
			}
		}
		driver.switchTo().window(openWindowHandle);
		if(driver.getWindowHandles().size()==1)
		return true;
		else
			return false;
	}
	public  String getCurrentWindowTitle()// to deals with alert
	
	{
		Alert alertDialog= driver.switchTo().alert();
		alertDialog.dismiss();
		Alert confirmationDialog=driver.switchTo().alert();
		confirmationDialog.dismiss();
		Alert promptDialog= driver.switchTo().alert();
		promptDialog.accept();
		String windowTitle=driver.getTitle();
		return windowTitle;
		
	}
	

}
