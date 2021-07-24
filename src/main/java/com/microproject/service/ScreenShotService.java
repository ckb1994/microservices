package com.microproject.service;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.microproject.controller.ScreenShotController;

@Service
public class ScreenShotService {

	private static final Logger LOG  = 
			LogManager.getLogger(ScreenShotController.class);

	public void fullScreenShot() {
		LOG.info("Full Screenshot Starting");
		
		try {
			Thread.sleep(4000);
//			System.setProperty("java.awt.headless", "false");
			Robot robot = new Robot();

			Rectangle rect = 
					new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			Long ts = System.currentTimeMillis();
			
			BufferedImage bi = robot.createScreenCapture(rect);
			ImageIO.write(bi, "JPG", 
					new File("C:\\Mission2021\\MicroServices\\MicroServices\\screenshots\\ScreenShot_"+ts+".jpg"));	
			
			LOG.info("Full Screenshot Completed");
		} catch (Exception e) {
			LOG.error("Full Screenshot Failed ", e.getMessage());
		}
	}
	
	public void customizedScreenShot(int x1, int y1, int x2, int y2) {
		LOG.info("Customized Screenshot Starting");
		
		try {
			Thread.sleep(4000);
			System.setProperty("java.awt.headless", "false");
			Robot robot = new Robot();

			Rectangle rect = 
					new Rectangle(x1, y1, x2, y2);
			Long ts = System.currentTimeMillis();
			
			BufferedImage bi = robot.createScreenCapture(rect);
			ImageIO.write(bi, "JPG", 
					new File("C:\\Mission2021\\MicroServices\\MicroServices\\screenshots\\ScreenShot_"+ts+".jpg"));	
			
			LOG.info("Customized Screenshot Completed");
		} catch (Exception e) {
			LOG.error("Customized Screenshot Failed ", e.getMessage());
		}
	}
}
