package web.service;

/**
 * Business logic to handle login functions.
 *
 * @author Ahsan.
 */
public class LoginService {

    /**
     * Static method returns true for successful login, false otherwise.
     * Validates credentials against predefined values.
     * 
     * @param username The username to validate
     * @param password The password to validate
     * @param dob The date of birth (currently not used for validation)
     * @return true if login is successful, false otherwise
     */
    public static boolean login(String username, String password, String dob) {
        // Check for null or empty inputs
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return false;
        }
        
        // Match a fixed user name and password.
        // In a real application, this would use a secure password storage mechanism.
        if ("ahsan".equals(username) && "ahsan_pass".equals(password)) {
            return true;
        }
        
        // Another valid test account
        if ("test".equals(username) && "test123".equals(password)) {
            return true;
        }
        
        return false;
    }
}