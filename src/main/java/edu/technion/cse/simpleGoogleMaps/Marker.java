/* COPYRIGHT (C) 2012 Ori Arad. All Rights Reserved. */
/* See LICENSE.txt for more details                  */

package edu.technion.cse.simpleGoogleMaps;

import java.awt.Color;

/**
 * @author Ori Arad
 *
 */
public class Marker {
	public static final int TINY = 0;
	public static final int MID = 1;
	public static final int SMALL = 2;
	private Color color = null;
	private double latitude = 0.0;
	private double longitude = 0.0;
	private String label = null;
	private int size = -1;
	private static final String[] SIZES = {"tiny", "mid", "small"};
	/**
	 * 
	 */
	public Marker() {
		
	}
	
	/**
	 * 
	 */
	public Marker(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * 
	 */
	public Marker(double latitude, double longitude, Color color) {
		this(latitude, longitude);
		this.color = color;		
	}
	
	/**
	 * @return the color
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return this.latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return this.longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return
	 */
	public String generateUrl() {
		StringBuilder sb = new StringBuilder("&markers=");
		if ((this.size >= TINY) && (this.size <= SMALL)) {
			sb.append("size:" + SIZES[this.size] + "%7C");
		}
		if (this.color != null) {			
			sb.append("color:0x"+ Integer.toHexString(this.color.getRGB()).substring(2)+"%7C");
		}
		
		if (this.label != null) {			
			sb.append("label:"+ this.label.charAt(0) + "%7C");
		}
		
		sb.append(this.latitude + "," + this.longitude);
		
		return sb.toString();
	}

}
