package com.scrolltest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitForHelper {

    public WebDriver driver;

    public WaitForHelper(WebDriver driver){
        this.driver = driver;
    }

    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebElement presenceOfElement(final By Location) {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(Location));
    }

    public WebElement elementToBeClickable(final By elementIdentifier){
        WebElement element = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(elementIdentifier));
        return element;
    }
}
