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
    public static int totalCount;

    public static void main(String[] args) {
        setup();
        cookieAcceptance();
        timeout(1000);
        
        int count = 0;
        for(int i = 1; i <= 5; i++) {
        count += firstTest(i);
        }
        System.out.println("Number of ads in the category: " + count);

        if(totalCount == count) {
        System.out.println("The quantity of products declared and contained in the category is the same");
        }
    }
    public static int firstTest(int page) {
        driver.get(address + "/search?q=mobile+phone+apple+iPhone+xs&page=" + page);
        if(page == 1) {
            String productCounter = driver.findElement(By.id("categoryTotal")).getText();
            System.out.println(productCounter);

        totalCount = parseInt(productCounter.replace("(", "").replace(")", ""));
        }
    List<WebElement> items = driver.findElements(By.cssSelector("[widget=\"ProductBlock\"]"));

        int counter = 0;
        for (WebElement element : items) {
        counter++;
        }
    System.out.println(counter);
    return counter++;
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
    public static void timeout(int time) {
        try {
            Thread.sleep(time); //1s = 1000
        } catch(Exception e) {
        } 
    }
}
