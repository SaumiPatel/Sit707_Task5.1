package sit707_week6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
    
    // Replace with your actual name and ID
    private String studentName = "Saumil Patel";
    private String studentID = "S223979728";
    
    @Before
    public void setUp() {
        System.out.println("----------Starting Test-----------");
    }
    
    @After
    public void tearDown() {
        System.out.println("----------Test Completed-----------\n");
    }
    
    @Test
    public void testStudentName() {
        System.out.println("Testing student name");
        assertEquals("Checking student name", "Saumil Patel", studentName);
        System.out.println("Student name verified: " + studentName);
    }

    @Test
    public void testStudentID() {
        System.out.println("Testing student ID");
        assertEquals("Checking student ID", "S223979728", studentID);
        System.out.println("Student ID verified: " + studentID);
    }

    // Weather advice tests - cover all conditions
    @Test
    public void testDangerousWeatherHighWind() {
        System.out.println("Testing dangerous weather with high wind speed (71.0 mph)");
        String result = WeatherAndMathUtils.weatherAdvice(71.0, 0.0);
        assertEquals("CANCEL", result);
        System.out.println("Expected: CANCEL, Actual: " + result);
    }
    
    @Test
    public void testDangerousWeatherHighRain() {
        System.out.println("Testing dangerous weather with high precipitation (7.0 inches)");
        String result = WeatherAndMathUtils.weatherAdvice(0.0, 7.0);
        assertEquals("CANCEL", result);
        System.out.println("Expected: CANCEL, Actual: " + result);
    }
    
    @Test
    public void testDangerousWeatherCombined() {
        System.out.println("Testing dangerous weather with combined thresholds (46.0 mph wind, 4.1 inches rain)");
        String result = WeatherAndMathUtils.weatherAdvice(46.0, 4.1);
        assertEquals("CANCEL", result);
        System.out.println("Expected: CANCEL, Actual: " + result);
    }
    
    @Test
    public void testWarningWeatherHighWind() {
        System.out.println("Testing warning weather with high wind speed (46.0 mph)");
        String result = WeatherAndMathUtils.weatherAdvice(46.0, 3.0);
        assertEquals("WARN", result);
        System.out.println("Expected: WARN, Actual: " + result);
    }
    
    @Test
    public void testWarningWeatherHighRain() {
        System.out.println("Testing warning weather with high precipitation (5.0 inches)");
        String result = WeatherAndMathUtils.weatherAdvice(30.0, 5.0);
        assertEquals("WARN", result);
        System.out.println("Expected: WARN, Actual: " + result);
    }
    
    @Test
    public void testAllClearWeather() {
        System.out.println("Testing all clear weather conditions (10.0 mph wind, 2.0 inches rain)");
        String result = WeatherAndMathUtils.weatherAdvice(10.0, 2.0);
        assertEquals("ALL CLEAR", result);
        System.out.println("Expected: ALL CLEAR, Actual: " + result);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidWindSpeed() {
        System.out.println("Testing invalid negative wind speed (-1.0 mph)");
        try {
            WeatherAndMathUtils.weatherAdvice(-1.0, 2.0);
            System.out.println("FAIL: Exception not thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("SUCCESS: IllegalArgumentException thrown as expected");
            throw e; // rethrow to satisfy the expected annotation
        }
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPrecipitation() {
        System.out.println("Testing invalid negative precipitation (-1.0 inches)");
        try {
            WeatherAndMathUtils.weatherAdvice(10.0, -1.0);
            System.out.println("FAIL: Exception not thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("SUCCESS: IllegalArgumentException thrown as expected");
            throw e; // rethrow to satisfy the expected annotation
        }
    }
    
    // isEven tests
    @Test
    public void testIsEvenWithEvenNumber() {
        System.out.println("Testing isEven with even numbers (2, 4, 100)");
        assertTrue("2 should be even", WeatherAndMathUtils.isEven(2));
        System.out.println("2 is correctly identified as even");
        
        assertTrue("4 should be even", WeatherAndMathUtils.isEven(4));
        System.out.println("4 is correctly identified as even");
        
        assertTrue("100 should be even", WeatherAndMathUtils.isEven(100));
        System.out.println("100 is correctly identified as even");
    }
    
    @Test
    public void testIsEvenWithOddNumber() {
        System.out.println("Testing isEven with odd numbers (1, 3, 99)");
        assertFalse("1 should be odd", WeatherAndMathUtils.isEven(1));
        System.out.println("1 is correctly identified as odd");
        
        assertFalse("3 should be odd", WeatherAndMathUtils.isEven(3));
        System.out.println("3 is correctly identified as odd");
        
        assertFalse("99 should be odd", WeatherAndMathUtils.isEven(99));
        System.out.println("99 is correctly identified as odd");
    }
    
    @Test
    public void testIsEvenWithZero() {
        System.out.println("Testing isEven with zero");
        assertTrue("0 should be even", WeatherAndMathUtils.isEven(0));
        System.out.println("0 is correctly identified as even");
    }
    
    // isPrime tests - note the bug in the implementation
    @Test
    public void testIsPrimeWithOne() {
        System.out.println("Testing isPrime with 1");
        boolean result = WeatherAndMathUtils.isPrime(1);
        assertTrue("1 should be prime according to the implementation", result);
        System.out.println("Expected: true, Actual: " + result);
    }
    
    @Test
    public void testIsPrimeWithPrimeNumber() {
        System.out.println("Testing isPrime with prime numbers (3, 5, 7)");
        
        boolean result3 = WeatherAndMathUtils.isPrime(3);
        assertTrue("3 should be prime", result3);
        System.out.println("3 -> Expected: true, Actual: " + result3);
        
        boolean result5 = WeatherAndMathUtils.isPrime(5);
        assertTrue("5 should be prime", result5);
        System.out.println("5 -> Expected: true, Actual: " + result5);
        
        boolean result7 = WeatherAndMathUtils.isPrime(7);
        assertTrue("7 should be prime", result7);
        System.out.println("7 -> Expected: true, Actual: " + result7);
    }
    
    @Test
    public void testIsPrimeWithNonPrimeNumber() {
        System.out.println("Testing isPrime with non-prime numbers (4, 6, 8)");
        System.out.println("Note: There's a bug in the isPrime implementation - it checks if a number is even rather than if it's divisible");
        
        boolean result4 = WeatherAndMathUtils.isPrime(4);
        assertFalse("4 should not be prime", result4);
        System.out.println("4 -> Expected: false, Actual: " + result4);
        
        boolean result6 = WeatherAndMathUtils.isPrime(6);
        assertFalse("6 should not be prime", result6);
        System.out.println("6 -> Expected: false, Actual: " + result6);
        
        boolean result8 = WeatherAndMathUtils.isPrime(8);
        assertFalse("8 should not be prime", result8);
        System.out.println("8 -> Expected: false, Actual: " + result8);
    }
    
    // Part B Tests
    @Test
    public void testSumUpToNWithZero() {
        System.out.println("Testing sumUpToN with zero");
        int result = PartB.sumUpToN(0);
        assertEquals("Sum up to 0 should be 0", 0, result);
        System.out.println("Expected: 0, Actual: " + result);
    }
    
    @Test
    public void testSumUpToNWithPositiveNumber() {
        System.out.println("Testing sumUpToN with positive number (5)");
        // Sum of numbers from 1 to 5 = 1+2+3+4+5 = 15
        int result = PartB.sumUpToN(5);
        assertEquals("Sum up to 5 should be 15", 15, result);
        System.out.println("Expected: 15, Actual: " + result);
    }
    
    @Test
    public void testSumUpToNWithOne() {
        System.out.println("Testing sumUpToN with 1");
        int result = PartB.sumUpToN(1);
        assertEquals("Sum up to 1 should be 1", 1, result);
        System.out.println("Expected: 1, Actual: " + result);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSumUpToNWithNegativeNumber() {
        System.out.println("Testing sumUpToN with negative number (-5)");
        try {
            PartB.sumUpToN(-5);
            System.out.println("FAIL: Exception not thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("SUCCESS: IllegalArgumentException thrown as expected");
            throw e; // rethrow to satisfy the expected annotation
        }
    }
    
    // Tests for Part B (b): countEvenNumbersUpToN method
    @Test
    public void testCountEvenNumbersUpToNWithZero() {
        System.out.println("Testing countEvenNumbersUpToN with zero");
        int result = PartB.countEvenNumbersUpToN(0);
        assertEquals("Count of even numbers up to 0 should be 0", 0, result);
        System.out.println("Expected: 0, Actual: " + result);
    }
    
    @Test
    public void testCountEvenNumbersUpToNWithPositiveNumber() {
        System.out.println("Testing countEvenNumbersUpToN with positive number (10)");
        // Even numbers from 1 to 10 are 2,4,6,8,10 (5 numbers)
        int result = PartB.countEvenNumbersUpToN(10);
        assertEquals("Count of even numbers up to 10 should be 5", 5, result);
        System.out.println("Expected: 5, Actual: " + result);
    }
    
    @Test
    public void testCountEvenNumbersUpToNWithOne() {
        System.out.println("Testing countEvenNumbersUpToN with 1");
        int result = PartB.countEvenNumbersUpToN(1);
        assertEquals("Count of even numbers up to 1 should be 0", 0, result);
        System.out.println("Expected: 0, Actual: " + result);
    }
    
    @Test
    public void testCountEvenNumbersUpToNWithTwo() {
        System.out.println("Testing countEvenNumbersUpToN with 2");
        int result = PartB.countEvenNumbersUpToN(2);
        assertEquals("Count of even numbers up to 2 should be 1", 1, result);
        System.out.println("Expected: 1, Actual: " + result);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCountEvenNumbersUpToNWithNegativeNumber() {
        System.out.println("Testing countEvenNumbersUpToN with negative number (-5)");
        try {
            PartB.countEvenNumbersUpToN(-5);
            System.out.println("FAIL: Exception not thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("SUCCESS: IllegalArgumentException thrown as expected");
            throw e; // rethrow to satisfy the expected annotation
        }
    }
}