package sit707_week6;

public class PartB {
    
    /**
     * Part B (a): Function with a conditional loop containing simple instructions
     * This function calculates the sum of all numbers from 1 to n
     * 
     * @param n The upper bound
     * @return The sum of all numbers from 1 to n
     */
    public static int sumUpToN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        
        int sum = 0;
        // Conditional loop with simple instructions
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        
        return sum;
    }
    
    /**
     * Part B (b): Function with a conditional loop containing a conditional statement
     * This function counts how many even numbers are there from 1 to n
     * 
     * @param n The upper bound
     * @return The count of even numbers from 1 to n
     */
    public static int countEvenNumbersUpToN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        
        int count = 0;
        // Conditional loop with a conditional statement inside
        for (int i = 1; i <= n; i++) {
            // Conditional statement inside the loop
            if (i % 2 == 0) {
                count++;
            }
        }
        
        return count;
    }
}