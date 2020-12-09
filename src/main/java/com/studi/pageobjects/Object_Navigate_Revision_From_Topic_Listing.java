package com.studi.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studi.base.BaseClass;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Object_Navigate_Revision_From_Topic_Listing
	{
		
		@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")
		public WebElement selectTopic;
		
		@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]")
		public WebElement select_Begin_Revision;
		
		@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
		public WebElement verify_OnboardingPage;
		
		@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView[2]")
		public WebElement gobackFrom_OnboardingPage;
		
		
		public Object_Navigate_Revision_From_Topic_Listing() {
			PageFactory.initElements(new AppiumFieldDecorator(BaseClass.getDriver()), this);

	}
	
}
