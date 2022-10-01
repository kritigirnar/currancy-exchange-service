package com.in28Minutes.microservices.currancyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrancyExchangeRepository extends JpaRepository<CurrancyExchange, Long>{

	CurrancyExchange findByFromAndTo(String from, String to);
	
}
