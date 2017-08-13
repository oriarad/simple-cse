/* COPYRIGHT (C) 2012 Ori Arad. All Rights Reserved. */
/* See LICENSE.txt for more details                  */

package edu.cse.simplecse.simpleRss;

import java.io.IOException;

/**
 * This class represents a single RSS item.
 * @author Ori Arad
 *
 */
public class RssItem {
	/**
	 * The RSS item's category
	 */
	private String category = "";
	/**
	 * The RSS item's title
	 */
	private String title = "";
	/**
	 * The RSS item's description
	 */
	private String description = "";
	/**
	 * The RSS item's link
	 */
	private String link = "";
	/**
	 * The RSS item's publication-date
	 */
	private String pubDate = "";
	/**
	 * The RSS item's guid
	 */
	private String guid = "";	
	
	/**
	 * Constructor
	 */
	public RssItem() {
		// empty
	}
	
	/**
	 * Gets the category of the item
	 * @return The RSS item's category
	 */
	public String getCategory() {
		return this.category;
	}
	
	/**
	 * Sets the category of the item
	 * @param category The required RSS item's category
	 */
	public void setCategory(String category) {
		if (category == null) {
			this.category = "";
		} else {
			this.category = category;
		}
	}

	/**
	 * Gets the title of the item
	 * @return The RSS item's title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Sets the title of the item
	 * @param title The required RSS item's title
	 */
	public void setTitle(String title) {
		if (title == null) {
			this.title = "";
		} else {
			this.title = title;
		}
	}
	
	/**
	 * Gets the description of the item
	 * @return The RSS item's description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Sets the description of the item
	 * @param description The required RSS item's description
	 */
	public void setDescription(String description) {
		if (description == null) {
			this.description = "";
		} else {
			this.description = description;
		}
	}
	
	/**
	 * Gets the link of the item
	 * @return The RSS item's link
	 */
	public String getLink() {
		return this.link;
	}
	
	/**
	 * Sets the link of the item
	 * @param link
	 */
	public void setLink(String link) {
		if (link == null) {
			this.link = "";
		} else {
			this.link = link;
		}
	}
	
	/**
	 * Gets the publication-date of the item
	 * @return the publication-date of the item
	 */
	public String getPubDate() {
		return this.pubDate;
	}
	
	/**
	 * Sets the publish-date of the item
	 * @param pubDate the publication-date of the item
	 */
	public void setPubDate(String pubDate) {
		if (pubDate == null) {
			this.pubDate = "";
		} else {
			this.pubDate = pubDate;
		}
	}
	
	/**
	 * Gets the guid of the item
	 * @return the guid of the item
	 */
	public String getGuid() {
		return this.guid;
	}
	
	/**
	 * Sets the guid of the item
	 * @param guid
	 */
	public void setGuid(String guid) {
		if (guid == null) {
			this.guid = "";
		} else {
			this.guid = guid;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.pubDate + ": " + this.title + ". " + this.description;
	}
	
	/**
	 * Open the RSS item's link in the default browser
	 */
	public void openLink() {
		try {
			// Opens the link from command-line - what usually cause the OS to open the link in the default HTML-Browser
			Runtime.getRuntime().exec("cmd /c start " + this.link);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
