package com.scrolltest.pages;

import com.scrolltest.base.BasePage;
import com.scrolltest.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    By username = By.id("login-username");
    By password = By.id("login-password");
    By signButton = By.id("js-login-btn");

    public void OpenPage(){
        goToUrl(PropertyReader.readItem("url"));
    }

    public void LoginToPage(){
        writeText(username,PropertyReader.readItem("username"));
        writeText(password,PropertyReader.readItem("password"));
        click(signButton);
    }

    public DashboardPage AfterLoginToDashboard(){
        return new DashboardPage(driver);
    }
}
