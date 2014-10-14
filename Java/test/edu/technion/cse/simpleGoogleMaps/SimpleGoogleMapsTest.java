/**
 * 
 */
package edu.technion.cse.simpleGoogleMaps;

import junit.framework.TestCase;

/**
 * @author Ori Arad
 *
 */
public class SimpleGoogleMapsTest extends TestCase {
	private SimpleGoogleMaps sgm;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.sgm = new SimpleGoogleMaps();
		this.sgm.setLatitude(40.714728);
		this.sgm.setLongitude(-73.998672);
		this.sgm.setScale(1);
		this.sgm.setZoom(11);
		this.sgm.setWidth(630);
		this.sgm.setHeight(620);
		this.sgm.setWindowTitle("Test Simple Google Maps");
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#getWidth()}.
	 */
	public void testGetWidth() {
		int expected = 630;
		int actual = this.sgm.getWidth();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#getHeight()}.
	 */
	public void testGetHeight() {
		int expected = 620;
		int actual = this.sgm.getHeight();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#getScale()}.
	 */
	public void testGetScale() {
		int expected = 1;
		int actual = this.sgm.getScale();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#setScale(int)}.
	 */
	public void testSetScale() {
		int expected = 2;
		this.sgm.setScale(expected);
		int actual = this.sgm.getScale();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#getMapType()}.
	 */
	public void testGetMapType() {
		int expected = SimpleGoogleMaps.ROADMAP;
		int actual = this.sgm.getMapType();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#setMapType(int)}.
	 */
	public void testSetMapType() {
		int expected = SimpleGoogleMaps.HYBRID;
		this.sgm.setMapType(expected);
		int actual = this.sgm.getMapType();
		assertEquals(expected, actual);
	}


	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#setWidth(int)}.
	 */
	public void testSetWidth() {
		int expected = 333;
		this.sgm.setWidth(expected);
		int actual = this.sgm.getWidth();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#setHeight(int)}.
	 */
	public void testSetHeight() {
		int expected = 400;
		this.sgm.setHeight(expected);
		int actual = this.sgm.getHeight();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#getZoom()}.
	 */
	public void testGetZoom() {
		int expected = 11;
		int actual = this.sgm.getZoom();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#setZoom(int)}.
	 */
	public void testSetZoom() {
		int expected = 10;
		this.sgm.setZoom(expected);
		int actual = this.sgm.getZoom();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#getLatitude()}.
	 */
	public void testGetLatitude() {
		double expected = 40.714728;
		double actual = this.sgm.getLatitude();
		assertEquals(expected, actual, 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#setLatitude(double)}.
	 */
	public void testSetLatitude() {
		double expected = 42.4538;
		this.sgm.setLatitude(expected);
		double actual = this.sgm.getLatitude();
		assertEquals(expected, actual, 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#getLongitude()}.
	 */
	public void testGetLongitude() {
		double expected = -73.998672;
		double actual = this.sgm.getLongitude();
		assertEquals(expected, actual, 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#setLongitude(double)}.
	 */
	public void testSetLongitude() {
		double expected = 14.1212;
		this.sgm.setLongitude(expected);
		double actual = this.sgm.getLongitude();
		assertEquals(expected, actual, 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#getWindowTitle()}.
	 */
	public void testGetWindowTitle() {		
		String expected = "Test Simple Google Maps";
		String actual = this.sgm.getWindowTitle();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#setWindowTitle(java.lang.String)}.
	 */
	public void testSetWindowTitle() {
		String expected = "setWindowTitle Test";
		this.sgm.setWindowTitle(expected);
		String actual = this.sgm.getWindowTitle();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#generateUrl()}.
	 */
	public void testGenerateUrl() {
		String expected = "http://maps.googleapis.com/maps/api/staticmap?center=40.714728,-73.998672&zoom=11&size=620x630&maptype=roadmap&scale=1&language=iw&sensor=false";
		String actual = this.sgm.generateUrl();
		assertEquals(expected, actual);
	}


	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#SimpleGoogleMaps()}.
	 */
	public void testSimpleGoogleMaps() {
		assertEquals(this.sgm.getLatitude(),40.714728, 0.00001);
		assertEquals(this.sgm.getLongitude(),-73.998672, 0.00001);
		assertEquals(this.sgm.getScale(),1);
		assertEquals(this.sgm.getZoom(),11);
		assertEquals(this.sgm.getWidth(),630);
		assertEquals(this.sgm.getHeight(),620);
		assertEquals(this.sgm.getWindowTitle(),"Test Simple Google Maps");
	}


	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#addMarker(edu.technion.cse.simpleGoogleMaps.Marker)}.
	 */
	public void testAddMarker() {
		this.sgm.addMarker(new Marker(12.34, 23.54));
		assertTrue(this.sgm.generateUrl().indexOf("&markers=12.34,23.54") != -1);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps#addPath(edu.technion.cse.simpleGoogleMaps.Path)}.
	 */
	public void testAddPath() {
		this.sgm.addPath(new Path(33.44, 66.87));
		assertTrue(this.sgm.generateUrl().indexOf("&path=33.44,66.87") != -1);
	}

}
