package com.studi.testScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.studi.base.BaseClass;
import com.studi.pagemodules.Module_Login;
import com.studi.pageobjects.Object_Login;



public class LoginTest extends Module_Login{
	
	@Test
	public void verifyLogin() throws IOException, InterruptedException {
//		Object_Login ol=new Object_Login();
//		WebDriver driver=BaseClass.driver;
//		Thread.sleep(12000);
//		ol.alreadyAUser.click();
//		System.out.println("Success");
		
		Module_Login ml=new Module_Login(); 
		ml.login_To_App();
	}
}
