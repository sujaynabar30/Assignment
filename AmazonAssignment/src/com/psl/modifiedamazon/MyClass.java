//Amazon Assignment 2 (modified code of 1st Assignment)
package com.psl.modifiedamazon;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyClass {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void beforeTest()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.get("https://www.amazon.in/");												//to get the amazon website
	}
	
	@Test(priority=0)
	public void test1()
	{
		//WebElement login = driver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]"));
		WebElement loginclick = driver.findElement(By.id("nav-link-yourAccount"));
		loginclick.click();
		
		WebElement email = driver.findElement(By.id("ap_email"));
		email.sendKeys("");
		driver.findElement(By.id("continue")).click();
		
		WebElement pwd = driver.findElement(By.id("ap_password"));
		pwd.sendKeys("");
		driver.findElement(By.id("signInSubmit")).click();
		System.out.println("Logged in Sucessfully");
		
	}
	
	@Test(priority=1)
	public void test2()
	{		
			WebElement searchbar = driver.findElement(By.id("twotabsearchtextbox"));                            //find searchbox
			searchbar.sendKeys("Think and Grow Rich");															//search what u want
			System.out.println("product Found");
			//driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();				//click search
			driver.findElement(By.className("nav-input")).click();
			driver.findElement(By.linkText("Think and Grow Rich (Re-Jacketed December 2017)")).click();   							 //click req prod			
	}
	
	@Test(priority=2)
	public void test3()
	{
		/*String MainWindow=driver.getWindowHandle();										//windows handling 
		
		 // To handle all new opened window.				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();
        
        while(i1.hasNext())																//windows handling
        {
        	String ChildWindow=i1.next();		
    		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);                             //switching to child window
                    
                    driver.findElement(By.id("add-to-cart-button")).click();    
                    System.out.println("product added to cart");
                    driver.findElement(By.id("nav-cart")).click();
                    
                    driver.close();
            }
            
                    
        }
        */
		
		windowHandle();

        driver.findElement(By.xpath("//*[@id=\"nav-logo\"]/a[1]/span[1]")).click();         //click amazon icon at uppper left
        WebElement searchbar = driver.findElement(By.id("twotabsearchtextbox"));                            //find searchbox
        
        searchbar.sendKeys("Moto G5s Plus");															//search what u want
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();				//click search
		System.out.println("product Found");
		driver.findElement(By.linkText("Moto G5s Plus (Blush Gold, 64GB)")).click(); //click req prod
		
		 /*while(i1.hasNext())			
	        {
	        	String ChildWindow=i1.next();		
	    		
	        	System.out.println("inside the while loop");
	        	
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	                 
	                    // Switching to Child window
	                    driver.switchTo().window(ChildWindow);
	                    System.out.println("switched to child windows");
	                    
	                    driver.findElement(By.id("add-to-cart-button")).click();      //click on add to cart      
	                    System.out.println("add to cart button clicked");
	                   
	                    driver.findElement(By.id("nav-cart")).click();				  //click on cart
	                    System.out.println("cart button clicked");
	                    
	                    //driver.close();
	            }
	        }*/
			
	        /*driver.findElement(By.id("add-to-cart-button")).click();      //click on add to cart      
	       
	        driver.findElement(By.id("nav-cart")).click();				  //click on cart
	        System.out.println("Product added to cart");*/
		  
		   windowHandle();
		 
		  //driver.findElement(By.xpath("//*[@id=\"nav-logo\"]/a[1]/span[1]")).click();         //click amazon icon at uppper left
	       // driver.findElement(By.xpath("//*[@id=\"activeCartViewForm\"]/div[2]/div/div[4]/div[2]/div[1]/div/div/div[2]/div/span[1]/span/input")).click();		//delete prod from cart
			driver.findElement(By.id("nav-cart")).click();	  
			driver.findElement(By.xpath("//*[@id=\"activeCartViewForm\"]/div[2]/div[2]/div[4]/div[2]/div[1]/div/div/div[2]/div/span[1]/span/input")).click();
	        System.out.println("1st product deleted");
        
	        driver.findElement(By.xpath("//*[@id=\"nav-logo\"]/a[1]/span[1]")).click();        //click amazon icon at uppper left
        
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
	
	public void windowHandle()
	{
		String MainWindow=driver.getWindowHandle();										//windows handling 
		
		 //To handle all new opened window.				
       Set<String> s1=driver.getWindowHandles();		
       Iterator<String> i1=s1.iterator();
       
       while(i1.hasNext())																//windows handling
       {
       		String ChildWindow=i1.next();		
   		
           if(!MainWindow.equalsIgnoreCase(ChildWindow))			
           {    		
                
                   // Switching to Child window
                   driver.switchTo().window(ChildWindow);                             //switching to child window
                   
                   driver.findElement(By.id("add-to-cart-button")).click();    
                   System.out.println("product added to cart");
                   driver.findElement(By.id("nav-cart")).click();
                   
                   driver.close();
           }
           
                   
       }
       driver.switchTo().window(MainWindow);
       
	}
	
}
