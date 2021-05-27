package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.utilities.TimeUtils;

public class Base {
	
	/**This is base class i.e, parent class 
	 * @author Saumya Singh
	 */

	public static WebDriver driver;
	public static Properties prop;
	public static String browserName = null;

	public Base() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("D:\\Selenium\\FrameworkPractice\\"
					+ "POMHybridFramework\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initializeBrowser() {
		browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Selenium\\FrameworkPractice\\POMHybridFramework" + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			

		} else if (browserName.equalsIgnoreCase("ie")) {

			driver = new InternetExplorerDriver();
			System.setProperty("webdriver.ie.driver",
					"D:\\Selenium\\FrameworkPractice\\POMHybridFramework" + "\\drivers\\IEServer.exe");

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver",
					"D:\\Selenium\\FrameworkPractice\\POMHybridFramework" + "\\drivers\\geckodriver.exe");

		} else if (browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
			System.setProperty("webdriver.edge.driver",
					"D:\\Selenium\\FrameworkPractice\\POMHybridFramework" + "\\drivers\\edgedriver.exe");

		} else {
			System.out.println("Please Check Your Browser. You have enter wrong browser......");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		

	}
}
