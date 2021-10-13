# java-spring-boot-spring-cloud-microservices
SPRING:MVN:MICROSERVICE

## Modules 
- limiting-service
- exchange-service  
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
Service Name | Port | Url |
--- | --- | --- |
Limiting Service | 8080 | http://localhost:8080/limiting-service/v1/limit
Exchange Service | 8000 | http://localhost:8000/exchange-service/v1/exchange/{from}/{to}
Config Server | 8888 | http://localhost:8888 or http://localhost:8888/limit-service/default


## Application GIT branches
- main

## Further enhancements 