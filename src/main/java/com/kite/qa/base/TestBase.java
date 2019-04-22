package com.kite.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.kite.qa.util.TestUtil;

public class TestBase {
public static WebDriver driver;
public static Properties prop;

	public TestBase(){
		
		try{
			
			prop = new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\KiteZeodhaAutomation\\src\\main\\java\\com\\kite"
			 		+ "\\qa\\config\\config.poperties");
			 prop.load(ip);
		}
		
		catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}catch(IOException io) {
			io.printStackTrace();
		}
	}
	
	public static void initializaion() {
		
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();//driver_varriable initialization
			
		}else if(browser.equals("FF")){
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32");
			driver=new ChromeDriver();//driver_varriable initialization
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Load_time,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
