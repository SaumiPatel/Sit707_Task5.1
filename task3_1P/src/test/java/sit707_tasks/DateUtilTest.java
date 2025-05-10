package sit707_tasks;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
/**
 * @author Your-Name-Here
 */
public class DateUtilTest {
	
	//=====================================================
	// ORIGINAL TEST CASES PROVIDED IN THE STARTER CODE
	//=====================================================
	
	@Test
	public void testMainFunction() {
	    System.out.println("\n======= Running Main.java demonstration =======\n");
	    // Call the main method with empty args array
	    String[] args = new String[0];
	    Main.main(args);
	    System.out.println("\n======= End of Main.java demonstration =======\n");
	    
	    // No assertions needed - just calling the method for coverage
	    // The test will pass as long as Main.main() doesn't throw exceptions
	}
	@Test
	public void testStudentIdentity() {
		String studentId = "S223979728";  // Replace with your student ID
		Assert.assertNotNull("Student ID is null", studentId);
	}
	
	@Test
	public void testStudentName() {
		String studentName = "Saumil Patel";  // Replace with your name
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		// January min boundary area: min+1
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("january1ShouldIncrementToJanuary2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		// January min boundary area: min-1
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("january1ShouldDecrementToDecember31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
	}
	
	//=====================================================
	// GREEN TABLE TEST CASES (PREVIOUS DATE TESTS: 1A-13A)
	//=====================================================
	
	@Test
	public void test1APreviousDate() {
		DateUtil date = new DateUtil(1, 6, 1994);
        System.out.println("Test case 1A > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test2APreviousDate() {
		DateUtil date = new DateUtil(2, 6, 1994);
        System.out.println("Test case 2A > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test3APreviousDate() {
		DateUtil date = new DateUtil(15, 6, 1994);
        System.out.println("Test case 3A > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test4APreviousDate() {
		DateUtil date = new DateUtil(30, 6, 1994);
        System.out.println("Test case 4A > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test5APreviousDate() {
		// This tests an invalid date (31 June) - should throw an exception
		try {
			DateUtil date = new DateUtil(31, 6, 1994);
			System.out.println("This should not execute as 31 June is invalid");
			Assert.fail("Should have thrown an exception for invalid date");
		} catch (RuntimeException e) {
			System.out.println("Test case 5A > Correctly caught invalid date: 31 June 1994");
			System.out.println(e.getMessage());
			Assert.assertTrue(e.getMessage().contains("Invalid day"));
		}
	}
	
	@Test
	public void test6APreviousDate() {
		DateUtil date = new DateUtil(15, 1, 1994);
        System.out.println("Test case 6A > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test7APreviousDate() {
		DateUtil date = new DateUtil(15, 2, 1994);
        System.out.println("Test case 7A > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test8APreviousDate() {
		DateUtil date = new DateUtil(15, 11, 1994);
        System.out.println("Test case 8A > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test9APreviousDate() {
		DateUtil date = new DateUtil(15, 12, 1994);
        System.out.println("Test case 9A > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test10APreviousDate() {
		DateUtil date = new DateUtil(15, 6, 1700);
        System.out.println("Test case 10A > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1700, date.getYear());
	}
	
	@Test
	public void test11APreviousDate() {
		DateUtil date = new DateUtil(15, 6, 1701);
        System.out.println("Test case 11A > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1701, date.getYear());
	}
	
	@Test
	public void test12APreviousDate() {
		DateUtil date = new DateUtil(15, 6, 2023);
        System.out.println("Test case 12A > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
	}
	
	@Test
	public void test13APreviousDate() {
		DateUtil date = new DateUtil(15, 6, 2024);
        System.out.println("Test case 13A > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	//=====================================================
	// ORANGE TABLE TEST CASES (NEXT DATE TESTS: 1B-13B)
	//=====================================================
	
	@Test
	public void test1BNextDate() {
		DateUtil date = new DateUtil(1, 6, 1994);
        System.out.println("Test case 1B > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test2BNextDate() {
		DateUtil date = new DateUtil(2, 6, 1994);
        System.out.println("Test case 2B > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test3BNextDate() {
		DateUtil date = new DateUtil(15, 6, 1994);
        System.out.println("Test case 3B > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test4BNextDate() {
		DateUtil date = new DateUtil(30, 6, 1994);
        System.out.println("Test case 4B > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test5BNextDate() {
		// This tests an invalid date (31 June) - should throw an exception
		try {
			DateUtil date = new DateUtil(31, 6, 1994);
			System.out.println("This should not execute as 31 June is invalid");
			Assert.fail("Should have thrown an exception for invalid date");
		} catch (RuntimeException e) {
			System.out.println("Test case 5B > Correctly caught invalid date: 31 June 1994");
			System.out.println(e.getMessage());
			Assert.assertTrue(e.getMessage().contains("Invalid day"));
		}
	}
	
	@Test
	public void test6BNextDate() {
		DateUtil date = new DateUtil(15, 1, 1994);
        System.out.println("Test case 6B > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test7BNextDate() {
		DateUtil date = new DateUtil(15, 2, 1994);
        System.out.println("Test case 7B > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test8BNextDate() {
		DateUtil date = new DateUtil(15, 11, 1994);
        System.out.println("Test case 8B > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test9BNextDate() {
		DateUtil date = new DateUtil(15, 12, 1994);
        System.out.println("Test case 9B > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	@Test
	public void test10BNextDate() {
		DateUtil date = new DateUtil(15, 6, 1700);
        System.out.println("Test case 10B > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1700, date.getYear());
	}
	
	@Test
	public void test11BNextDate() {
		DateUtil date = new DateUtil(15, 6, 1701);
        System.out.println("Test case 11B > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1701, date.getYear());
	}
	
	@Test
	public void test12BNextDate() {
		DateUtil date = new DateUtil(15, 6, 2023);
        System.out.println("Test case 12B > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
	}
	
	@Test
	public void test13BNextDate() {
		DateUtil date = new DateUtil(15, 6, 2024);
        System.out.println("Test case 13B > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	//=====================================================
	// EXTRA TEST CASES FOR FEBRUARY WITH LEAP YEAR CONDITION
	//=====================================================
	
	@Test
	public void testFebruaryLeapYear() {
		DateUtil date = new DateUtil(28, 2, 2024);
        System.out.println("February Leap Year Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay()); // In leap year, Feb 28 + 1 = Feb 29
        Assert.assertEquals(2, date.getMonth());
	}
	
	@Test
	public void testFebruaryLeapYearMax() {
		DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("February Leap Year Max Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay()); // In leap year, Feb 29 + 1 = Mar 1
        Assert.assertEquals(3, date.getMonth());
	}
	
	@Test
	public void testFebruaryNonLeapYear() {
		DateUtil date = new DateUtil(28, 2, 2023);
        System.out.println("February Non-Leap Year Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay()); // In non-leap year, Feb 28 + 1 = Mar 1
        Assert.assertEquals(3, date.getMonth());
	}
}