/**
 * 
 */
package edu.cse.simplecse.simpleGoogleMaps.test;

import edu.cse.simplecse.simpleGoogleMaps.*;
import java.awt.Color;

import junit.framework.TestCase;

/**
 * @author Ori Arad
 *
 */
public class MarkerTest extends TestCase {

	private Marker marker = null;
	private Marker markerVoid = null;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.marker = new Marker(22.34, 44.56);
		this.markerVoid = new Marker();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#Marker()}.
	 */
	public void testMarkerVoid() {
		assertEquals(null, this.markerVoid.getColor());
		assertEquals(0.0, this.markerVoid.getLatitude(), 0.000001);
		assertEquals(0.0, this.markerVoid.getLongitude(), 0.000001);
		assertEquals(null, this.markerVoid.getLabel());
		assertEquals(-1, this.markerVoid.getSize());
	}
	
	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#Marker()}.
	 */
	public void testMarkerLatLong() {
		assertEquals(null, this.marker.getColor());
		assertEquals(22.34, this.marker.getLatitude(), 0.000001);
		assertEquals(44.56, this.marker.getLongitude(), 0.000001);
		assertEquals(null, this.marker.getLabel());
		assertEquals(-1, this.marker.getSize());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#getColor()}.
	 */
	public void testGetColor() {
		assertEquals(null, this.marker.getColor());
		this.marker.setColor(Color.ORANGE);
		assertEquals(Color.ORANGE, this.marker.getColor());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#setColor(java.awt.Color)}.
	 */
	public void testSetColor() {
		this.marker.setColor(Color.GRAY);
		assertEquals(Color.GRAY, this.marker.getColor());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#getLatitude()}.
	 */
	public void testGetLatitude() {
		assertEquals(22.34, this.marker.getLatitude(), 0.00001);
		this.marker.setLatitude(44.11);
		assertEquals(44.11, this.marker.getLatitude(), 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#setLatitude(double)}.
	 */
	public void testSetLatitude() {
		this.marker.setLatitude(17.65);
		assertEquals(17.65, this.marker.getLatitude(), 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#getLongitude()}.
	 */
	public void testGetLongitude() {
		assertEquals(44.56, this.marker.getLongitude(), 0.00001);
		this.marker.setLongitude(11.34);
		assertEquals(11.34, this.marker.getLongitude(), 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#setLongitude(double)}.
	 */
	public void testSetLongitude() {
		this.marker.setLongitude(87.98);
		assertEquals(87.98, this.marker.getLongitude(), 0.00001);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#getLabel()}.
	 */
	public void testGetLabel() {
		assertEquals(null, this.marker.getLabel());
		this.marker.setLabel("TestLabel");
		assertEquals("TestLabel", this.marker.getLabel());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#setLabel(java.lang.String)}.
	 */
	public void testSetLabel() {
		this.marker.setLabel("TestSetLabel");
		assertEquals("TestSetLabel", this.marker.getLabel());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#getSize()}.
	 */
	public void testGetSize() {
		assertEquals(-1, this.marker.getSize());
		this.marker.setSize(Marker.SMALL);
		assertEquals(Marker.SMALL, this.marker.getSize());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#setSize(int)}.
	 */
	public void testSetSize() {
		this.marker.setSize(Marker.TINY);
		assertEquals(Marker.TINY, this.marker.getSize());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleGoogleMaps.Marker#generateUrl()}.
	 */
	public void testGenerateUrl() {
		assertEquals("&markers=22.34,44.56", this.marker.generateUrl());
	}

}
