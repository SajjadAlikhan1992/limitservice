package com.example.limitservice.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ConfigurationProperties(prefix = "limitservice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class LimitService {

	private int min;
	private int max;

}
