package com.example.currencyconversionservice.feign.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.currencyconversionservice.domain.CurrencyConversion;

@FeignClient(name = "currencyexchangeservice", url = "localhost:8000")
public interface CurrrencyExchangeProxy {

	@GetMapping("/currencyexchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyConversion fetchExchangeRatesBasedOnFromAndToCurreny(
			@PathVariable("fromCurrency") String fromCurrency, @PathVariable("toCurrency") String toCurrency);
}
