package com.malik.ithar.spring.cloud.convertor.proxy;

import com.malik.ithar.spring.cloud.convertor.dto.ConfigurationPropertiesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// Let the Feign get the API based on Spring application name
@FeignClient(name="configuration-properties-application", url = "${feign.client.configuration.properties.application.url}")
public interface ConfigurationPropertiesProxy {

    @GetMapping("configuration-properties/api/v1")
    ConfigurationPropertiesDTO getProperties();
}
