package com.expedia.expspeech.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.expedia.expspeech.POJO.Sms;
import com.expedia.expspeech.POJO.User;
import com.expedia.expspeech.repository.SmsRepository;
import com.expedia.expspeech.repository.UserRepository;
import com.expedia.expspeech.util.sendSmsUtility;

@Controller @RequestMapping(path = "/sms") public class SmsController {
	@Autowired private SmsRepository smsRepository;
	@Autowired private UserRepository userRepository;

	@PostMapping(path = "/add") public @ResponseBody String addSms(@RequestParam int id,
			@RequestBody Sms sms) {
		sms.setTime(new Date());
		smsRepository.save(sms);
		if(userRepository.existsById(id)) {
			User user = userRepository
					.findById(id)
					.get();
			String msg = user.getName() + ", " + sms.getStr();
			return sendSmsUtility.sendSms(user.getPhone(), msg) ? "SUCCESS" : "FAILURE";
		} else {
			return "User Not Found";
		}
	}
}
