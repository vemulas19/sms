package com.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.sms.pojo.User;

@Controller
public class SMSController {

	@Autowired
	private User user;
	
	@RequestMapping(value="/testLifeCycle")
	public String testLife() {
	
		System.out.println("Entered into testLife!!");
		
		System.out.println(user.getName());
		System.out.println(user.getSalary());
		
		user.getCities().forEach(System.out::println);
		
		return "HomeSms";
	}
	
	@RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
	public String sendSMS(Model model, @RequestParam("mobile") String mbl, @RequestParam("textMessage") String text) {

		System.out.println("Receipient mobile number is : " + mbl);
		System.out.println("Message to deliver is : " + text);

		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/message-service/service/v2/message/sendSms?";
				url = url.concat("mbl=").concat(mbl);
				url = url.concat("&text=").concat(text);

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
