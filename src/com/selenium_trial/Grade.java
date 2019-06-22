package com.selenium_trial;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import sun.reflect.annotation.ExceptionProxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Grade {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Delilah Dessalegn\\Desktop\\chromedriver.exe");
        //ChromeDriverService driver = new ChromeDriverService(,)
        WebDriver driver=new ChromeDriver();
        // Launch Website

        driver.navigate().to("https://portal.aait.edu.et/");

        //Maximize the browser
        driver.manage().window().maximize();

        driver.findElement(By.name("UserName")).sendKeys("ATR/8398/09");
        driver.findElement(By.name("Password")).sendKeys("3892");
        driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div[2]/form/div[4]/div/button")).click();

        driver.get("https://portal.aait.edu.et/Grade/GradeReport");

        WebElement w = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div"));
        String grade = w.getText();
        File file = new File("Grade.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(grade);
        fileWriter.flush();
        fileWriter.close();
        Thread.sleep(7000);

        driver.quit();

    }
}
