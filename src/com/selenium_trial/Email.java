package com.selenium_trial;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Email {
    public static void main(String[] args) throws InterruptedException, IOException {
   getUnreadMessages();
    }

    public static void getUnreadMessages() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Delilah Dessalegn\\Desktop\\chromedriver.exe");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        capabilities.setCapability("chrome.binary","./src//lib//chromedriver");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        //driver = new ChromeDriver(capabilities);
        //ChromeDriverService driver = new ChromeDriverService(,)
        WebDriver driver=new ChromeDriver(capabilities);
        // Launch Website

        driver.navigate().to("https://mail.google.com");

        driver.manage().window().maximize();

        driver.findElement(By.id("identifierId")).sendKeys("dilluxdes@gmail.com",Keys.ENTER);



        Thread.sleep(3000);

        driver.findElement(By.name("password")).sendKeys("password here",Keys.ENTER);



        Thread.sleep(4000);


        List<WebElement> unreadEmails = driver.findElements(By.className("zE"));

        File file = new File("UnreadEmails.txt");
        FileWriter fileWriter = new FileWriter(file);
        for (WebElement unreadEmail:unreadEmails) {

            //System.out.println(unreadEmail.getText());
            String sender = unreadEmail.findElement(By.className("yW")).getText();
            String subject = unreadEmail.findElement(By.className("y6")).getText();


            fileWriter.write("Sender:- ");
            fileWriter.write(sender);
            fileWriter.write(" Subject:- ");
            fileWriter.write(subject);
            fileWriter.write("\n");
        }

        fileWriter.flush();
        fileWriter.close();
        Thread.sleep(7000);
        driver.quit();


    }
}
