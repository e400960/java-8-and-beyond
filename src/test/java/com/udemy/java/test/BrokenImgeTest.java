package com.udemy.java.test;

import com.udemy.java.supplier.DriverFactory;
import com.udemy.java.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BrokenImgeTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
    }

    // https://the-internet.herokuapp.com/broken_images

    @Test
    public void linkTest(){
        this.driver.get("https://the-internet.herokuapp.com/broken_images");

        System.out.println("Before :: " + LocalDateTime.now());

        List<String> list = this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .parallel()
                .map(e -> e.getAttribute("src"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200).toList();

        Assert.assertEquals(list.size(),0,list.toString());
        System.out.println("After :: " + LocalDateTime.now());
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
