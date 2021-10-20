package com.malik.ithar.spring.cloud.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertiesResponse {

    private int lockoutMaxAttempts;
    private int lockoutDuration;
    private String message;
    private String status;

    public PropertiesResponse(String lockoutMaxAttempts, int lockoutDuration, String msg) {
       this.lockoutMaxAttempts = Integer.parseInt(lockoutMaxAttempts);
       this.lockoutDuration = lockoutDuration;
       this.message = msg;

       if (msg.contains("CONFIG-SERVER-REPO")) {
           this.status = "**** SUCCESS ****"; //  properties are obtained from config server
       } else {
           this.status = "**** FAIL ****";
       }

    }
}
