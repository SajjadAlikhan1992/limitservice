package com.example.currencyexchangeservice.services;

import java.util.List;

import com.example.currencyexchangeservice.domain.CurrencyExchange;

public interface CurrencyExchangeServices {

	public List<CurrencyExchange> fetchAllExchangeRates();

	public CurrencyExchange fetchBasedOnFromCurrenyAndToCurreny(String fromCurrency, String toCurrency);

}
