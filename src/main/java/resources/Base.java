package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver Initialize() throws IOException {
		FileInputStream fs = new FileInputStream(
				"C:\\Users\\ganes\\eclipse-workspace\\RealP\\src\\main\\resources\\Testing.properties");
		prop = new Properties();
		prop.load(fs);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			String chromeDriverPath = prop.getProperty("chromedriverpath");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("filefox")) {
			String firefoxDriverPath = prop.getProperty("firefoxdriverpath");
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			String edgeDriverPath = prop.getProperty("edgedriverpath");
			System.setProperty("webdriver.chrome.driver", edgeDriverPath);
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenshotcopy(String filename, WebDriver testDriver) throws IOException {
		driver =testDriver;
		File fs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// define project
		FileUtils.copyFile(fs, new File("C:\\Users\\ganes\\eclipse-workspace\\RealP\\extentreport\\" + filename+".jpg"));
		return "C:\\Users\\ganes\\eclipse-workspace\\RealP\\extentreport\\" + filename+".jpg";
	}
}
