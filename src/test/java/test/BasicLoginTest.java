package test;
import org.junit.jupiter.api.Test;

import POs.LoginFormPO;
import POs.LoginSuccessPO;

import static org.junit.jupiter.api.Assertions.*;

// a change to test github actions
public class BasicLoginTest extends DriverLifeCycleSetting{
	
	private LoginFormPO login;
	
	private LoginSuccessPO loginSuccess;


	@Test
	public void TestLoginUnsuccessful() throws InterruptedException {
		login = new LoginFormPO(driver);
		login.with("user", "error");
		assertTrue(login.invalidBoxIsPresent());
	}
	
	@Test
	public void TestLoginSuccessful() throws InterruptedException {
		login = new LoginFormPO(driver);
		loginSuccess = (LoginSuccessPO) login.with("user", "user");
		assertTrue(loginSuccess.successBoxIsPresent());
	}
}
