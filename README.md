# java-spring-boot-spring-cloud-microservices
SPRING:MVN:MICROSERVICE

## Modules 
- java-spring-boot-spring-cloud-limiting-service
- java-spring-boot-spring-cloud-config-service

## Local properties' git (set-up)
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
Limiting Service | 8080 | http://localhost:8080
Config Server | 8888 | http://localhost:8888 or http://localhost:8888/limit-service/default 

## Application GIT branches
- main

## Further enhancements 