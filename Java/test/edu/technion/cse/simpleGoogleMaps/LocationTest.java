/**
 * 
 */
package edu.technion.cse.simpleGoogleMaps;

import junit.framework.TestCase;

/**
 * @author Ori Arad
 *
 */
public class LocationTest extends TestCase {
	Location loc = null;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.loc = new Location(34.56, 44.55);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Location#Location(double, double)}.
	 */
	public void testLocationLatitude() {
		assertEquals(34.56, this.loc.getLatitude(), 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Location#Location(double, double)}.
	 */
	public void testLocationLongitude() {
		assertEquals(44.55, this.loc.getLongitude(), 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Location#getLatitude()}.
	 */
	public void testGetLatitude() {
		assertEquals(34.56, this.loc.getLatitude(), 0.00001);
		this.loc.setLatitude(55.22);
		assertEquals(55.22, this.loc.getLatitude(), 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Location#setLatitude(double)}.
	 */
	public void testSetLatitude() {
		this.loc.setLatitude(87.45);
		assertEquals(87.45, this.loc.getLatitude(), 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Location#getLongitude()}.
	 */
	public void testGetLongitude() {
		assertEquals(44.55, this.loc.getLongitude(), 0.00001);
		this.loc.setLongitude(11.34);
		assertEquals(11.34, this.loc.getLongitude(), 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Location#setLongitude(double)}.
	 */
	public void testSetLongitude() {
		this.loc.setLongitude(78.78);
		assertEquals(78.78, this.loc.getLongitude(), 0.00001);
	}

}
