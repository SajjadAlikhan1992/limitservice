package com.example.currencyexchangeservice.domain;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CurrencyExchange {

	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiples;
	private String environment;

}
