package com.expedia.expspeech.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.expedia.expspeech.POJO.Log;
import com.expedia.expspeech.repository.LogRepository;

@Controller @RequestMapping(path = "/log") public class LogController {
	@Autowired private LogRepository logRepository;

	@PostMapping(path = "/add") public @ResponseBody String addLog(@RequestBody Log log) {
		log.setTime(new Date());
		logRepository.save(log);
		return "Saved";
	}
}
