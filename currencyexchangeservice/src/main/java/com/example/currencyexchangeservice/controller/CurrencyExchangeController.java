package com.example.currencyexchangeservice.controller;

import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyexchangeservice.domain.CurrencyExchange;
import com.example.currencyexchangeservice.services.CurrencyExchangeServices;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeServices currencyExchangeServices;

	// @GetMapping("/currencyexchange/from/{fromCurrency}/to/{toCurrency}")
	@GetMapping("/currencyexchange")
	public List<CurrencyExchange> fetchExchangeRates() {
		List<CurrencyExchange> exchangeRates = currencyExchangeServices.fetchAllExchangeRates();
		List<CurrencyExchange> exchangeRatesList = new LinkedList<>();
		for (CurrencyExchange currencyExchange : exchangeRates) {
			currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
			exchangeRatesList.add(currencyExchange);
		}
		return exchangeRatesList;
	}

	@GetMapping("/currencyexchange/from/{fromCurrency}/to/{toCurrency}")
	public ResponseEntity<CurrencyExchange> fetchExchangeRatesBasedOnFromAndToCurreny(
			@PathVariable("fromCurrency") String fromCurrency, @PathVariable("toCurrency") String toCurrency) {
		{
			CurrencyExchange currencyExchange = currencyExchangeServices
					.fetchBasedOnFromCurrenyAndToCurreny(fromCurrency, toCurrency);
			currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
			ResponseEntity<CurrencyExchange> response = ResponseEntity.ok(currencyExchange);
			return response;
		}
	}

}
