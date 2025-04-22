package sit707_week5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherControllerTest {
	
	// Class-level variables to store shared data
	private WeatherController wController;
	private double[] hourlyTemperatures;
	private int nHours;
	private double minTemperature;
	private double maxTemperature; 
	private double averageTemperature;
	
	@Before
	public void setUp() {
		System.out.println("+++ Setting up test environment +++");
		
		// Arrange: Initialize the controller once for all tests
		wController = WeatherController.getInstance();
		nHours = wController.getTotalHours();
		
		// Store all temperatures in an array to avoid repeated slow calls
		hourlyTemperatures = new double[nHours];
		double sumTemp = 0;
		minTemperature = Double.MAX_VALUE;
		maxTemperature = Double.MIN_VALUE;
		
		// Retrieve all hourly temperatures only once
		for (int i = 0; i < nHours; i++) {
			// Hour range: 1 to nHours
			hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
			
			// Calculate min, max and sum while retrieving temperatures
			if (minTemperature > hourlyTemperatures[i]) {
				minTemperature = hourlyTemperatures[i];
			}
			if (maxTemperature < hourlyTemperatures[i]) {
				maxTemperature = hourlyTemperatures[i];
			}
			sumTemp += hourlyTemperatures[i];
		}
		
		// Calculate average temperature
		averageTemperature = sumTemp / nHours;
	}
	
	@After
	public void tearDown() {
		System.out.println("+++ Tearing down test environment +++");
		
		// Clean up resources after all tests are done
		wController.close();
	}
	
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
	
	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");
		
		// Arrange - Already done in setUp()
		
		// Act - Get the cached minimum temperature
		double cachedMinTemperature = wController.getTemperatureMinFromCache();
		
		// Assert - Compare our calculated min with cached min
		Assert.assertEquals("Minimum temperature doesn't match", minTemperature, cachedMinTemperature, 0.0001);
	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");
		
		// Arrange - Already done in setUp()
		
		// Act - Get the cached maximum temperature
		double cachedMaxTemperature = wController.getTemperatureMaxFromCache();
		
		// Assert - Compare our calculated max with cached max
		Assert.assertEquals("Maximum temperature doesn't match", maxTemperature, cachedMaxTemperature, 0.0001);
	}
	
	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");
		
		// Arrange - Already done in setUp()
		
		// Act - Get the cached average temperature
		double cachedAverageTemperature = wController.getTemperatureAverageFromCache();
		
		// Assert - Compare our calculated average with cached average
		Assert.assertEquals("Average temperature doesn't match", averageTemperature, cachedAverageTemperature, 0.0001);
	}
	
	@Test
	public void testTemperaturePersist() {
		System.out.println("+++ testTemperaturePersist +++");
		
		// Arrange - already have controller from setUp()
		
		// Act
		String persistTime = wController.persistTemperature(10, 19.5);
		
		// Assert - verify that a timestamp is returned (not null or empty)
		Assert.assertNotNull("Persist time should not be null", persistTime);
		Assert.assertFalse("Persist time should not be empty", persistTime.isEmpty());
	}
	
	@Test
	public void testGetTemperatureForHourOutOfRange() {
		System.out.println("+++ testGetTemperatureForHourOutOfRange +++");
		
		// Arrange - using the controller from setUp()
		int invalidHour = nHours + 10; // An hour outside the valid range
		
		// Act
		double temperature = wController.getTemperatureForHour(invalidHour);
		
		// Assert - verify that a value is returned for an out-of-range hour
		// We can't assert a specific value since it's randomly selected, but we can verify it's in a reasonable range
		Assert.assertTrue("Temperature should be a valid value", temperature > 0 && temperature <= 100);
	}
	
	@Test
	public void testGetTotalHours() {
		System.out.println("+++ testGetTotalHours +++");
		
		// Arrange - using the controller from setUp()
		
		// Act - Get the total hours
		int totalHours = wController.getTotalHours();
		
		// Assert - Verify it matches the expected constant
		Assert.assertEquals("Total hours should match HOURS_PER_DAY", WeatherController.HOURS_PER_DAY, totalHours);
	}
	
	@Test
	public void testSingletonPattern() {
		System.out.println("+++ testSingletonPattern +++");
		
		// Arrange - we already have one instance from setUp()
		
		// Act - Get another instance
		WeatherController secondController = WeatherController.getInstance();
		
		// Assert - Both should reference the same object (singleton pattern)
		Assert.assertSame("Both instances should be the same object", wController, secondController);
	}
	
	@Test
	public void testCloseAndReopenController() {
		System.out.println("+++ testCloseAndReopenController +++");
		
		// Arrange
		// First, store a reference to the current controller
		WeatherController firstController = wController;
		
		// Act
		// Close the controller (this will set instance to null)
		wController.close();
		
		// Get a new instance (this will create a new controller with new random temperatures)
		wController = WeatherController.getInstance();
		
		// Assert
		// The new instance should not be the same as the previous one
		Assert.assertNotSame("New instance should be different after closing", firstController, wController);
		
		// Additional assertion: make sure the new controller is functional
		Assert.assertTrue("New controller should provide valid temperature values", 
				wController.getTemperatureMinFromCache() > 0);
	}
}