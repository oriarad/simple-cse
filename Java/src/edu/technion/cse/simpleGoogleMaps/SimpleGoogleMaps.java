
/* COPYRIGHT (C) 2012 Ori Arad. All Rights Reserved. */
/* See LICENSE.txt for more details                  */

package edu.technion.cse.simpleGoogleMaps;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * This class provide a simple API to Google-Maps services.
 * It allows the user to generate a Google-Maps image, or a URL
 * to be used in a browser. 
 *<p>
 *Example:
 *<code>
 *SimpleGoogleMaps sgm = new SimpleGoogleMaps();
 *
 *sgm.setLatitude(32.776760);
 *sgm.setLongitude(35.027222);    
 *sgm.setZoom(17);
 *sgm.setWidth(640);
 *sgm.setHeight(640);
 *sgm.setMapType(SimpleGoogleMaps.HYBRID);
 *sgm.refresh(); 
 *</code> 
 * @author Ori Arad
 * @version 0.01 14/07/12 (DD/MM/YY) 
 */
public class SimpleGoogleMaps extends Component {

	private static final long serialVersionUID = 1L;
	public static final int ROADMAP = 0;
    public static final int SATELLITE = 1;
    public static final int TERRAIN = 2;
    public static final int HYBRID = 3;	
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;
    private static final String[] MAPTYPE = {"roadmap", "satellite", "terrain", "hybrid"};
    private JFrame frame;
    private BufferedImage img;
    private Dimension dimension;
    private int zoom = 12;
    private double latitude = 0.0;
    private double longitude= 0.0;
    private int scale = 1;
	private int mapType = ROADMAP;
    private String windowTitle = "SimpleGoogleMaps";
    private ArrayList<Marker> markers = null;
    private ArrayList<Path> paths = null;
    
    public int getScale() {
		return this.scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getMapType() {
		return this.mapType;
	}

	public void setMapType(int mapType) {
		this.mapType = mapType;
	}
    
    public Dimension getDimension() {
		return this.dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
    @Override
	public int getWidth() {
		return (int)this.dimension.getWidth();
	}

	public void setWidth(int width) {
		this.dimension.setSize(width, getHeight());
	}
	
    @Override
	public int getHeight() {
		return (int)this.dimension.getHeight();
	}

	public void setHeight(int height) {
		this.dimension.setSize(getWidth(), height);
	}

	public int getZoom() {
		return this.zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

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
	 * @return the windowTitle
	 */
	public String getWindowTitle() {
		return this.windowTitle;
	}

	/**
	 * @param windowTitle the windowTitle to set
	 */
	public void setWindowTitle(String windowTitle) {
		this.windowTitle = windowTitle;
	}	

	/**
	 * @return
	 * TODO Consider rename to toString
	 */
	public String generateUrl() {
    	StringBuilder str = new StringBuilder("http://maps.googleapis.com/maps/api/staticmap?center=");
    	str.append(this.latitude);
    	str.append(",");
    	str.append(this.longitude);
    	str.append("&zoom=");
    	str.append(this.zoom);
    	str.append("&size=");
    	str.append((int)this.dimension.getHeight());
    	str.append("x");
    	str.append((int)this.dimension.getWidth());
    	str.append("&maptype=");
    	str.append(MAPTYPE[this.mapType]);    	    	
    	str.append("&scale=");
    	str.append(this.scale);   
    	for (Marker marker : this.markers) {
    		str.append(marker.generateUrl());
    	}
    	for (Path path : this.paths) {
    		str.append(path.generateUrl());
    	}
    	str.append("&language=iw&sensor=false");  
    	// TODO Add free text
    	// TODO Add language option
    	// TODO Add markers & style    	

    	return str.toString();
    }

    @Override
	public void paint(Graphics g) {
        g.drawImage(this.img, 0, 0, null);
    }

    @Override
	public Dimension getPreferredSize() {
        if (this.img == null) {
             return new Dimension((int)this.dimension.getWidth(), (int)this.dimension.getHeight());
        }
        return new Dimension(this.img.getWidth(null), this.img.getHeight(null));
    }	
	
	public SimpleGoogleMaps() {
		this.frame = new JFrame(this.windowTitle);
		this.dimension = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
                      
		this.frame.addWindowListener(new WindowAdapter(){
                @Override
				public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

//        try {
//        	URL url = new URL(generateUrl());
//        	this.img = ImageIO.read(url);
//        } catch (IOException e) { // TODO
//        }
        
        this.frame.add(this);
        this.frame.pack();
        this.frame.setVisible(true);	
        this.markers = new ArrayList<>();
        this.paths = new ArrayList<>();
	}
	
	public void refresh() {
        try {
        	URL url = new URL(generateUrl());
        	this.img = ImageIO.read(url);
        } catch (IOException e) {
        	e.printStackTrace();        	
        }
        this.frame.setTitle(this.windowTitle);
        this.frame.setPreferredSize(this.dimension);
        this.frame.repaint();
        this.frame.pack();
	}
	
	public void addMarker(Marker marker) {
		this.markers.add(marker);
	}
	
	public void addPath(Path path) {
		this.paths.add(path);
	}
}

//* @todo Add street-view support:
//*       http://maps.googleapis.com/maps/api/streetview?size=600x300&location=(48.856206, 2.2976810000000114)&heading=315.47499999999997&fov=90&pitch=23.275000000000002&sensor=false
//*       http://maps.googleapis.com/maps/api/streetview?size=400x400&location=40.720032,%20-73.988354&fov=90&heading=235&pitch=10&sensor=false
//*       https://developers.google.com/maps/documentation/streetview/
//*       http://gmaps-samples.googlecode.com/svn/trunk/streetview/streetview_lazy.html
//*       http://gmaps-samples.googlecode.com/svn/trunk/
//*       http://maps.google.com/intl/iw/help/maps/streetview/learn/where-is-street-view.html  
