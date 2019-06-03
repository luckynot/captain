package com.songxh.captain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * app starter
 *
 * @author hexiaosong
 * @date 2019-03-31
 */
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class CaptainApp {

    public static void main(String[] args) {
        SpringApplication.run(CaptainApp.class, args);
    }
}
