package com.sms.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class SMSController {

	@RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
	public String sendSMS(@RequestParam("mobile") String mbl, @RequestParam("textMessage") String text) {

		System.out.println("Receipient mobile number is : " + mbl);
		System.out.println("Message to deliver is : " + text);

		RestTemplate rt = new RestTemplate();
		String url = "https://www.smsgatewayhub.com/api/mt/SendSMS?APIKey=SvGHrZmU50G0zLLtMuyLrg&channel=1&DCS=0&flashsms=0&number="+mbl +"&text="+text+"&senderid=SMSTST";

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<String> response = rt.exchange(url, HttpMethod.POST, entity, String.class);
		System.out.println("Response Data : " + response.getBody());
		return "HomeSms";
	}
}
