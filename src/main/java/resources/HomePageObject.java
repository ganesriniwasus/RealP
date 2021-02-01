package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject {
	WebDriver driver;
	By signIn = By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
	By register = By.xpath("//a[@href='https://rahulshettyacademy.com/sign_up/']");

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement signIn() {
		return driver.findElement(signIn); 
	}

	public WebElement register() {
		return driver.findElement(register);
	}
}
