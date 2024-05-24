package org.example;

import java.time.Duration;
import java.util.*;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;


public class webTables {

    public void totalAmount(String product, WebElement w)
    {
        if(w.findElement(By.xpath("td[1]//div/div[2]/a[text()]")).getText().equals(product)){
            System.out.println("Total Price of "+ product +" is "+w.findElement(By.xpath("td[4]//span")).getText());
        }
    }

    public void removeItem(String product, WebElement w)
    {
        if(product.equals(w.findElement(By.xpath("td[1]//div/div[2]/a[text()]")).getText()))
          w.findElement(By.xpath("td[1]/div/div[2]/div[2]/a")).click();
          System.out.println("Product "+ product +" Removed");


    }

    public void removeItemBasedOnColor(String product, String color, WebElement w, WebElement w1)
    {
        if(product.equals(w.findElement(By.xpath("td[1]//div/div[2]/a[text()]")).getText()) && color.equals(w1.getText()))
            w.findElement(By.xpath("td[1]/div/div[2]/div[2]/a")).click();
            System.out.println("Product "+product+" of color "+color+" Removed");


    }

    public void removeIte