package sit707_week2;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * Main class to run the tests
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Running Bunnings Login Tests...");
        
        // Run JUnit tests for Bunnings login
        Result result = JUnitCore.runClasses(BunningsLoginTest.class);
        
        // Print test result summary
        System.out.println("\nTest Summary:");
        System.out.println("Total tests run: " + result.getRunCount());
        System.out.println("Tests passed: " + (result.getRunCount() - result.getFailureCount()));
        System.out.println("Tests failed: " + result.getFailureCount());
        System.out.println("Time taken: " + result.getRunTime() + " ms");
        
        // Print details of failed tests, if any
        if (result.getFailureCount() > 0) {
            System.out.println("\nFailed Tests:");
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        
        System.out.println("\nTest Case Summary:");
        System.out.println("1. testValidEmailValidPassword - Tests valid login credentials");
        System.out.println("2. testInvalidEmailFormatValidPassword - Tests invalid email format with valid password");
        System.out.println("3. testValidEmailInvalidPassword - Tests valid email with invalid password");
        System.out.println("4. testEmptyEmailValidPassword - Tests empty email with valid password");
        System.out.println("5. testValidEmailEmptyPassword - Tests valid email with empty password");
        System.out.println("6. testInvalidUsernameInvalidPassword - Tests invalid username with invalid password");
        System.out.println("7. testEmptyUsernameEmptyPassword - Tests empty username with empty password");
        System.out.println("8. testSpecialCharactersInUsernamePassword - Tests special characters in username and password");
    }
}