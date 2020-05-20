package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
   static WebDriver driver;
   static Properties prop;
   
	public TestBase(){
		
				try {
			prop= new Properties();
            FileInputStream ip= new FileInputStream("C:\\Users\\Joshi\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\"
            		+ "config.properties");
		    prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}	
		
		public static void initialization() {
			String browsername =prop.getProperty("browser");
			if(browsername.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
	}
	
	
	
	
	
	
	
	
	
	
}
