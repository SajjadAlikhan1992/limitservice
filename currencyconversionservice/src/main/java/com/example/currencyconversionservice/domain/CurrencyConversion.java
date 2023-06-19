package com.example.currencyconversionservice.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class CurrencyConversion {

	@Id
	private Long id;
	@Column(name = "currency_from")
	private String from;
	@Column(name = "currency_to")
	private String to;
	private BigDecimal conversionMultiples;
	private BigDecimal quantity;
	private BigDecimal totalCaluculatedAmount;
	@Transient
	private String environment;

}
