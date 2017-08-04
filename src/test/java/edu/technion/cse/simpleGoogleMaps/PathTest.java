package edu.technion.cse.simpleGoogleMaps;

import java.awt.Color;

import junit.framework.TestCase;

/**
 * @author Ori Arad
 *
 */
public class PathTest extends TestCase {
	Path path = null;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.path = new Path(34.56, 45.67);
		this.path.setColor(Color.BLACK);
		this.path.setFillColor(Color.BLUE);
		this.path.setGeodesic(true);
		this.path.setWeight(3);
		this.path.addPoint(11.0, 12.0);
		this.path.addPoint(44.33, 22.55);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Path#Path()}.
	 */
	public void testPath() {
		assertNotNull(this.path);
		assertNotNull(this.path.getPoints());
		assertEquals(3, this.path.getPoints().size());		
		assertEquals(34.56, this.path.getPoints().get(0).getLatitude(), 0.0001);
		assertEquals(45.67, this.path.getPoints().get(0).getLongitude(), 0.0001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Path#setColor(Color)}.
	 */
	public void testSetColor() {
		this.path.setColor(Color.RED);
		assertEquals("Path::setColor Failed", Color.RED, this.path.getColor());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Path#addPoint(double, double)}.
	 */
	public void testAddPoint() {
		int numberOfPoints = this.path.getPoints().size();
		this.path.addPoint(88.2, 77.3);
		assertEquals(numberOfPoints + 1, this.path.getPoints().size());
		assertEquals(88.2, this.path.getPoints().get(numberOfPoints).getLatitude(), 0.00001);
		assertEquals(77.3, this.path.getPoints().get(numberOfPoints).getLongitude(), 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Path#generateUrl()}.
	 */
	public void testGenerateUrl() {
		assertEquals("&path=weight:3%7Ccolor:0x000000ff%7C34.56,45.67|11.0,12.0|44.33,22.55", this.path.generateUrl());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Path#getFillColor()}.
	 */
	public void testGetFillColor() {
		assertEquals(Color.BLUE, this.path.getFillColor());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Path#setFillColor(Color)}.
	 */
	public void testSetFillColor() {
		this.path.setFillColor(Color.YELLOW);
		assertEquals(Color.YELLOW, this.path.getFillColor());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Path#getWeight()}.
	 */
	public void testGetWeight() {
		assertEquals(Color.BLUE, this.path.getFillColor());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Path#setWeight(int)}.
	 */
	public void testSetWeight() {
		this.path.setWeight(5);
		assertEquals(5, this.path.getWeight());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Path#isGeodesic()}.
	 */
	public void testIsGeodesic() {
		assertEquals(true, this.path.isGeodesic());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Path#setGeodesic(boolean)}.
	 */
	public void testSetGeodesic() {
		this.path.setGeodesic(false);
		assertEquals(false, this.path.isGeodesic());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Path#getColor()}.
	 */
	public void testGetColor() {
		assertEquals(Color.BLACK, this.path.getColor());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Path#getPoints()}.
	 */
	public void testGetPoints() {
		assertEquals(3, this.path.getPoints().size());
		assertEquals(34.56, this.path.getPoints().get(0).getLatitude(), 0.00001);
		assertEquals(45.67, this.path.getPoints().get(0).getLongitude(), 0.00001);
		assertEquals(11.0, this.path.getPoints().get(1).getLatitude(), 0.00001);
		assertEquals(12.0, this.path.getPoints().get(1).getLongitude(), 0.00001);
	}

}
