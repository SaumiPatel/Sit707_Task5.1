package web.service;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginServiceTest {
    
    // The exact path to your login.html file
    private static final String LOGIN_HTML_PATH = "C:/Users/Saumil1103/Downloads/7.1P-resources/pages/login.html";
    
    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) { 
            e.printStackTrace();
        }
    }
    
    @Test
    public void testLoginSuccess() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        try {
            // Navigate directly to the login.html file using the file:/// protocol
            driver.get("file:///" + LOGIN_HTML_PATH);
            sleep(2);
            
            System.out.println("On login page - filling out form");
            
            // Fill out form with correct credentials
            WebElement usernameElement = driver.findElement(By.name("username"));
            usernameElement.clear();
            usernameElement.sendKeys("ahsan");
            
            WebElement passwordElement = driver.findElement(By.name("passwd"));
            passwordElement.clear();
            passwordElement.sendKeys("ahsan_pass");
            
            WebElement dobElement = driver.findElement(By.name("dob"));
            dobElement.clear();
            dobElement.sendKeys("1990-01-01");
            
            // Submit form
            System.out.println("Submitting form to server");
            driver.findElement(By.cssSelector("form")).submit();
            
            sleep(3);
            
            // Check server response
            String pageSource = driver.getPageSource();
            System.out.println("Response page title: " + driver.getTitle());
            System.out.println("Response content: " + pageSource.substring(0, Math.min(pageSource.length(), 100)) + "...");
            
            assertTrue("Expected success message in response", 
                      pageSource.toLowerCase().contains("success") || 
                      driver.getTitle().toLowerCase().contains("success"));
            
        } catch (Exception e) {
            System.out.println("Test failed with exception: " + e.getMessage());
            e.printStackTrace();
            fail("Test failed with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
    
    @Test
    public void testLoginCorrectUsernameWrongPassword() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        try {
            driver.get("file:///" + LOGIN_HTML_PATH);
            sleep(2);
            
            WebElement usernameElement = driver.findElement(By.name("username"));
            usernameElement.clear();
            usernameElement.sendKeys("ahsan");
            
            WebElement passwordElement = driver.findElement(By.name("passwd"));
            passwordElement.clear();
            passwordElement.sendKeys("wrong_password");
            
            WebElement dobElement = driver.findElement(By.name("dob"));
            dobElement.clear();
            dobElement.sendKeys("1990-01-01");
            
            driver.findElement(By.cssSelector("form")).submit();
            
            sleep(3);
            
            String pageSource = driver.getPageSource();
            assertTrue("Expected fail message in response", 
                      pageSource.toLowerCase().contains("fail") || 
                      driver.getTitle().toLowerCase().contains("fail"));
            
        } catch (Exception e) {
            System.out.println("Test failed with exception: " + e.getMessage());
            e.printStackTrace();
            fail("Test failed with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
    
  
    @Test
    public void testLoginInvalidCredentials() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        try {
            driver.get("file:///" + LOGIN_HTML_PATH);
            sleep(2);
            
            WebElement usernameElement = driver.findElement(By.name("username"));
            usernameElement.clear();
            usernameElement.sendKeys("invalid");
            
            WebElement passwordElement = driver.findElement(By.name("passwd"));
            passwordElement.clear();
            passwordElement.sendKeys("invalid");
            
            WebElement dobElement = driver.findElement(By.name("dob"));
            dobElement.clear();
            dobElement.sendKeys("2000-01-01");
            
            driver.findElement(By.cssSelector("form")).submit();
            
            sleep(3);
            
            String pageSource = driver.getPageSource();
            assertTrue("Expected fail message in response", 
                      pageSource.toLowerCase().contains("fail") || 
                      driver.getTitle().toLowerCase().contains("fail"));
            
        } catch (Exception e) {
            System.out.println("Test failed with exception: " + e.getMessage());
            e.printStackTrace();
            fail("Test failed with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
    
    @Test
    public void testLoginSQLInjectionAttempt() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        try {
            driver.get("file:///" + LOGIN_HTML_PATH);
            sleep(2);
            
            WebElement usernameElement = driver.findElement(By.name("username"));
            usernameElement.clear();
            usernameElement.sendKeys("' OR '1'='1");  // SQL Injection attempt
            
            WebElement passwordElement = driver.findElement(By.name("passwd"));
            passwordElement.clear();
            passwordElement.sendKeys("' OR '1'='1");  // SQL Injection attempt
            
            WebElement dobElement = driver.findElement(By.name("dob"));
            dobElement.clear();
            dobElement.sendKeys("1990-01-01");
            
            driver.findElement(By.cssSelector("form")).submit();
            
            sleep(3);
            
            String pageSource = driver.getPageSource();
            assertTrue("Expected fail message in response", 
                      pageSource.toLowerCase().contains("fail") || 
                      driver.getTitle().toLowerCase().contains("fail"));
            
        } catch (Exception e) {
            System.out.println("Test failed with exception: " + e.getMessage());
            e.printStackTrace();
            fail("Test failed with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
    
    @Test
    public void testLoginEmptyFields() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        try {
            driver.get("file:///" + LOGIN_HTML_PATH);
            sleep(2);
            
            // Don't fill out any fields, just submit the form
            driver.findElement(By.cssSelector("form")).submit();
            
            sleep(3);
            
            String pageSource = driver.getPageSource();
            assertTrue("Expected fail message in response", 
                      pageSource.toLowerCase().contains("fail") || 
                      driver.getTitle().toLowerCase().contains("fail"));
            
        } catch (Exception e) {
            System.out.println("Test failed with exception: " + e.getMessage());
            e.printStackTrace();
            fail("Test failed with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}