/**
 * 
 */
package edu.technion.cse.simpleRss;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import junit.framework.TestCase;

/**
 * @author Ori Arad
 *
 */
public class SimpleRssTest extends TestCase {
	private SimpleRss srss;
	private SimpleRss remoteSrss;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.srss = new SimpleRss();
		try {
			this.remoteSrss = new SimpleRss("http://rss.cnn.com/rss/edition.rss");
		} catch (ParserConfigurationException e) {
			this.remoteSrss = null;
		}
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#SimpleRss(java.lang.String)}.
	 */
	public void testSimpleRssString() {
		assertNotNull(this.remoteSrss);
		// TODO: consider add more test - e.g. verify name of site includes "cnn"
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#SimpleRss()}.
	 */
	public void testSimpleRss() {
		assertEquals("", this.srss.getCopyright());
		assertEquals("", this.srss.getDescription());
		assertEquals("", this.srss.getImageLink());
		assertEquals("", this.srss.getLanguage());
		assertEquals("", this.srss.getLink());
		assertEquals("", this.srss.getPubDate());
		assertEquals("", this.srss.getSource());
		assertEquals("", this.srss.getTitle());
		assertEquals(0, this.srss.getItems().length);
		assertEquals(0, this.srss.getSize());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#loadUrl(java.lang.String)}.
	 */
	public void testLoadUrl() {
		this.srss.loadUrl("http://www.ynet.co.il/Integration/StoryRss2.xml");
		assertNotNull(this.srss.getTitle());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#loadFile(java.lang.String)}.
	 */
	public void testLoadFile() {
		this.srss.loadFile("testRssYnet.rss");
		assertNotNull(this.srss.getTitle());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#parseXml(org.w3c.dom.Document)}.
	 */
	public void testParseXml() {		
		try {
			URL url = new URL("http://rss.cnn.com/rss/edition.rss");
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = docBuilder.parse(url.openStream());
			assertTrue(this.srss.parseXml(doc));
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#getItem(int)}.
	 */
	public void testGetItem() {
		this.remoteSrss.getItem(1);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#getItems()}.
	 */
	public void testGetItems() {
		assertEquals(0, this.srss.getItems().length);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#getSize()}.
	 */
	public void testGetSize() {
		assertEquals(0, this.srss.getSize());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#getTitle()}.
	 */
	public void testGetTitle() {
		assertEquals("", this.srss.getTitle());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#getDescription()}.
	 */
	public void testGetDescription() {
		assertEquals("", this.srss.getDescription());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#getLink()}.
	 */
	public void testGetLink() {
		assertEquals("", this.srss.getLink());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#getLanguage()}.
	 */
	public void testGetLanguage() {
		assertEquals("", this.srss.getLanguage());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#getCopyright()}.
	 */
	public void testGetCopyright() {
		assertEquals("", this.srss.getCopyright());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#getPubDate()}.
	 */
	public void testGetPubDate() {
		assertEquals("", this.srss.getPubDate());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#getImageLink()}.
	 */
	public void testGetImageLink() {
		assertEquals("", this.srss.getImageLink());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#getSource()}.
	 */
	public void testGetSource() {
		assertEquals("", this.srss.getSource());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleRss.SimpleRss#toString()}.
	 */
	public void testToString() {
		assertEquals("Language:", this.srss.toString().trim());
	}

}
