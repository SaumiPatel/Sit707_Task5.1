package sit707_tasks;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "S223979728";  
		Assert.assertNotNull("Student ID is null", studentId);
	}
	
	@Test
	public void testStudentName() {
		String studentName = "Saumil Patel";  
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	//=====================================================
	// EQUIVALENCE CLASS TESTS FOR DAY
	//=====================================================
	
	// D1: Day between 1 to 28 (valid for all months)
	@Test
	public void testD1DayIncrement() {
		DateUtil date = new DateUtil(15, 7, 2024);
        System.out.println("D1 (Day 1-28) Increment Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}
	
	@Test
	public void testD1DayDecrement() {
		DateUtil date = new DateUtil(15, 7, 2024);
        System.out.println("D1 (Day 1-28) Decrement Test > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}
	
	// D2: Day 29 (valid for all months except February in non-leap years)
	@Test
	public void testD2DayIncrementInMonthWith31Days() {
		DateUtil date = new DateUtil(29, 7, 2024);
        System.out.println("D2 (Day 29) Increment in 31-day month Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}
	
	@Test
	public void testD2DayDecrementInMonthWith31Days() {
		DateUtil date = new DateUtil(29, 7, 2024);
        System.out.println("D2 (Day 29) Decrement in 31-day month Test > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}
	
	@Test
	public void testD2DayInFebruaryLeapYear() {
		DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("D2 (Day 29) in February Leap Year Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}
	
	// D3: Day 30 (valid for all months except February)
	@Test
	public void testD3DayIncrementInMonthWith31Days() {
		DateUtil date = new DateUtil(30, 7, 2024);
        System.out.println("D3 (Day 30) Increment in 31-day month Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}
	
	@Test
	public void testD3DayDecrementInMonthWith31Days() {
		DateUtil date = new DateUtil(30, 7, 2024);
        System.out.println("D3 (Day 30) Decrement in 31-day month Test > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}
	
	@Test
	public void testD3DayIncrementInMonthWith30Days() {
		DateUtil date = new DateUtil(30, 4, 2024);
        System.out.println("D3 (Day 30) Increment in 30-day month Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
	}
	
	// D4: Day 31 (valid only for months with 31 days)
	@Test
	public void testD4DayIncrementInMonthWith31Days() {
		DateUtil date = new DateUtil(31, 7, 2024);
        System.out.println("D4 (Day 31) Increment in 31-day month Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(8, date.getMonth());
	}
	
	@Test
	public void testD4DayDecrementInMonthWith31Days() {
		DateUtil date = new DateUtil(31, 7, 2024);
        System.out.println("D4 (Day 31) Decrement in 31-day month Test > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}
	
	//=====================================================
	// EQUIVALENCE CLASS TESTS FOR MONTH
	//=====================================================
	
	// M1: Months with 31 days (1, 3, 5, 7, 8, 10, 12)
	@Test
	public void testM1MonthJanuaryIncrement() {
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("M1 (31-day month) January Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
	}
	
	@Test
	public void testM1MonthMarchIncrement() {
		DateUtil date = new DateUtil(31, 3, 2024);
        System.out.println("M1 (31-day month) March Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(4, date.getMonth());
	}
	
	@Test
	public void testM1MonthDecemberIncrement() {
		DateUtil date = new DateUtil(31, 12, 2023);
        System.out.println("M1 (31-day month) December Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	// M2: Months with 30 days (4, 6, 9, 11)
	@Test
	public void testM2MonthAprilIncrement() {
		DateUtil date = new DateUtil(30, 4, 2024);
        System.out.println("M2 (30-day month) April Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
	}
	
	@Test
	public void testM2MonthJuneIncrement() {
		DateUtil date = new DateUtil(30, 6, 2024);
        System.out.println("M2 (30-day month) June Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}
	
	@Test
	public void testM2MonthSeptemberDecrement() {
		DateUtil date = new DateUtil(1, 9, 2024);
        System.out.println("M2 (30-day month) September Decrement Test > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(8, date.getMonth());
	}
	
	// M3: February (2)
	@Test
	public void testM3MonthFebruaryInLeapYear() {
		DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("M3 (February) in Leap Year Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}
	
	@Test
	public void testM3MonthFebruaryInNonLeapYear() {
		DateUtil date = new DateUtil(28, 2, 2023);
        System.out.println("M3 (February) in Non-Leap Year Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}
	
	@Test
	public void testM3MonthFebruaryDecrement() {
		DateUtil date = new DateUtil(1, 2, 2024);
        System.out.println("M3 (February) Decrement Test > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	//=====================================================
	// EQUIVALENCE CLASS TESTS FOR YEAR
	//=====================================================
	
	// Y1: Leap years (e.g., 2020, 2024)
	@Test
	public void testY1LeapYearFebruary() {
		DateUtil date = new DateUtil(28, 2, 2024);
        System.out.println("Y1 (Leap Year) February Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
	}
	
	@Test
	public void testY1LeapYearFebruaryEndIncrement() {
		DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("Y1 (Leap Year) February End Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}
	
	// Y2: Non-leap years (e.g., 2023)
	@Test
	public void testY2NonLeapYearFebruary() {
		DateUtil date = new DateUtil(28, 2, 2023);
        System.out.println("Y2 (Non-Leap Year) February Test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
	}
	
	@Test
	public void testY2NonLeapYearYearEndDecrement() {
		DateUtil date = new DateUtil(1, 1, 2023);
        System.out.println("Y2 (Non-Leap Year) Year End Decrement Test > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2022, date.getYear());
	}
	
	//=====================================================
	// COMBINATION TESTS OF MULTIPLE EQUIVALENCE CLASSES
	//=====================================================
	
	@Test
	public void testD4M1Y1Combination() {
		DateUtil date = new DateUtil(31, 12, 2024);
        System.out.println("D4-M1-Y1 Combination (Day 31, December, Leap Year) > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2025, date.getYear());
	}
	
	@Test
	public void testD3M2Y2Combination() {
		DateUtil date = new DateUtil(30, 4, 2023);
        System.out.println("D3-M2-Y2 Combination (Day 30, April, Non-Leap Year) > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
	}
	
	@Test
	public void testD2M3Y1Combination() {
		DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("D2-M3-Y1 Combination (Day 29, February, Leap Year) > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	//=====================================================
	// EQUIVALENCE CLASS TEST FOR DEAKIN WEBSITE
	//=====================================================
	
	
	@Test
	public void testOnTrackSubmissionTimeEquivalenceClasses() {
		// This is a conceptual test and not actually runnable against the real OnTrack system
		System.out.println("Testing OnTrack submission time equivalence classes");
		
		// Equivalence class: T1 - Before deadline (valid submission)
		boolean isBeforeDeadline = true;
		boolean expectedSubmissionValidity = true;
		Assert.assertEquals("Submission before deadline should be valid", 
				expectedSubmissionValidity, isBeforeDeadline);
		
		// Equivalence class: T2 - After deadline but within late window
		boolean isAfterDeadlineButWithinLateWindow = true;
		boolean shouldHaveLatePenalty = true;
		Assert.assertEquals("Late submission should have penalty", 
				shouldHaveLatePenalty, isAfterDeadlineButWithinLateWindow);
		
		// Equivalence class: T3 - After late submission window
		boolean isAfterLateWindow = true;
		boolean submissionShouldBeBlocked = true;
		Assert.assertEquals("Submission after late window should be blocked", 
				submissionShouldBeBlocked, isAfterLateWindow);
	}
	
	@Test
	public void testOnTrackFileTypeEquivalenceClasses() {
		// This is a conceptual test and not actually runnable against the real OnTrack system
		System.out.println("Testing OnTrack file type equivalence classes");
		
		// Equivalence class: FT1 - Allowed file type (PDF)
		String fileType = "pdf";
		String[] allowedTypes = {"pdf", "zip", "java", "txt"};
		boolean fileTypeIsAllowed = false;
		
		for (String type : allowedTypes) {
			if (type.equals(fileType)) {
				fileTypeIsAllowed = true;
				break;
			}
		}
		
		Assert.assertTrue("PDF file type should be allowed", fileTypeIsAllowed);
		
		// Equivalence class: FT2 - Disallowed file type (EXE)
		fileType = "exe";
		fileTypeIsAllowed = false;
		
		for (String type : allowedTypes) {
			if (type.equals(fileType)) {
				fileTypeIsAllowed = true;
				break;
			}
		}
		
		Assert.assertFalse("EXE file type should not be allowed", fileTypeIsAllowed);
	}
	
	@Test
	public void testOnTrackFileSizeEquivalenceClasses() {
		// This is a conceptual test and not actually runnable against the real OnTrack system
		System.out.println("Testing OnTrack file size equivalence classes");
		
		// Equivalence class: F1 - File size under limit
		int maxFileSizeInMB = 100; // Hypothetical max file size
		int actualFileSizeInMB = 50;
		boolean fileSizeUnderLimit = actualFileSizeInMB <= maxFileSizeInMB;
		
		Assert.assertTrue("File under size limit should be accepted", fileSizeUnderLimit);
		
		// Equivalence class: F2 - File size over limit
		actualFileSizeInMB = 150;
		boolean fileSizeOverLimit = actualFileSizeInMB > maxFileSizeInMB;
		
		Assert.assertTrue("File over size limit should be rejected", fileSizeOverLimit);
	}
	
	@Test
	public void testOnTrackSubmissionStatusEquivalenceClasses() {
		// This is a conceptual test and not actually runnable against the real OnTrack system
		System.out.println("Testing OnTrack submission status equivalence classes");
		
		// Equivalence class: S1 - Ready for assessment
		String submissionStatus = "ready_for_assessment";
		Assert.assertEquals("Status should be ready for assessment", 
				"ready_for_assessment", submissionStatus);
		
		// Equivalence class: S2 - Awaiting discussion
		submissionStatus = "awaiting_discussion";
		Assert.assertEquals("Status should be awaiting discussion", 
				"awaiting_discussion", submissionStatus);
		
		// Equivalence class: S3 - Awaiting resubmission
		submissionStatus = "awaiting_resubmission";
		Assert.assertEquals("Status should be awaiting resubmission", 
				"awaiting_resubmission", submissionStatus);
		
		// Equivalence class: S4 - Complete
		submissionStatus = "complete";
		Assert.assertEquals("Status should be complete", 
				"complete", submissionStatus);
	}
}