/**
 * 
 */
package edu.technion.cse.simpleImage;

import java.awt.Color;

import junit.framework.TestCase;

/**
 * @author Ori Arad
 *
 */
public class SimpleImageTest extends TestCase {
	
	SimpleImage si = null;
	SimpleImage siLoaded = null;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.si = new SimpleImage();
		this.si.create(400, 300);
		this.si.setTitle("Test");
		this.si.showImage();
		this.si.refresh();
		this.siLoaded = new SimpleImage();
		this.siLoaded.create(400, 300);
		this.siLoaded.setTitle("Test");
		this.siLoaded.showImage();
		this.siLoaded.refresh();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#create(int, int)}.
	 */
	public void testCreate() {
		this.si = new SimpleImage();
		this.si.create(400, 500);
		this.si.showImage();
		this.si.refresh();
		assertEquals(400, this.si.getWidth());
		assertEquals(500, this.si.getHeight());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#load(java.lang.String)}.
	 */
	public void testLoad() {
		this.si.load("testSimpleImage.bmp");
		this.si.showImage();
		assertEquals(200, this.si.getWidth());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#getRed(int, int)}.
	 */
	public void testGetRedIntInt() {
		assertEquals(0, this.si.getRed(12, 13));
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#getGreen(int, int)}.
	 */
	public void testGetGreenIntInt() {
		assertEquals(0, this.si.getGreen(12, 13));
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#getBlue(int, int)}.
	 */
	public void testGetBlueIntInt() {
		assertEquals(0, this.si.getBlue(12, 13));
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#getRed()}.
	 */
	public void testGetRed() {
		assertEquals(0, this.si.getRed()[12][13]);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#getGreen()}.
	 */
	public void testGetGreen() {
		assertEquals(0, this.si.getGreen()[12][13]);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#getBlue()}.
	 */
	public void testGetBlue() {
		assertEquals(0, this.si.getBlue()[12][13]);
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#setRed(int, int, int)}.
	 */
	public void testSetRed() {
		this.si.setRed(12, 13, 222);
		assertEquals(222, this.si.getRed(12, 13));
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#setGreen(int, int, int)}.
	 */
	public void testSetGreen() {
		this.si.setGreen(12, 13, 222);
		assertEquals(222, this.si.getGreen(12, 13));
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#setBlue(int, int, int)}.
	 */
	public void testSetBlue() {
		this.si.setBlue(12, 13, 222);
		assertEquals(222, this.si.getBlue(12, 13));
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#setColor(int, int, int, int, int)}.
	 */
	public void testSetColorIntIntIntIntInt() {
		this.si.setColor(12, 13, 234, 123, 99);
		assertEquals(234, this.si.getColor(12, 13).getRed());
		assertEquals(123, this.si.getColor(12, 13).getGreen());
		assertEquals(99, this.si.getColor(12, 13).getBlue());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#setColor(int, int, java.awt.Color)}.
	 */
	public void testSetColorIntIntColor() {
		this.si.setColor(12, 13, Color.CYAN);
		assertEquals(Color.CYAN, this.si.getColor(12, 13));
	}


	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#setTitle(java.lang.String)}.
	 */
	public void testSetTitle() {
		this.si.setTitle("TestTitle");
		assertEquals("SimpleImage - TestTitle", this.si.getTitle());
	}


	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#width()}.
	 */
	public void testWidth() {
		assertEquals(400, this.si.getWidth());	
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#height()}.
	 */
	public void testHeight() {
		assertEquals(300, this.si.getHeight());	
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#getColors()}.
	 */
	public void testGetColors() {
		assertEquals(0, this.si.getColors()[10][10].getRed());
		assertEquals(0, this.si.getColors()[10][10].getGreen());
		assertEquals(0, this.si.getColors()[10][10].getBlue());
	}

	/**
	 * Test method for {@link edu.technion.cse.simpleImage.SimpleImage#getColor(int, int)}.
	 */
	public void testGetColor() {
		assertEquals(0, this.si.getColor(10, 10).getRed());
		assertEquals(0, this.si.getColor(10, 10).getGreen());
		assertEquals(0, this.si.getColor(10, 10).getBlue());
	}
	
	public void testChess() {
		this.si.setTitle("Chess");		
		for (int i = 0; i < this.si.width(); ++i) {
			for (int j = 0; j < this.si.height(); ++j) {
				if (((i/50)+(j/50)) % 2 == 0) {
					this.si.setColor(i, j, Color.RED);
				} else {
					this.si.setColor(i, j, new Color(255, 254, 253));
				}
			}
		}		
		assertEquals(255, this.si.getColor(30, 30).getRed());
	}
}
