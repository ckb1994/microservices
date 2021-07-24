package com.microproject.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microproject.service.OtpGenService;

@RestController
@RequestMapping("/api")
public class OtpGenController {

	private static final Logger LOG = 
			LogManager.getLogger(OtpGenController.class);
	
	@Autowired
	private OtpGenService service;
	
	@GetMapping("generateOtp")
	public String generateOtp(@RequestParam int otpLength) {
		LOG.info("Otp Generation started");
		String otp = service.generateOtp(otpLength);
		LOG.info("Otp Generation completed");
		return otp;
	}
}
