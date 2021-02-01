package RealProject.RealP;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;
import resources.SigninPageObject;

public class LoginPage extends Base {
	WebDriver driver;
	HomePage hp;
	int testIteration;
	public static Logger log = LogManager.getLogger(LoginPage.class.getClass());

	@BeforeTest
	public void startLogin() {
		testIteration = 0;
	}

	@Test(dataProvider = "getData")
	public void LogIn(String username, String password) throws IOException {

		hp = new HomePage();
		hp.clickLogin();
		driver = hp.driver;
		SigninPageObject SigninObject = new SigninPageObject(driver);
		SigninObject.getEmail().sendKeys(username);
		SigninObject.getPassword().sendKeys(password);
		SigninObject.getLogin().click();
		log.info("Login clicked");
		if (SigninObject.getAlert().getText().trim().equalsIgnoreCase("Invalid email or password.")) {
			log.error("Invalid email or password.");
		} else {
			log.info("Login Successfull");
		}
		// verify the page header link is displayed and not broken
		Assert.assertFalse(SigninObject.getHeader().isDisplayed(), "Header text is matching");
		testIteration++;
	}

	@AfterTest
	public void close() {
		driver.close();
	}

	@DataProvider
	public Object getData() {
		Object[][] obj = new Object[2][2];
		// define 1st dataset
		obj[0][0] = "user1";
		obj[0][1] = "password1";

		// define 2nd dataset
		obj[1][0] = "user2";
		obj[1][1] = "password2";
		return obj;
	}
}
