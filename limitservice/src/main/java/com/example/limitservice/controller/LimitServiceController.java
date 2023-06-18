package com.example.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.limitservice.domain.LimitService;
import com.example.limitservice.services.LimitServices;

@RestController
public class LimitServiceController {

	@Autowired
	LimitServices limitServices;

	@GetMapping("/limits")
	public LimitService fetchLimits() {
		return limitServices.getLimits();
	}

}
