package com.vmtapp.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class VarmentTmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VarmentTmsApplication.class, args);
    }

}
