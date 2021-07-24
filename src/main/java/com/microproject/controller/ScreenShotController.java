package com.microproject.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microproject.service.ScreenShotService;

import io.swagger.annotations.ApiOperation;


@RestController
//@Log4j2
@RequestMapping("/api")
public class ScreenShotController {
	
	private static final Logger LOG  = 
			LogManager.getLogger(ScreenShotController.class);
	
	@Autowired
	private ScreenShotService service;
	
	@ApiOperation("This Endpoint will take Full Screenshot after 5 seconds.")
	@GetMapping("fullscreenshot")
	public void takeFullScreenShot() {
		service.fullScreenShot();
		LOG.info("fullScreen");
	}

	@ApiOperation("This Endpoint will take User Input Screenshot after 5 seconds."
			+ "Top-most left corner pixel 0,0 and Bottom-most right corner pixel 1920, 1080")
	@GetMapping(value = "customizedscreenshot")
	public void takeCustomizedScreenShot(@RequestParam int x1, @RequestParam int y1,
			@RequestParam int x2,@RequestParam int y2) {
		service.customizedScreenShot(x1, y1, x2, y2);
		LOG.info("fullScreen");
	}
	
	
	@ExceptionHandler(Exception.class)
	public void handleError(Exception e) {
		LOG.error("Error Found in Screenshot: ", e.getStackTrace());
	}
	
}
