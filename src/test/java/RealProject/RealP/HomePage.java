package RealProject.RealP;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;
import resources.HomePageObject;
import resources.SigninPageObject;

public class HomePage extends Base {
	private static final Logger log = LogManager.getLogger(HomePage.class);
	WebDriver driver;
	int testIteration;
	@BeforeTest
	public void startLogin() {
		testIteration = 0;
	}

	@Test
	public void clickLogin() throws IOException {
		driver = Initialize();
		log.info("driver initialization completed successfully");
		driver.get(prop.getProperty("url"));
		log.info("Url successfully opened");
		HomePageObject hpo = new HomePageObject(driver);
		hpo.signIn().click();
		log.info("Sign in clicked");
	}

	@AfterTest
	public void close() {
		driver.close();
		log.info("browser closed");
	}
}
