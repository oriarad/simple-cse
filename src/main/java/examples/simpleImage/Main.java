package examples.simpleImage;

import java.awt.Color;
import edu.cse.simplecse.simpleImage.SimpleImage;

public class Main {
	
	private static final String filename = "noam.jpg";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		showOriginal();
		showBright();
		showBluewish();
		showContureLines();
		showNegative();
		showRotated();
		showBlur();
		showBW();
		showPosture();
		showChess();
		SimpleImage si = new SimpleImage();
		si.load();
		si.showImage();
	}

	private static void showPosture() {
		SimpleImage si = new SimpleImage();
		si.load(filename);
		si.setTitle("Posture");
		si.showImage();
		for (int i = 0; i < si.width(); ++i) {
			for (int j = 0; j < si.height(); ++j) {
				Color col = si.getColor(i, j);
				if (col.getRed() < 64)
					si.setRed(i, j, 31);
				else if (col.getRed() < 128)
					si.setRed(i, j, 95);
				else if (col.getRed() < 192)
					si.setRed(i, j, 159);
				else 
					si.setRed(i, j, 223);
				
				if (col.getGreen() < 64)
					si.setGreen(i, j, 31);
				else if (col.getGreen() < 128)
					si.setGreen(i, j, 95);
				else if (col.getGreen() < 192)
					si.setGreen(i, j, 159);
				else 
					si.setGreen(i, j, 223);
				
				if (col.getBlue() < 64)
					si.setBlue(i, j, 31);
				else if (col.getBlue() < 128)
					si.setBlue(i, j, 95);
				else if (col.getBlue() < 192)
					si.setBlue(i, j, 159);
				else 
					si.setBlue(i, j, 223);
			}
		}
		si.refresh();	
		
	}

	private static void showBW() {
		SimpleImage si = new SimpleImage();
		si.load(filename);
		si.setTitle("Black & White");
		si.showImage();
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

	private static void showBlur() {
		SimpleImage originalSi = new SimpleImage();		
		originalSi.load(filename);
		Color[][] tmp = originalSi.getColors();
		
		SimpleImage si = new SimpleImage();
		si.load(filename);
		si.setTitle("Blur");
		si.showImage();
		
		for (int i = 1; i < si.width() - 2; ++i) {
			for (int j = 1; j < si.height() - 2; ++j) {
				Color up = tmp[i][j-1];
				Color down = tmp[i][j+1];
				Color left = tmp[i-1][j];
				Color right = tmp[i+1][j];
				Color center = tmp[i][j];
				
				si.setRed(i, j, (up.getRed() + down.getRed() + left.getRed() + right.getRed() + center.getRed()) / 5);
				si.setGreen(i, j, (up.getGreen() + down.getGreen() + left.getGreen() + right.getGreen() + center.getGreen()) / 5);
				si.setBlue(i, j, (up.getBlue() + down.getBlue() + left.getBlue() + right.getBlue() + center.getBlue()) / 5);
			}
		}
		si.refresh();		
	}

	private static void showRotated() {
		SimpleImage originalSi = new SimpleImage();		
		originalSi.load(filename);
		Color[][] tmp = originalSi.getColors();
		
		SimpleImage si = new SimpleImage();
		si.create(originalSi.height(), originalSi.width());
		si.setTitle("Rotated");
		si.showImage();
		
		for (int i = 0; i < si.width(); ++i) {
			for (int j = 0; j < si.height(); ++j) {
				si.setColor(i, j, tmp[j][i]);
			}
		}
		si.refresh();
	}

	private static void showBluewish() {
		SimpleImage si = new SimpleImage();
		si.load(filename);
		si.setTitle("Bluewish");
		si.showImage();
		for (int i = 0; i < si.width(); ++i) {
			for (int j = 0; j < si.height(); ++j) {
				si.setBlue(i, j, 255);
			}
		}
		si.refresh();		
	}

	private static void showNegative() {
		SimpleImage si = new SimpleImage();
		si.load(filename);
		si.setTitle("Negative");
		si.showImage();
		for (int i = 0; i < si.width(); ++i) {
			for (int j = 0; j < si.height(); ++j) {
				si.setRed(i, j, 255 - si.getRed(i, j));
				si.setGreen(i, j, 255 - si.getGreen(i, j));
				si.setBlue(i, j, 255 - si.getGreen(i, j));
			}
		}
		si.refresh();		
	}

	private static void showContureLines() {
		SimpleImage originalSi = new SimpleImage();		
		originalSi.load(filename);
		Color[][] tmp = originalSi.getColors();
		
		SimpleImage si = new SimpleImage();
		si.load(filename);
		si.setTitle("Contoure Lines");
		si.showImage();
		
		for (int i = 0; i < si.width() - 1; ++i) {
			for (int j = 0; j < si.height() - 1; ++j) {
				Color current = si.getColor(i, j);
				Color bellow = tmp[i][j+1];
				Color right = tmp[i+1][j];
				int current_ = (current.getRed() + current.getGreen() + current.getBlue()) / 3;  
				int bellow_ = (bellow.getRed() + bellow.getGreen() + bellow.getBlue()) / 3;
				int right_ = (right.getRed() + right.getGreen() + right.getBlue()) / 3;
				if (Math.abs(current_ - bellow_) > 10 && Math.abs(current_ - right_) > 10 ) {
					si.setColor(i, j, Color.BLACK);
				}
				if (Math.abs(current_ - bellow_) <= 10 && Math.abs(current_ - right_) <= 10 ) {
					si.setColor(i, j, Color.WHITE);
				}
			}
		}
		si.refresh();		
	}

	private static void showBright() {
		SimpleImage si = new SimpleImage();
		si.load(filename);
		si.setTitle("Bright");
		si.showImage();
		for (int i = 0; i < si.width(); ++i) {
			for (int j = 0; j < si.height(); ++j) {
				si.setRed(i, j, si.getRed(i, j) + 50);
				si.setGreen(i, j, si.getGreen(i, j) + 50);
				si.setBlue(i, j, si.getGreen(i, j) + 50);
			}
		}
		si.refresh();		
	}

	private static void showOriginal() {
		SimpleImage si = new SimpleImage();
		si.load(filename);
		si.setTitle("Original");
		si.showImage();
		si.refresh();		
	}
	
	private static void showChess() {
		SimpleImage si = new SimpleImage();
		si.create(300, 400);
		si.setTitle("Chess");
		
		for (int i = 0; i < si.width(); ++i) {
			for (int j = 0; j < si.height(); ++j) {
				if (((i/50)+(j/50)) % 2 == 0) {
					si.setColor(i, j, Color.RED);
				} else {
					si.setColor(i, j, new Color(255, 254, 253));
				}
			}
		}
		si.showImage();
		si.refresh();
	}

}
