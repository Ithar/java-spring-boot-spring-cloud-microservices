package com.malik.ithar.spring.cloud.exchangeservice.repository;

import com.malik.ithar.spring.cloud.exchangeservice.domain.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeRate, Long> {

    Optional<ExchangeRate> findByFromAndTo(String from, String to);

}
