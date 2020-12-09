package com.studi.pagemodules;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.studi.pageobjects.Object_Begin_Practice_Topic4_Chapter1_Mathematics;
import com.studi.pageobjects.Object_Landing_Page;
import com.studi.pageobjects.Object_Subject_Mathematics;
import com.studi.pageobjects.Object_Syllabus;



public class Module_Verify_Attempt_In_Practice{
	
	
	public void verify_Attempt_In_Practice() throws InterruptedException, IOException {
		Module_Login ml=new Module_Login(); 
		ml.login_To_App();
		Object_Landing_Page olp=new Object_Landing_Page();
		Object_Syllabus obb=new Object_Syllabus();
		Object_Subject_Mathematics osm=new Object_Subject_Mathematics();
		Object_Begin_Practice_Topic4_Chapter1_Mathematics obpt = new Object_Begin_Practice_Topic4_Chapter1_Mathematics(); 
		olp.syllabus.click();
		Thread.sleep(2000);
		
		osm.subject_Mathematics.click();
		
		Thread.sleep(6000);
		osm.topic_4_chapter_1.click();
		
		osm.begin_Practice_topic_4_chapter_1.click();
		Thread.sleep(5000);
		
		obpt.beginPractice.click();
		Thread.sleep(6000);
		
		String question=obpt.question1_part2_Text.getText();
		
		System.out.println("Questions asked is : "+question);
		
		obpt.first_answer.click();
		Thread.sleep(2000);
		
		obpt.check_answer.click();
		Thread.sleep(2000);
		
		obpt.tryAgain.click();
		Thread.sleep(2000);
		
		String s=obpt.attemptLeft.getText(); 
		System.out.println(s);
		Boolean result=s.equals("You have one attempt left"); 
		Assert.assertTrue(result);
	}
}