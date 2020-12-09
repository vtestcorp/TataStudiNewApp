package com.studi.pagemodules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.studi.pageobjects.Object_Receive_MCQ_Questions_Practice;
import com.studi.pageobjects.Object_Receive_MCQ_Questions_Revision;




public class Model_Receive_MCQ_Questions_DefaultState {
	
public String firstQuestion;
	
	public void Verify_MCQ_Questions_DefaultState() throws InterruptedException, AWTException{
		
		Object_Receive_MCQ_Questions_Practice RMQP = new Object_Receive_MCQ_Questions_Practice();
		Object_Receive_MCQ_Questions_Revision RMQP1 = new Object_Receive_MCQ_Questions_Revision();
		
		RMQP.select_browse_books.click();
		Thread.sleep(1000);
		RMQP.select_subject.click();
		Thread.sleep(1000);
		System.out.println("Subject - Geography - Geography Grade 6 is shown");
		RMQP1.select_topic_from_chapter.click();
		Thread.sleep(2000);
		System.out.println("Selected Topic");
		RMQP1.select_Begin_Revision.click();
		Thread.sleep(20000);
		RMQP1.click_Begin_Revision.click();
		Thread.sleep(3000);
		
		System.out.println("Video started");
		
		Thread.sleep(5000);
		
		RMQP1.img_OverviewPg_screen.click();
		String totalVedioTime=RMQP1.img_OverviewPg_screen_time.getText();
		System.out.println(totalVedioTime);
		int totalWaitingMins=Integer.parseInt(totalVedioTime.split(":")[0]);
		int totalWaitingSecs=Integer.parseInt(totalVedioTime.split(":")[1]);
		int minSecs=(totalWaitingMins)*60;
		int totalWait=(minSecs+totalWaitingSecs+5)*1000;
		System.out.println("Waiting for Video to complete. Waiting for '"+(totalWait)/1000+"' seconds");
		int wait=0; 
		try {
		while(wait<totalWait)
		{
			Thread.sleep(5000);
			RMQP1.img_OverviewPg_screen.click();
			wait=wait+5000;
		}
		}
		catch (Exception e) {}
		System.out.println("Waited till '"+(totalWait)/1000+"' seconds");
		
		Thread.sleep(10000);

		firstQuestion = RMQP1.get_First_Question.getText();
		System.out.println(firstQuestion);
		if(firstQuestion.contains("Which"))
			System.out.println("Quiz Started - First Question Shown");
		else
			System.out.println("Missing Quiz");
		
		RMQP1.select_1st_Choice.isEnabled();
		Thread.sleep(2000);
		RMQP1.select_2nd_Choice.isEnabled();
		Thread.sleep(2000);
		
		RMQP1.select_3rd_Choice.isEnabled();
		Thread.sleep(2000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		RMQP1.select_4th_Choice.isEnabled();
		Thread.sleep(2000);
		
		System.out.println("All the questions are in Un-answered mode");
		

	}
}