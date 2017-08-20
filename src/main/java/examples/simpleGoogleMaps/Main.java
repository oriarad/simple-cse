package examples.simpleGoogleMaps;

import java.awt.Color;
import edu.cse.simplecse.simpleGoogleMaps.Marker;
import edu.cse.simplecse.simpleGoogleMaps.Path;
import edu.cse.simplecse.simpleGoogleMaps.SimpleGoogleMaps;

/**
 *
 * @author Ori Arad
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	simpleExample();
    	simpleExample3();
    	simpleExample4();
    	simpleExample5();
    	
//    	SimpleGoogleMaps sgm = new SimpleGoogleMaps();
//    	
//    	sgm.setWindowTitle("New-York");
//    	sgm.setLatitude(40.714728);
//    	sgm.setLongitude(-73.998672);
//    	sgm.setZoom(12);
//    	sgm.refresh();   
//        sc.next(); // Just to wait until user will press the "Enter" key
//        
//        sgm.setWindowTitle("Technion's Department of Education in Technology and Science - Road-Map");
//        sgm.setLatitude(32.776760);
//    	sgm.setLongitude(35.027222);    	
//    	sgm.setZoom(17);
//    	sgm.setWidth(640);
//    	sgm.setHeight(640);
//    	sgm.refresh();
//        sc.next(); // Just to wait until user will press the "Enter" key   
//        
//        sgm.setWindowTitle("Technion's Department of Education in Technology and Science - Hybrid");
//    	sgm.setMapType(SimpleGoogleMaps.HYBRID);
//    	sgm.refresh();  
//    	
//    	Marker marker = new Marker();
//    	marker.setLatitude(32.776760);
//    	marker.setLongitude(35.027222);
//    	sgm.addMarker(marker);    	
//    	sgm.refresh();
//        sc.next(); // Just to wait until user will press the "Enter" key   	
    }
    
    private static void simpleExample() {
    	SimpleGoogleMaps sgm = new SimpleGoogleMaps();
    	
    	sgm.setWindowTitle("New-York");
    	sgm.setLatitude(40.714728);
    	sgm.setLongitude(-73.998672);
    	sgm.setZoom(12);
    	sgm.refresh();   	
    }
    
    
    private static void simpleExample3() {
    	SimpleGoogleMaps sgm = new SimpleGoogleMaps();
    	
        sgm.setLatitude(32.776760);
    	sgm.setLongitude(35.027222);    	
    	sgm.setZoom(17);
    	sgm.setWidth(640);
    	sgm.setHeight(640);
        sgm.setWindowTitle("Technion's Department of Education in Technology and Science - Hybrid");
    	sgm.setMapType(SimpleGoogleMaps.HYBRID);
    	sgm.refresh(); 
    }  
    
    private static void simpleExample4() {
    	SimpleGoogleMaps sgm = new SimpleGoogleMaps();
    	sgm.setWindowTitle("Technion's Department of Education in Technology and Science - Road-Map");
        sgm.setLatitude(32.776760);
    	sgm.setLongitude(35.027222);    	
    	sgm.setZoom(17);
    	sgm.setWidth(640);
    	sgm.setHeight(640);
    	sgm.addMarker(new Marker(32.776760, 35.025, Color.BLACK));
    	sgm.addMarker(new Marker(32.776760, 35.026, Color.PINK)); 
    	sgm.addMarker(new Marker(32.776760, 35.027, Color.BLUE));
    	sgm.addMarker(new Marker(32.776760, 35.028, Color.RED));
    	sgm.addMarker(new Marker(32.776760, 35.029, Color.MAGENTA));
    	sgm.addMarker(new Marker(32.776760, 35.030, Color.GREEN)); 
    	
    	System.out.println(sgm.generateUrl());
    	sgm.refresh();
    } 

    private static void simpleExample5() {
    	SimpleGoogleMaps sgm = new SimpleGoogleMaps();
    	
        sgm.setLatitude(32.776760);
    	sgm.setLongitude(35.027222);    	
    	sgm.setZoom(17);
    	sgm.setWidth(640);
    	sgm.setHeight(640);


    	Path path = new Path(32.7765, 35.027222);
    	path.addPoint(32.7765, 35.2);
    	path.setColor(Color.RED);
    	sgm.addPath(path);  
    	Path path2 = new Path(32.777, 35.027222);
    	path2.addPoint(32.777, 35.2);
    	path2.setColor(Color.ORANGE);
    	sgm.addPath(path2); 
       	Path path3 = new Path(32.7775, 35.027222);
    	path3.addPoint(32.7775, 35.2);
    	path3.setColor(Color.CYAN);
    	sgm.addPath(path3);     	
       	path = new Path(32.778, 35.027222);
    	path.addPoint(32.778, 35.2);
    	path.setColor(Color.BLUE);
    	sgm.addPath(path);    
       	path = new Path(32.7785, 35.027222);
    	path.addPoint(32.7785, 35.2);
    	path.setColor(Color.GREEN);
    	sgm.addPath(path);        	
    	sgm.refresh();
  
    } 
    
}