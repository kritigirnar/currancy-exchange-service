package com.in28Minutes.microservices.currancyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrancyExchnageController {
	
	@Autowired
	CurrancyExchangeRepository CurrancyExchangeRepository;

	@Autowired
	private Environment environment;	
	
	@GetMapping("/currancy-exchange/from/{from}/to/{to}")
	public CurrancyExchange retrieveExchangeService(@PathVariable String from,@PathVariable String to)
	{
		
		//CurrancyExchange currancyExchange = new CurrancyExchange(1000L, from, to, BigDecimal.valueOf(50));
		CurrancyExchange currancyExchange=CurrancyExchangeRepository.findByFromAndTo(from, to);
		String port=environment.getProperty("local.server.port");
		currancyExchange.setEnvironment(port);
		return currancyExchange;
	}
	
}
