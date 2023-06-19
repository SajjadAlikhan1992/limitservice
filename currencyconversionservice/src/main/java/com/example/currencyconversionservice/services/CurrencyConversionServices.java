package com.example.currencyconversionservice.services;

import java.math.BigDecimal;

import com.example.currencyconversionservice.domain.CurrencyConversion;

public interface CurrencyConversionServices {

	public CurrencyConversion fetchCurrencyConversion(String fromCurrency, String toCurrency, BigDecimal quantity);

}
