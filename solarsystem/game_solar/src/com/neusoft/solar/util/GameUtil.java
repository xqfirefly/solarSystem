package com.neusoft.solar.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;



public class GameUtil {
	public static Image getImage(String impath){
		URL u = GameUtil.class.getClassLoader().getResource(impath);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

}
