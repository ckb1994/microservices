package com.microproject.controller;

import org.apache.logging.log4j.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class SmsSenderController {

	private static final Logger LOG = LogManager.getLogger();
	
	@ApiOperation("Using testlocal.in for sending sms")
	@GetMapping(value = "/sentOtp")
	public void sendOtp() {
		LOG.info("Sending otp of given number using textlocal.in");
		//get apikey from website, 
		//Remember it is from only for 30 days, 10 sms per day
		
	}
	
}
