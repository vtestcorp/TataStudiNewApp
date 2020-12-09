package com.studi.pagemodules;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.studi.base.BaseClass;
import com.studi.pageobjects.Object_Begin_Practice_Topic4_Chapter1_Mathematics;
import com.studi.pageobjects.Object_Begin_Revision_Topic4_Chapter1_Mathematics;

public class Module_Verify_feedback_for_Answers_In_Revision  {
	public Module_Verify_feedback_for_Answers_In_Revision() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	public void verify_Feedback_for_Answers_in_Revision() throws InterruptedException, IOException {
		
		
		
		Module_Login login = new Module_Login();
		login.login_To_App();
		
		
		Object_Begin_Revision_Topic4_Chapter1_Mathematics obrtcm=new Object_Begin_Revision_Topic4_Chapter1_Mathematics();
		obrtcm.syllabus.click();
		
		obrtcm.subject_Mathematics.click();
		System.out.println("Subject:Mathematics is chosen");
		
		
		obrtcm.topic_4_chapter_1.click();
		
		//verification that questions are displayed 
		 
		Object_Begin_Practice_Topic4_Chapter1_Mathematics obptcm=new Object_Begin_Practice_Topic4_Chapter1_Mathematics();
		String questionText=obptcm.question1_part1_Text.getText(); 
		if (questionText.contains("Write the expression")) {
			System.out.println("Questions are displayed");
		} else {
			System.out.println("Questions are not displayed");
		}
		
		
	}
}
