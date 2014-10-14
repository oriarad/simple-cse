/* COPYRIGHT (C) 2012 Ori Arad. All Rights Reserved. */
/* See LICENSE.txt for more details                  */

package edu.technion.cse.simpleImage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author Ori Arad
 *
 */
@SuppressWarnings("serial")
public class SimpleImage extends Component {
	/**
	 * 
	 */
	private BufferedImage bi;
	/**
	 * 
	 */
	private int width;
	/**
	 * 
	 */
	private int height;
	/**
	 * 
	 */
	private WritableRaster raster;

	/**
	 * 
	 */
	JFrame f = null;
	/**
	 * 
	 */
	String title = "SimpleImage - No Title";
	/**
	 * 
	 */
	String[] metaData = null;
	
	public SimpleImage() {
		
		
	}
	
	/**
	 * 
	 */
	public void load() {
		// Create a file chooser
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			load(fc.getSelectedFile());
		}
	}
	
	/**
	 * @param theWidth
	 * @param theHeight
	 */
	public void create(int theWidth, int theHeight) {
		this.width = theWidth;
		this.height = theHeight;
		this.bi = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
		Raster ras = this.bi.getData();
		this.raster = ras.createCompatibleWritableRaster();
		this.raster.setRect(ras);
		this.bi.setData(this.raster);
	}
	
	/**
	 * @param file
	 */
	public void load(File file) {
        try {        	
        	this.bi = ImageIO.read(file);
        	this.width = this.bi.getWidth(null);
        	this.height = this.bi.getHeight(null);
            if (this.bi.getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage tempBi = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
                Graphics g = tempBi.getGraphics();
                g.drawImage(this.bi, 0, 0, null);
                this.bi = tempBi;
            }
        } catch (IOException e) {
            System.out.println("err");
        }
		Raster ras = this.bi.getData();
		this.raster = ras.createCompatibleWritableRaster();
		this.raster.setRect(ras);
		this.bi.setData(this.raster);		
	}
	
	/**
	 * @param filename
	 */
	public void load(String filename) {
		load(new File(filename));
	}
	
	/**
	 * @param filename
	 */
	public void loadUrl(String url) {
        try {        	
        	this.bi = ImageIO.read(new URL(url));
        	this.width = this.bi.getWidth(null);
        	this.height = this.bi.getHeight(null);
            if (this.bi.getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage tempBi = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
                Graphics g = tempBi.getGraphics();
                g.drawImage(this.bi, 0, 0, null);
                this.bi = tempBi;
            }
        } catch (IOException e) {
            System.out.println("err");
        }
		Raster ras = this.bi.getData();
		this.raster = ras.createCompatibleWritableRaster();
		this.raster.setRect(ras);
		this.bi.setData(this.raster);
	}
	
	/**
	 * @param x
	 * @param y
	 * @return The "red" value of the pixel in (x, y)
	 */
	public int getRed(int x, int y){
		return (this.bi.getRGB(x, y) & 0xFF0000) >> 16;
	}
	
	/**
	 * @param x
	 * @param y
	 * @return The "green" value of the pixel in (x, y)
	 */
	public int getGreen(int x, int y){
		return (this.bi.getRGB(x, y) & 0x00FF00) >> 8;
	}
	
	/**
	 * @param x
	 * @param y
	 * @return The "blue" value of the pixel in (x, y)
	 */
	public int getBlue(int x, int y){
		return (this.bi.getRGB(x, y) & 0xFF);
	}
	
	/**
	 * @return The "red" values of the image as two dimensional array
	 */
	public int[][] getRed() {
		int[][] result = new int[this.width][this.height];
		for (int i = 0; i < this.width; ++i) {
			result[i] = new int[this.height];
			for (int j = 0; j < this.height; ++j) {
				result[i][j] = getRed(i, j);				
			}		
		}		
		return result;		
	}
	
	/**
	 * @return The "green" values of the image as two dimensional array
	 */
	public int[][] getGreen() {
		int[][] result = new int[this.width][this.height];
		for (int i = 0; i < this.width; ++i) {
			result[i] = new int[this.height];
			for (int j = 0; j < this.height; ++j) {
				result[i][j] = getGreen(i, j);				
			}		
		}		
		return result;		
	}
	
	/**
	 * @return The "blue" values of the image as two dimensional array
	 */
	public int[][] getBlue() {
		int[][] result = new int[this.width][this.height];
		for (int i = 0; i < this.width; ++i) {
			result[i] = new int[this.height];
			for (int j = 0; j < this.height; ++j) {
				result[i][j] = getBlue(i, j);				
			}		
		}		
		return result;		
	}		
	
	/**
	 * @param x
	 * @param y
	 * @param value
	 */
	public void setRed(int x, int y, int value){
		int fixedValue = value;
		if (value > 255) {
			fixedValue = 255;
		}
		this.bi.setRGB(x, y, this.bi.getRGB(x, y) & 0xFFFF | (fixedValue << 16));
	}
	
	/**
	 * @param x
	 * @param y
	 * @param value
	 */
	public void setGreen(int x, int y, int value){
		int fixedValue = value;
		if (value > 255) {
			fixedValue = 255;
		}
		this.bi.setRGB(x, y,this. bi.getRGB(x, y) & 0xFF00FF | (fixedValue << 8));
	}
	
	/**
	 * @param x
	 * @param y
	 * @param value
	 */
	public void setBlue(int x, int y, int value){
		int fixedValue = value;
		if (value > 255) {
			fixedValue = 255;
		}	
		this.bi.setRGB(x, y, this.bi.getRGB(x, y) & 0xFFFF00 | fixedValue);
	}
	
	/**
	 * @param x
	 * @param y
	 * @param r
	 * @param g
	 * @param b
	 */
	public void setColor(int x, int y, int r, int g, int b){
		int red = (r > 255) ? 255 : r;		
		int green = (g > 255) ? 255 : g;
		int blue = (b > 255) ? 255 : b;
		int value = (red << 16) | (green << 8) | blue;
		this.bi.setRGB(x, y, value);
	}
	
	/**
	 * @param x
	 * @param y
	 * @param color
	 */
	public void setColor(int x, int y, Color color){
		int value = (color.getRed() << 16) | (color.getGreen() << 8) | color.getBlue();
		this.bi.setRGB(x, y, value);
	}
	
	/**
	 * 
	 */
	public void showImage() {
		this.f = new JFrame(this.title);        
		this.f.addWindowListener(new WindowAdapter(){
                @Override
				public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

		this.f.add(this);
		this.f.pack();
		this.f.setVisible(true);
	}
	
    /* (non-Javadoc)
     * @see java.awt.Component#paint(java.awt.Graphics)
     */
    @Override
	public void paint(Graphics g) {
        g.drawImage(this.bi, 0, 0, null);
    }
    
    /**
     * @param newTitle
     */
    public void setTitle(String newTitle) {
    	this.title = "SimpleImage - " + newTitle;
    }
    
    /**
     * 
     */
    public String getTitle() {
    	return this.title;
    }
    
    /* (non-Javadoc)
     * @see java.awt.Component#getPreferredSize()
     */
    @Override
	public Dimension getPreferredSize() {
        if (this.bi == null) {
        	return new Dimension(100, 100);
        }
        return new Dimension(this.bi.getWidth(null), this.bi.getHeight(null));
    }
    
    /**
     * 
     */
    public void refresh() {
    	this.bi.flush();
    	getGraphics().drawImage(this.bi, 0, 0, null);   
    	this.f.repaint();
    	this.f.pack();
    }
    
    /**
     * @return The window's width
     */
    public int width() {
    	return this.width;
    }
    
    /**
     * @return The window's height
     */
    public int height() {
    	return this.height;
    }

	/**
	 * @return Two dimensional array of the image's pixels
	 */
	public Color[][] getColors() {
		Color[][] result = new Color[this.width][this.height];
		for (int i = 0; i < this.width; ++i) {
			result[i] = new Color[this.height];
			for (int j = 0; j < this.height; ++j) {
				result[i][j] = getColor(i, j);				
			}		
		}		
		return result;
	}

	/**
	 * @param i
	 * @param j
	 * @return The pixel in location (x, y)
	 */
	public Color getColor(int i, int j) {	
        //TODO: Remove this:
		//System.out.println("A: "+ getRed(i,j));
		//System.out.println("B: "+ getGreen(i,j));
		//System.out.println("C: "+ getBlue(i,j));
		return (new Color(getRed(i,j), getGreen(i,j), getBlue(i,j)));
	}

}
