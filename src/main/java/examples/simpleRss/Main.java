package examples.simpleRss;

import javax.xml.parsers.ParserConfigurationException;
import edu.cse.simplecse.simpleRss.SimpleRss;

/**
 *
 * @author Ori Arad
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	String TEST_URL = "http://www.ynet.co.il/Integration/StoryRss4403.xml";
    	SimpleRss rss;
		try {
			rss = new SimpleRss(TEST_URL);
	    	for (int i = 0; i < rss.getSize(); ++i)
	    	{
	    		System.out.println(rss.getItem(i).getTitle());
	    	} 
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      
    }
}