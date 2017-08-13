/* COPYRIGHT (C) 2012 Ori Arad. All Rights Reserved. */
/* See LICENSE.txt for more details                  */

package edu.cse.simplecse.simpleRss;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * This class provides a simple-to-use interface to RSS channels.
 * User can easily provide URL address or local file location, of RSS file (in XML format) - and read all the RSS information from it.
 * <p>
 * Example:
 * <pre>
 * {@code 
 * String TEST_URL = "http://www.ynet.co.il/Integration/StoryRss4403.xml";
 * SimpleRss rss = new SimpleRss(TEST_URL);
 * 
 * for (int i = 0; i < rss.getSize(); ++i) {
 *   System.out.println(rss.getItem(i).getTitle());
 * } 
 * }  
 * </pre>
 * See the <a href="{@docRoot}/copyright.html">Copyright</a>.
 * @author Ori Arad 
 */
public class SimpleRss {
	/**
	 * The RSS channel's source
	 */
	private String source = "";
	/**
	 * The RSS channel's URL address
	 */
	private URL url = null;
	/**
	 * An array of all the RSS channel's items
	 */
	private ArrayList<RssItem> items = null;
	/**
	 * The RSS channel's title
	 */
	private String title = "";
	/**
	 * The RSS channel's description
	 */
	private String description = "";
	/**
	 * The RSS channel's link
	 */
	private String link = "";
	/**
	 * The RSS channel's language code
	 */
	private String language = "";
	/**
	 * The RSS channel's copyright
	 */
	private String copyright = "";
	/**
	 * The RSS channel's publication date
	 */
	private String pubDate = "";
	/**
	 * The RSS channel's image-link
	 */
	private String imageLink = "";
	/**
	 * 
	 */
	private DocumentBuilder builder;
	

	/**
	 * Constructor - Will open the given RSS link
	 * @param rssLocation The location (URL) of RSS file
	 * @throws ParserConfigurationException 
	 */
	public SimpleRss(String rssLocation) throws ParserConfigurationException {
		this();
		loadUrl(rssLocation);	
	}
	
	/**
	 * Constructor - creates an empty RSS object
	 * @throws ParserConfigurationException 
	 */
	public SimpleRss() throws ParserConfigurationException {
		this.items = new ArrayList<>();	
		this.builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	}
	
	/**
	 * Load a RSS file from URL address
	 * @param rssLocation The location (URL) of RSS file
	 * @return "true" if URL loading succeed, and "false" otherwise
	 */
	public boolean loadUrl(String rssLocation) {
		this.source = rssLocation;
		boolean result = false;		
		Document doc;
		try {
			this.url = new URL(rssLocation);
			doc = this.builder.parse(this.url.openStream());
			result = parseXml(doc);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	/**
	 * Loads a file with RSS data
	 * @param filename  The file-name and path of the RSS file
	 * @return "true" if RSS file loading succeed, and "false" otherwise
	 */
	public boolean loadFile(String filename) {
		boolean result = false;
		Document doc;
		try {
			doc = this.builder.parse(new File(filename));
			result = parseXml(doc);
		} catch (SAXException e) {
			// empty
		} catch (IOException e) {
			// empty
		}

		return result;
	}
	
	/**
	 * Loads a file with RSS data
	 * @param filename  The file-name and path of the RSS file
	 * @return "true" if RSS file loading succeed, and "false" otherwise
	 */
	public boolean parseXml(Document doc) {		
		try {
			this.title = getElementAsString(doc.getDocumentElement(), "title");
			this.link = getElementAsString(doc.getDocumentElement(), "link");
			this.description = getElementAsString(doc.getDocumentElement(), "description");
			this.language = getElementAsString(doc.getDocumentElement(), "language");
			this.copyright = getElementAsString(doc.getDocumentElement(), "copyright");
			this.pubDate = getElementAsString(doc.getDocumentElement(), "pubDate");

			NodeList nodes = doc.getElementsByTagName("item");
			for (int i = 0; i < nodes.getLength(); i++) {
				Element node = (Element)nodes.item(i);
				RssItem rssItem = new RssItem();
				rssItem.setTitle(getElementAsString(node, "title"));
				rssItem.setDescription(getElementAsString(node, "description")); 
				rssItem.setLink(getElementAsString(node, "link"));
				rssItem.setPubDate(getElementAsString(node, "pubDate")); 
				rssItem.setGuid(getElementAsString(node, "guid")); 
				
				this.items.add(rssItem);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}			
		return true;		
	}
	
	/**
	 * Gets an element's value
	 * @param node The element's node
	 * @param field The required field's name
	 * @return The element's value as a string, or empty string ("") if element doesn't exist
	 */
	private static String getElementAsString(Element node, String field) {
		String result = "";
		Node tmp = node.getElementsByTagName(field).item(0);
		if ((tmp != null) && (tmp.getFirstChild() != null)) {
			result = tmp.getFirstChild().getNodeValue();
		}
		return result;
	}
	
	/**
	 * Gets a RssItem object from the required index
	 * @param i The item's index
	 * @return A RssItem object from the required index, of null if index is out-of-range
	 */
	public RssItem getItem(int i) {
		assert(this.items != null);
		if ((i < 0) || (i >= getSize())) {
			System.err.println("RssItem getItem: Illegal index - out-of-range.");
			return null;
		}
		return this.items.get(i);
	}
	
	/**
	 * Gets an array of all RSS items
	 * @return an array of all RSS items
	 */
	public RssItem[] getItems() {
		assert(this.items != null);
		RssItem[] tmp = new RssItem[this.items.size()];
		return this.items.toArray(tmp);
	}
	
	/**
	 * Gets the number of RSS items
	 * @return The number of RSS items
	 */
	public int getSize() {
		assert(this.items != null);
		return this.items.size();
	}	
	
	/**
	 * Gets the RSS channel's title
	 * @return The RSS channel's title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Gets the RSS channel's description
	 * @return The RSS channel's description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Gets the RSS channel's link
	 * @return The RSS channel's link
	 */
	public String getLink() {
		return this.link;
	}

	/**
	 * Gets the RSS channel's language code
	 * @return The RSS channel's language code
	 */
	public String getLanguage() {
		return this.language;
	}

	/**
	 * Gets the RSS channel's copyright info
	 * @return The RSS channel's copyright info
	 */
	public String getCopyright() {
		return this.copyright;
	}

	/**
	 * Gets the RSS channel's publication date
	 * @return The RSS channel's publication date
	 */
	public String getPubDate() {
		return this.pubDate;
	}
	
	/**
	 * Gets the RSS channel's image-link
	 * @return The RSS channel's image-link
	 */
	public String getImageLink() {
		return this.imageLink;
	}
	
	/**
	 * Gets the RSS channel's source
	 * @return The RSS channel's source
	 */
	public String getSource() {
		return this.source;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(getTitle() + '\n');
		result.append(getDescription() + '\n');
		result.append("Language: " + getLanguage() + '\n');
		for (RssItem item : this.items) {
			result.append(item.toString());
			result.append('\n');
		}
		return result.toString();
	}
	
}
