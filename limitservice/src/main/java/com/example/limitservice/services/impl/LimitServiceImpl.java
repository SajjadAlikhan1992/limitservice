package com.example.limitservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.limitservice.domain.LimitService;
import com.example.limitservice.services.LimitServices;

@Service
public class LimitServiceImpl implements LimitServices {

	@Autowired
	private LimitService limitService;

	@Override
	public LimitService getLimits() {
		return new LimitService(limitService.getMin(), limitService.getMax());
	}

}
