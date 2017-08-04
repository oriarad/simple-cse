/* COPYRIGHT (C) 2012 Ori Arad. All Rights Reserved. */
/* See LICENSE.txt for more details                  */

package edu.cse.simplecse.simpleRss.test;

import edu.cse.simplecse.simpleRss.*;
import junit.framework.TestCase;

public class RssItemTest extends TestCase {
	private RssItem rssItem;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.rssItem = new RssItem();
	}

	public void testEmptyCategory() {
		String expected = "";
		String actual = this.rssItem.getCategory();
		assertEquals(expected, actual);
	}
	
	public void testEmptyDescription() {
		String expected = "";
		String actual = this.rssItem.getDescription();
		assertEquals(expected, actual);
	}
	
	public void testEmptyGuid() {
		String expected = "";
		String actual = this.rssItem.getGuid();
		assertEquals(expected, actual);
	}
	
	public void testEmptyLink() {
		String expected = "";
		String actual = this.rssItem.getLink();
		assertEquals(expected, actual);
	}
	
	public void testEmptyPubDate() {
		String expected = "";
		String actual = this.rssItem.getPubDate();
		assertEquals(expected, actual);
	}
	
	public void testEmptyTitle() {
		String expected = "";
		String actual = this.rssItem.getTitle();
		assertEquals(expected, actual);
	}
	
	public void testCategory() {
		String expected = "MyCategory";
		this.rssItem.setCategory("MyCategory");
		String actual =this. rssItem.getCategory();
		assertEquals(expected, actual);
	}
	
	public void testDescription() {
		String expected = "MyDescription";
		this.rssItem.setDescription("MyDescription");
		String actual = this.rssItem.getDescription();
		assertEquals(expected, actual);
	}
	
	public void testGuid() {
		String expected = "MyGuid";
		this.rssItem.setGuid("MyGuid");
		String actual = this.rssItem.getGuid();
		assertEquals(expected, actual);
	}
	
	public void testLink() {
		String expected = "MyLink";
		this.rssItem.setLink("MyLink");
		String actual = this.rssItem.getLink();
		assertEquals(expected, actual);
	}
	
	public void testPubDate() {
		String expected = "MyPubDate";
		this.rssItem.setPubDate("MyPubDate");
		String actual = this.rssItem.getPubDate();
		assertEquals(expected, actual);
	}
	
	public void testTitle() {
		String expected = "MyTitle";
		this.rssItem.setTitle("MyTitle");
		String actual = this.rssItem.getTitle();
		assertEquals(expected, actual);
	}

	public void testNullCategory() {
		String expected = "";
		this.rssItem.setCategory(null);
		String actual = this.rssItem.getCategory();
		assertEquals(expected, actual);
	}
	
	public void testNullDescription() {
		String expected = "";
		this.rssItem.setDescription(null);
		String actual = this.rssItem.getDescription();
		assertEquals(expected, actual);
	}
	
	public void testNullGuid() {
		String expected = "";
		this.rssItem.setGuid(null);
		String actual = this.rssItem.getGuid();
		assertEquals(expected, actual);
	}
	
	public void testNullLink() {
		String expected = "";
		this.rssItem.setLink(null);
		String actual = this.rssItem.getLink();
		assertEquals(expected, actual);
	}
	
	public void testNullPubDate() {
		String expected = "";
		this.rssItem.setPubDate(null);
		String actual = this.rssItem.getPubDate();
		assertEquals(expected, actual);
	}
	
	public void testNullTitle() {
		String expected = "";
		this.rssItem.setTitle(null);
		String actual = this.rssItem.getTitle();
		assertEquals(expected, actual);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
