package com.example.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyconversionservice.domain.CurrencyConversion;
import com.example.currencyconversionservice.feign.services.CurrrencyExchangeProxy;
import com.example.currencyconversionservice.services.CurrencyConversionServices;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionServices currencyConversionServices;

	@Autowired
	private CurrrencyExchangeProxy currencyExchangeProxy;

	@Autowired
	private Environment environment;

	Logger logger = Logger.getLogger("CurrencyConversion.class");

	@GetMapping("/currencyconversion/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversion> fetchCurrencyConversion(@PathVariable("fromCurrency") String fromCurrency,
			@PathVariable("toCurrency") String toCurrency, @PathVariable("quantity") BigDecimal quantity) {
		logger.info("fromCurrency -> " + fromCurrency + "toCurrency ->" + toCurrency + "and Quantity ->" + quantity);
		CurrencyConversion currencyConversion = currencyConversionServices.fetchCurrencyConversion(fromCurrency,
				toCurrency, quantity);
		currencyConversion.setEnvironment(environment.getProperty("local.server.port") + " Rest Template ");
		ResponseEntity<CurrencyConversion> responseEntity = new ResponseEntity<CurrencyConversion>(currencyConversion,
				HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/currencyconversion-feign/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversion> fetchCurrencyConversionbyFeign(
			@PathVariable("fromCurrency") String fromCurrency, @PathVariable("toCurrency") String toCurrency,
			@PathVariable("quantity") BigDecimal quantity) {
		logger.info("fromCurrency -> " + fromCurrency + "toCurrency ->" + toCurrency + "and Quantity ->" + quantity);

		CurrencyConversion currencyConversion = currencyExchangeProxy
				.fetchExchangeRatesBasedOnFromAndToCurreny(fromCurrency, toCurrency);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCaluculatedAmount(quantity.multiply(currencyConversion.getConversionMultiples()));
		currencyConversion.setEnvironment(environment.getProperty("local.server.port") + " feign ");

		return ResponseEntity.ok(currencyConversion);
	}

}
