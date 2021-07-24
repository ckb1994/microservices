package com.microproject.service;

import java.util.SplittableRandom;

import org.springframework.stereotype.Service;

@Service
public class OtpGenService {

	public String generateOtp(int otpLength) {
		
		StringBuilder sb = new StringBuilder();
		SplittableRandom sr = new SplittableRandom();
		for(int i=0;i<otpLength;i++) {
			sb.append(sr.nextInt(0, 10));
		}
		return sb.toString();
		
	}
}
