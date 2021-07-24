package com.microproject.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsSenderService {

	@Autowired
	OtpGenService otpService;
	
	public void sendOtp(int otpLength, String numbers) {
		String otp = otpService.generateOtp(otpLength);
		sendSms(otp,numbers);
	}
	
	private void sendSms(String otp, String numbers) {
		try {
			String apiKey = "apiKey="+"";// got it from textlocal website
			String message = "&message="+ URLEncoder.encode("Your OTP is "+otp,
					"UTF-8");
			String cntNums = "&number="+numbers;
			
			String apiURL = "https://api.textlocal.in/send/?"+
								apiKey+message+cntNums;
			URL url = new URL(apiURL);
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line = "";
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
			System.out.println(sb.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
