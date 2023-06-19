package com.example.currencyconversionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.currencyconversionservice.domain.CurrencyConversion;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Long>{

}
