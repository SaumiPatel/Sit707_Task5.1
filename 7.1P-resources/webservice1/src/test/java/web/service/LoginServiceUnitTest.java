package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginServiceUnitTest {
    
    @Test
    public void testLoginSuccess() {
        // Test with valid credentials
        assertTrue("Login should succeed with correct credentials", 
                   LoginService.login("ahsan", "ahsan_pass", "1990-01-01"));
    }
   
    @Test
    public void testLoginInvalidUsername() {
        // Test with invalid username
        assertFalse("Login should fail with invalid username", 
                    LoginService.login("invalid", "ahsan_pass", "1990-01-01"));
    }
    
    @Test
    public void testLoginInvalidPassword() {
        // Test with invalid password
        assertFalse("Login should fail with invalid password", 
                    LoginService.login("ahsan", "invalid", "1990-01-01"));
    }
    
    @Test
    public void testLoginNullUsername() {
        // Test with null username
        assertFalse("Login should fail with null username", 
                    LoginService.login(null, "ahsan_pass", "1990-01-01"));
    }
    
    @Test
    public void testLoginNullPassword() {
        // Test with null password
        assertFalse("Login should fail with null password", 
                    LoginService.login("ahsan", null, "1990-01-01"));
    }
    
    @Test
    public void testLoginNullDob() {
        // Test with null DOB
        assertFalse("Login should fail with null DOB", 
                    LoginService.login("ahsan", "ahsan_pass", null));
    }
    
    @Test
    public void testLoginEmptyUsername() {
        // Test with empty username
        assertFalse("Login should fail with empty username", 
                    LoginService.login("", "ahsan_pass", "1990-01-01"));
    }
    
    @Test
    public void testLoginEmptyPassword() {
        // Test with empty password
        assertFalse("Login should fail with empty password", 
                    LoginService.login("ahsan", "", "1990-01-01"));
    }
    
    @Test
    public void testLoginEmptyDob() {
        // Test with empty DOB
        assertFalse("Login should fail with empty DOB", 
                    LoginService.login("ahsan", "ahsan_pass", ""));
    }
}