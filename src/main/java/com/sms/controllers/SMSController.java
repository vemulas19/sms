package com.sms.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.sms.pojo.SmsResponse;

@Controller
public class SMSController {

	@RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
	public String sendSMS(Model model, @RequestParam("mobile") String mbl, @RequestParam("textMessage") String text) {

		System.out.println("Receipient mobile number is : " + mbl);
		System.out.println("Message to deliver is : " + text);

		RestTemplate rt = new RestTemplate();
		String url = "https://api.textlocal.in/send?apiKey=gQlRv2snAak-kSi4acq1NxRQmS9IKFK4rFGfa23s9e&sender=TXTLCL&numbers="
				+ mbl + "&message=" + text;

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		Gson gson = new Gson();
		ResponseEntity<String> response = rt.exchange(url, HttpMethod.POST, entity, String.class);
		System.out.println("Response Data : " + response.getBody());
		SmsResponse smsResponse = gson.fromJson(response.getBody(), SmsResponse.class);
		model.addAttribute("smsResponse", smsResponse);
		return "HomeSms";
	}
}
