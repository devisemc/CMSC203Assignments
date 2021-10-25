

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany mgmt;
	@Before
	public void setUp() throws Exception {
		//student create a management company
		mgmt = new ManagementCompany();
		//student add three properties, with plots, to mgmt co
		mgmt.addProperty("property1", "city1", 250, "owner1", 6, 6, 1, 1);
		mgmt.addProperty("property2", "city2", 500, "owner2", 3, 3, 1, 1);
		mgmt.addProperty("property3", "city3", 750, "owner3", 5, 5, 1, 1);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		mgmt = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(mgmt.addProperty("property4", "city4", 300, "owner4", 0, 0, 1, 1), 3);
		//student should add property with 8 args
		assertEquals(mgmt.addProperty("property5", "city5", 423, "owner5", 7, 5, 1, 1), 4);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		assertEquals(mgmt.addProperty("prop6", "city6", 450, "owner6", 1, 1, 1, 1), -1);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(mgmt.maxRentProp(), 750.0, 0);
	}

	@Test
	public void testTotalRent() {
		assertEquals(mgmt.totalRent(), 1500.0, 0);
		//student should test if totalRent returns the total rent of properties
	}

 }
