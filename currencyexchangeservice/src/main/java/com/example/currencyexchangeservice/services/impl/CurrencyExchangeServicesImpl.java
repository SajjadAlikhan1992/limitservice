package com.example.currencyexchangeservice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.currencyexchangeservice.domain.CurrencyExchange;
import com.example.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.example.currencyexchangeservice.services.CurrencyExchangeServices;

@Service
public class CurrencyExchangeServicesImpl implements CurrencyExchangeServices {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@Override
	public List<CurrencyExchange> fetchAllExchangeRates() {
		Optional<List<CurrencyExchange>> ofNullable = Optional.ofNullable(currencyExchangeRepository.findAll());
		if (ofNullable.isPresent()) {
			List<CurrencyExchange> list = ofNullable.get();
			return list;
		} else {
			return null;
		}
	}

	@Override
	public CurrencyExchange fetchBasedOnFromCurrenyAndToCurreny(String fromCurrency, String toCurrency) {
		Optional<CurrencyExchange> optional = Optional
				.ofNullable(currencyExchangeRepository.findByFromAndTo(fromCurrency, toCurrency));
		if (optional.isPresent()) {
			CurrencyExchange currencyExchange = optional.get();
			return currencyExchange;
		} else {
			return null;
		}
	}
}
