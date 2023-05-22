package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPO extends BasePagePO {

	private String url = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";
	
	private By usernameInput = By.id("username");
	private By passwordInput = By.id("password");
	private By submitButton = By.className("mt-2");
	private By invalidBox = By.id("invalid");
	
	public LoginFormPO(WebDriver driver) {
		super(driver);
		visit(this.url);
	}
	
	public BasePagePO with(String username, String password) {
		type(usernameInput, username);
		type(passwordInput, password);
		click(submitButton);
		
		if(getUrl().equals(url)) {
			return this;
		}
		else {
			return new LoginSuccessPO(driver);
		}
	}
	
	public boolean invalidBoxIsPresent() {
		return isIn(invalidBox);
	}
}
