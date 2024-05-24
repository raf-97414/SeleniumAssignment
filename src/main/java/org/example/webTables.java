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

    public void removeItemBasedOnSize(String product, String size, WebElement w, WebElement w1)
    {
        if(product.equals(w.findElement(By.xpath("td[1]//div/div[2]/a[text()]")).getText())&&size.equals(w1.getText()))
            w.findElement(By.xpath("td[1]/div/div[2]/div[2]/a")).click();
            System.out.println("Product "+product+" of size "+size+" Removed");


    }

    public void removeItemBasedOnEverything(String product, String size, String color, WebElement w, WebElement w1, WebElement w2)
    {
        if(product.equals(w.findElement(By.xpath("td[1]//div/div[2]/a[text()]")).getText())&&size.equals(w1.getText())&&color.equals(w2.getText()))
            w.findElement(By.xpath("td[1]/div/div[2]/div[2]/a")).click();
            System.out.println("Product "+product+" of size "+size+" and color "+color+" Removed");


    }

        public static void main(String[] args) throws InterruptedException {
            WebDriver wb = new ChromeDriver();
            System.out.println("Enter Product name");
            Scanner sc = new Scanner(System.in);
            String product = sc.nextLine();
            wb.get("https://demo.evershop.io/account/login");
            wb.findElement(By.name("email")).sendKeys("rafeliafernandes48@gmail.com");
            wb.findElement(By.cssSelector("input[type='password']")).sendKeys("Rafelia14041997@");
            wb.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(1000);
            wb.findElement(By.xpath("//a[@href='/cart']")).click();
            webTables webTable = new webTables();

            Thread.sleep(1000);
            //accessing webtables
           //List<WebElement> l = wb.findElements(By.xpath("//table/tbody/tr/td[1]//div/div[2]/a[text()]"));
           List<WebElement> ll = wb.findElements(By.xpath("//table/tbody/tr/td[1]//div/div[2]/div/ul/li[1]"));
           List<WebElement> ll1 = wb.findElements(By.xpath("//table/tbody/tr/td[1]//div/div[2]/div/ul/li[2]"));
           //List<WebElement> l1 = wb.findElements(By.xpath("//table/tbody/tr/td[2]/div[1]/span"));
           //List<WebElement> l2 = wb.findElements(By.xpath("//table/tbody/tr/td[3]//span"));
           //List<WebElement> l3 = wb.findElements(By.xpath("//table/tbody/tr/td[4]//span"));
            List<WebElement> l = wb.findElements(By.xpath("//table/tbody/tr")); //generates a list of webelements with similar xpaths

            Map<Integer,WebElement> mcart = new HashMap<>();

            int j = 1;
            int i = 0;
           for(WebElement w : l) {
               mcart.put(j,w);
               j++;
           }

           for(Map.Entry<Integer,WebElement>m: mcart.entrySet())
           {
               System.out.println(m.getKey() +"   "+ m.getValue().findElement(By.xpath("td[1]//div/div[2]/a[text()]")).getText() + "   " +
                       m.getValue().findElement(By.xpath("td[2]/div[1]/span")).getText() + "   "+ m.getValue().findElement(By.xpath("td[3]//span")).getText()
                       + "   " + m.getValue().findElement(By.xpath("td[4]//span")).getText());
               System.out.println("    "+ll.get(i).findElement(By.xpath("span[2]")).getText());
               System.out.println("    "+ll1.get(i).findElement(By.xpath("span[2]")).getText());
               System.out.println();


               webTable.totalAmount(product,m.getValue());
               webTable.removeItem(product,m.getValue());
               //webTable.removeItemBasedOnColor(product,"Brown",m.getValue(),ll1.get(i).findElement(By.xpath("span[2]")));
               //webTable.removeItemBasedOnSize(product,"S",m.getValue(),ll.get(i).findElement(By.xpath("span[2]")));
               //webTable.removeItemBasedOnEverything(product,"X","Black",m.getValue(),ll.get(i).findElement(By.xpath("span[2]")),ll1.get(i).findElement(By.xpath("span[2]")));
               i++;






           }




           wb.quit();




           }

        }