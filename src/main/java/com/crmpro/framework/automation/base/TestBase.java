package com.crmpro.framework.automation.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crmpro.framework.automation.utils.TestUtil;

public class TestBase {

	public static WebDriver driver;
	
	public static Properties pro;
	 
    public TestBase()
    {
    	File f = new File(".//Configuration//config.properties");
    	FileInputStream fis;
    	
    	try {
			fis = new FileInputStream(f);
			pro = new Properties();
	    	pro.load(fis);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    	public static void startApplication()
    	{
    		
    		String browserName = pro.getProperty("Browser");
    		if(browserName.equals("Chrome"))
    		{
    			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
    			driver = new ChromeDriver();
    		}
    		else if(browserName.equals("FirefoxDriver"))
    		{
    			System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");
    		    driver = new FirefoxDriver();
    		}
    		else if(browserName.equals("IE"))
    		{
    		   System.setProperty("webdriver.ie.driver", ".//Drivers//IEDriverServer.exe");	
    		}
    		else
    		{
    			System.out.println("Browser not found");
    		}
    		driver.manage().window().maximize();
    		driver.manage().deleteAllCookies();
    		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOADTIME_OUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    		driver.get(pro.getProperty("url"));
    	}
    	
    	
    }
	
	
	
	
	

