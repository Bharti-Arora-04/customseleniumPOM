package com.scrolltest.pages;

import com.scrolltest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    By usernameOnDashboard = By.xpath("//span[@data-qa=\"lufexuloga\"]");

    public String VerifyUsername(){
        waitForElementToAppear(usernameOnDashboard);
        return driver.findElement(usernameOnDashboard).getText();
    }
}
