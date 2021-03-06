package model;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import model.observer.Observer;

public class Model {

	public static int MAX_WIDTH = 150;

	public static int MAX_HEIGHT = 150;

	private ArrayList<Observer> observerList;

	private ArrayList<ImageIcon> imageList;

	public void addObserver(Observer o) {
		observerList.add(o);
	}

	public Model() {
		this.observerList = new ArrayList<Observer>();
		this.imageList = new ArrayList<ImageIcon>();
		this.imageList.add(this
				.resizeImage("src/model/gameImage/Clash_of_Clans.png"));
		this.imageList.add(this
				.resizeImage("src/model/gameImage/Clash_Royale.png"));
		this.imageList.add(this.resizeImage("src/model/gameImage/Hay_Day.png"));
	}
	
	public static BufferedImage loadImage(String pathName) {
		BufferedImage bimage = null;
		try {
			bimage = ImageIO.read(new File(pathName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bimage;
	}

	public static BufferedImage resize(BufferedImage bufferedImage, int newW,
			int newH) {
		int w = bufferedImage.getWidth();
		int h = bufferedImage.getHeight();
		BufferedImage bufim = new BufferedImage(newW, newH,
				bufferedImage.getType());
		Graphics2D g = bufim.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
		g.dispose();
		return bufim;
	}

	public ImageIcon resizeImage(String filePath) {
		BufferedImage bimage = loadImage(filePath);
		if (bimage.getHeight() > bimage.getWidth()) {
			int heigt = (bimage.getHeight() * MAX_WIDTH) / bimage.getWidth();
			bimage = resize(bimage, MAX_WIDTH, heigt);
			int width = (bimage.getWidth() * MAX_HEIGHT) / bimage.getHeight();
			bimage = resize(bimage, width, MAX_HEIGHT);
		} else {
			int width = (bimage.getWidth() * MAX_HEIGHT) / bimage.getHeight();
			bimage = resize(bimage, width, MAX_HEIGHT);
			int heigt = (bimage.getHeight() * MAX_WIDTH) / bimage.getWidth();
			bimage = resize(bimage, MAX_WIDTH, heigt);
		}
		return new ImageIcon(bimage);
		// saveImage(bimage, copyPath);
	}

	public ArrayList<ImageIcon> getImageIconList() {
		return this.imageList;
	}

	public void start() {
		/*
		 * this.actList = itemConnection.getNItems(20); for(AppObserver o :
		 * this.observerList){ o.opAppStart(this.actList); }
		 */

	}

}