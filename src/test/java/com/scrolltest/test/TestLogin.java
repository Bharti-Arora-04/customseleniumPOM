package com.scrolltest.test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.scrolltest.base.TestBase;
import com.scrolltest.pages.DashboardPage;
import com.scrolltest.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.sun.javafx.sg.prism.web.NGWebView.log;

public class TestLogin extends TestBase {

    static WebDriver driver;

    public static void main(String[] args) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        ExtentTest test1 = extent.createTest("Login to VWO Page", "Login to the VWO App and Verify Dashboard");
        test1.log(Status.INFO,"Starting Test case1");
        loginVwo();

        test1.pass("Login to VWO");
        driver.close();
        driver.quit();
        test1.pass("closed the browser");
        test1.info("Test Completed");

        ExtentTest test2 = extent.createTest("Login to VWO Page", "Login to the VWO App and Verify Dashboard");
        test2.log(Status.INFO,"Starting Test case2");
        loginAndVerifyDashboard();



        test2.pass("Open the dashboard ");
        driver.close();
        driver.quit();
        test2.pass("closed the browser");
        test2.info("Test Completed");
        extent.flush();
    }

    public static void loginVwo(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenPage( );
        loginPage.LoginToPage( );
    }
    public static void loginAndVerifyDashboard() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenPage( );
        loginPage.LoginToPage( );
        DashboardPage dashboardPage = loginPage.AfterLoginToDashboard( );
        Assert.assertEquals(dashboardPage.VerifyUsername( ), "Wingify");
    }
}

