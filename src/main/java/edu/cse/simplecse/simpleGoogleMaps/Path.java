/* COPYRIGHT (C) 2012 Ori Arad. All Rights Reserved. */
/* See LICENSE.txt for more details                  */

package edu.cse.simplecse.simpleGoogleMaps;

import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Ori Arad
 *
 */
public class Path {
	private Color color = null;
	private Color fillColor = null;
	private int weight = 0;
	ArrayList<Location> points = null;
	private boolean geodesic = false;
	
	
	/**
	 *  
	 */
	public Path(double latitude, double longitude) {
		this.points = new ArrayList<>();
		addPoint(latitude, longitude);
		
	}
	
	/**
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}	
	
	/**
	 * @param latitude
	 * @param longitude
	 */
	public void addPoint(double latitude, double longitude) {
		this.points.add(new Location(latitude, longitude));
		
	}	
	
	/**
	 * @return
	 */
	public String generateUrl() {
		StringBuilder sb = new StringBuilder("&path=");
		if (this.weight > 0) {
			sb.append("weight:" + this.weight + "%7C");
		}
		if (this.color != null) {			
			String original = Integer.toHexString(this.color.getRGB());
			String tmp = original.concat(original.substring(0, 2)).substring(2);
			sb.append("color:0x"+ tmp +"%7C");
		}
		
		for(Location point : this.points) {
			sb.append(point.getLatitude() + "," + point.getLongitude() + '|');			
		}
		
		// Remove unnecessary last '|' if needed
		if (sb.charAt(sb.length() - 1) == '|') {
			sb.deleteCharAt(sb.length() - 1);
		}
		
		return sb.toString();
	}

	/**
	 * @return the fillColor
	 */
	public Color getFillColor() {
		return this.fillColor;
	}

	/**
	 * @param fillColor the fillColor to set
	 */
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return this.weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the geodesic
	 */
	public boolean isGeodesic() {
		return this.geodesic;
	}

	/**
	 * @param geodesic the geodesic to set
	 */
	public void setGeodesic(boolean geodesic) {
		this.geodesic = geodesic;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * @return the points
	 */
	public ArrayList<Location> getPoints() {
		return this.points;
	}

}
