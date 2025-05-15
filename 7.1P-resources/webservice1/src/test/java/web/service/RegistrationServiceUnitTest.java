package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for RegistrationService class.
 * These tests verify the functionality of the registration service.
 */
public class RegistrationServiceUnitTest {
    
    @Test
    public void testRegisterSuccess() {
        // Test with standard valid parameters
        boolean result = RegistrationService.register("John", "Doe", "john.doe@example.com", "1990-01-01");
        assertTrue("Registration should succeed with valid data", result);
    }
    
    @Test
    public void testRegisterWithNullValues() {
        // Test with null values
        boolean result1 = RegistrationService.register(null, "Doe", "john@example.com", "1990-01-01");
        assertTrue("Registration should accept null first name", result1);
        
        boolean result2 = RegistrationService.register("John", null, "john@example.com", "1990-01-01");
        assertTrue("Registration should accept null last name", result2);
        
        boolean result3 = RegistrationService.register("John", "Doe", null, "1990-01-01");
        assertTrue("Registration should accept null email", result3);
        
        boolean result4 = RegistrationService.register("John", "Doe", "john@example.com", null);
        assertTrue("Registration should accept null DOB", result4);
        
        boolean result5 = RegistrationService.register(null, null, null, null);
        assertTrue("Registration should accept all null values", result5);
    }
    
    @Test
    public void testRegisterWithEmptyValues() {
        // Test with empty string values
        boolean result1 = RegistrationService.register("", "Doe", "john@example.com", "1990-01-01");
        assertTrue("Registration should accept empty first name", result1);
        
        boolean result2 = RegistrationService.register("John", "", "john@example.com", "1990-01-01");
        assertTrue("Registration should accept empty last name", result2);
        
        boolean result3 = RegistrationService.register("John", "Doe", "", "1990-01-01");
        assertTrue("Registration should accept empty email", result3);
        
        boolean result4 = RegistrationService.register("John", "Doe", "john@example.com", "");
        assertTrue("Registration should accept empty DOB", result4);
        
        boolean result5 = RegistrationService.register("", "", "", "");
        assertTrue("Registration should accept all empty values", result5);
    }
    
    @Test
    public void testRegisterWithSpecialCharacters() {
        // Test with special characters in values
        boolean result = RegistrationService.register("John-Paul", "O'Doe", "john.doe+test@example.com", "1990-01-01");
        assertTrue("Registration should accept special characters in names and email", result);
    }
    
    @Test
    public void testRegisterWithDifferentDateFormats() {
        // Test with different date formats
        boolean result1 = RegistrationService.register("John", "Doe", "john@example.com", "1990-01-01");
        assertTrue("Registration should accept yyyy-MM-dd format", result1);
        
        boolean result2 = RegistrationService.register("John", "Doe", "john@example.com", "01/01/1990");
        assertTrue("Registration should accept MM/dd/yyyy format", result2);
        
        boolean result3 = RegistrationService.register("John", "Doe", "john@example.com", "Jan 1, 1990");
        assertTrue("Registration should accept text date format", result3);
    }
    
    @Test
    public void testRegisterWithLongValues() {
        // Test with extremely long values
        String longName = "A".repeat(100);
        String longEmail = "a".repeat(50) + "@" + "b".repeat(50) + ".com";
        
        boolean result = RegistrationService.register(longName, longName, longEmail, "1990-01-01");
        assertTrue("Registration should accept long name and email values", result);
    }
}