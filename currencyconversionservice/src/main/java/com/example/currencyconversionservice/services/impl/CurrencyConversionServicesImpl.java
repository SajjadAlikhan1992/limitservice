package com.example.currencyconversionservice.services.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.currencyconversionservice.domain.CurrencyConversion;
import com.example.currencyconversionservice.services.CurrencyConversionServices;

@Service
public class CurrencyConversionServicesImpl implements CurrencyConversionServices {

	@Autowired
	private RestTemplate restTemplate;

	private static String EXCHNAGESERVICE_URL = "http://localhost:8000/currencyexchange/from/{fromCurrency}/to/{toCurrency}";
	Logger logger = Logger.getLogger("CurrencyConversionServicesImpl.class");

	public CurrencyConversion fetchCurrencyConversion(String fromCurrency, String toCurrency, BigDecimal quantity) {
		Map<String, String> uriVaraibles = new HashMap();
		uriVaraibles.put("fromCurrency", fromCurrency);
		uriVaraibles.put("toCurrency", toCurrency);
		logger.info("making a call to Exchange service");
		ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity(EXCHNAGESERVICE_URL,
				CurrencyConversion.class, uriVaraibles);

		CurrencyConversion currencyConversion = responseEntity.getBody();
		System.err.println(currencyConversion);
		currencyConversion.setQuantity(quantity);
		logger.info("currencyConversion -> { }" + currencyConversion);
		currencyConversion.setTotalCaluculatedAmount(quantity.multiply(currencyConversion.getConversionMultiples()));

		return currencyConversion;
	}
}
