# java-spring-boot-spring-cloud-microservices
SPRINGBOOT:MVN:MICROSERVICE:EUREKA:API-GATEWAY:CONFIG-SERVER:MULTI-MODULE

### Features
- Config server linked to git repo reading 'stg' properties file {configuration-properties-application-prod.properties}
- Configuration service exposing values from the Config server with retry resilience
- Eureka naming sever
- API gateway with route configuration & global logging
- Feign client with load balancing (currency-conversion-application)
- Exchange service with multiple instances running on different ports (currency-exchange-service)
- JPA h2 (currency-exchange-service)

### Modules 
- config-server
- eureka-server
- api-gateway  
- configuration-properties-service
- currency-exchange-service  
- currency-conversion-service

### Local properties' git (set-up) config server
``` 
cd git-localconfig-repo
git init 
vim configuration-properties-application.properties
git commit -m 'Added local limit service properties file'
```

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

### Application Run

### Application URL
Service Name | Port | Url | Supporting Url
--- | --- | --- |--- |
Configuration Properties Service | 8080 | http://localhost:8080/configuration-properties/api/v1 |
Currency Conversion Service | 8100 | http://localhost:8100/currency-convertor/v2/convert/usd/gbp?quantity=2 | http://localhost:8100/currency-convertor/v1/convert/usd/gbp?quantity=2
Currency Exchange Service | 8000,8001,8002 | http://localhost:8000/currency-exchange/v1/exchange/eur/usd | http://localhost:8000/h2-console/
Config Server | 8888 | http://localhost:8888 | http://localhost:8888/configuration-properties-application/default <b/> http://localhost:8888/configuration-properties-application/stg
Eureka Server | 8761 | http://localhost:8761 | 
API Gateway | 8765 | http://localhost:8765/convertor-api/v2/convert/usd/gbp?quantity=2 <br /><br /> http://localhost:8765/exchanger-api/v1/exchange/eur/usd  


### Application GIT branches
- main

### Further enhancements 