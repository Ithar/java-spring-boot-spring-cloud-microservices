# java-spring-boot-spring-cloud-microservices
SPRING:MVN:MICROSERVICE

## Modules 
- limiting-service
- exchange_rate-service  
- config-server

## Local properties' git (set-up) config server
``` 
cd git-localconfig-repo
git init 
vim limit-service.properties
git commit -m 'Added local limit service properties file'
```

### Features
- Config server linked to git repo reading properties file
- 


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
Currency Conversion Service | 8100 | http://localhost:8100/currency-convertor-service/v2/convert/usd/gbp?quantity=2 | http://localhost:8100/currency-convertor-service/v1/convert/usd/gbp?quantity=2
Currency Exchange Service | 8000 | http://localhost:8000/currency-exchange_rate-service/v1/exchange_rate/eur/usd | http://localhost:8000/h2-console/
Config Server | 8888 | http://localhost:8888 | http://localhost:8888/limit-service/default


## Application GIT branches
- main

## Further enhancements 