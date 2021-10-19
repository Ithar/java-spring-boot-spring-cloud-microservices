# java-spring-boot-spring-cloud-microservices
SPRINGBOOT:MVN:MICROSERVICE

## Modules 
- config-server
- eureka-server
- api-gateway  
- limiting-service
- currency-exchange-service (Multiple instances)  
- currency-conversion-service

## Local properties' git (set-up) config server
``` 
cd git-localconfig-repo
git init 
vim limit-service.properties
git commit -m 'Added local limit service properties file'
```

### Features
- Config server linked to git repo reading properties file
- Eureka naming sever
- Feign client with load balancing (for currency-conversion-application)
- JPA h2
- API gateway with route configuration

## 

## Application Stack

Stack  | version |
--- | --- |  
*Java* | 11
*SpringBoot* |  2.5.5
*Frontend* | n/a
*DB* | n/a
*Server* | Jetty (embedded)
*Build Tool* | Maven
*CI* | n/a
*Code Coverage* | n/a
*Build env* | docker-compose

## Application Run

## Application URL
Service Name | Port | Url | Supporting Url
--- | --- | --- |--- |
Limiting Service | 8080 | http://localhost:8080/limiting-service/v1/limit |
Currency Conversion Service | 8100 | http://localhost:8100/currency-convertor/v2/convert/usd/gbp?quantity=2 | http://localhost:8100/currency-convertor/v1/convert/usd/gbp?quantity=2
Currency Exchange Service | 8000,8001,8002 | http://localhost:8000/currency-exchange/v1/exchange/eur/usd | http://localhost:8000/h2-console/
Config Server | 8888 | http://localhost:8888 | http://localhost:8888/limit-service/default
Eureka Server | 8761 | http://localhost:8761 | 
API Gateway | 8765 | http://localhost:8765/convertor-api/v2/convert/usd/gbp?quantity=2 <br /><br /> http://localhost:8765/exchanger-api/v1/exchange/eur/usd  


## Application GIT branches
- main

## Further enhancements 