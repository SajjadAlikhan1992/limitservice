package com.example.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyexchangeservice.domain.CurrencyExchange;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@GetMapping("/currencyexchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyExchange fetchExchangeRates(@PathVariable("fromCurrency") String fromCurrency,
			@PathVariable("toCurrency") String toCurrency) {

		CurrencyExchange currencyExchange = new CurrencyExchange(123L, "USD", "INR", BigDecimal.valueOf(68),
				environment.getProperty("local.server.port"));
		return currencyExchange;
	}
}
