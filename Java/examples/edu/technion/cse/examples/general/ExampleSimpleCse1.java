package edu.technion.cse.examples.general;

import edu.technion.cse.simpleGoogleMaps.SimpleGoogleMaps;
import edu.technion.cse.simpleImage.SimpleImage;


public class ExampleSimpleCse1 {

	public static void main(String[] args) {
		exmaple1();

	}
	
	public static void exmaple1() {
    	SimpleGoogleMaps sgm = new SimpleGoogleMaps();
    	
        sgm.setWindowTitle("Technion's Department of Education in Technology and Science - Road-Map");
        sgm.setLatitude(32.776760);
    	sgm.setLongitude(35.027222);    	
    	sgm.setZoom(17);
    	sgm.setWidth(640);
    	sgm.setHeight(640);
    	sgm.refresh();
    	
    	SimpleImage si = new SimpleImage();
    	si.loadUrl(sgm.generateUrl());
    	si.showImage();
		si.setTitle("Black & White Google Maps Image");
		for (int i = 0; i < si.width(); ++i) {
			for (int j = 0; j < si.height(); ++j) {
				int newValue = (si.getRed(i, j) + si.getGreen(i, j) + si.getBlue(i, j)) / 3;
				si.setRed(i, j, newValue);
				si.setGreen(i, j, newValue);
				si.setBlue(i, j, newValue);
			}
		}
		si.refresh();	
	}

}
