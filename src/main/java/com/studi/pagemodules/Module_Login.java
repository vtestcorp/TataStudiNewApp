package com.studi.pagemodules;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.studi.base.BaseClass;
import com.studi.base.Keyword;
import com.studi.pageobjects.Object_Login;

public class Module_Login extends BaseClass  {
	
	@Test
	public void login_To_App() throws IOException {
	Object_Login ol= new Object_Login(); 
	Keyword.applyImplicitWait(14);	
	ol.alreadyAUser.click();
	
	Keyword.applyFluentWait(2);
	
	Keyword.clearText(ol.mobileNumberTextBox);
	Keyword.sendText(ol.mobileNumberTextBox, Keyword.getPropertyFromPropertyFile("mobileNumber"));
	Keyword.applyFluentWait(2);
	Keyword.clickOnElement(ol.loginButton);
	Keyword.applyFluentWait(2);
	
	Keyword.sendText(ol.passwordTextBox, "abcd123@");
	Keyword.applyFluentWait(2);
	
	Keyword.clickOnElement(ol.verifypasswordButton);
	Keyword.applyFluentWait(2);
	
	Keyword.clickOnElement(ol.registeredUserName);
	Keyword.applyFluentWait(2);
	
	System.out.println("Login is Successful");
}

}
