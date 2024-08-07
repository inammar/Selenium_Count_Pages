package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String address = "address of the website";


    public static void main(String[] args) {
        setup();
        cookieAcceptance();
    }

    public static void cookieAcceptance() {
        driver.get(address);

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button.c-btn--secondary.h-btn-intent--primary.h-btn--small[type='button'][widget-attachpoint='agree'][rel-widget-id='consent_block']")
                )
        );

        driver.findElement(By.cssSelector("button.c-btn--secondary.h-btn-intent--primary.h-btn--small[type='button'][widget-attachpoint='agree'][rel-widget-id='consent_block']")).click();
    }

    public static void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}