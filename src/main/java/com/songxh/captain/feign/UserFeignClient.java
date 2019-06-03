package com.songxh.captain.feign;

import com.songxh.captain.feign.fallback.UserFeignClientFallback;
import com.songxh.captain.model.User;
import feign.Feign;
import feign.Logger;
import feign.hystrix.HystrixFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户feign client
 *
 * @author hexiaosong
 * @date 2019-04-17
 */
@FeignClient(name = "iron-man", fallback = UserFeignClientFallback.class, configuration = UserFeignClient.EnableHystrixFeignConfig.class)
//@FeignClient(name = "iron-man", fallbackFactory = UserFeignClientFallbackFactory.class, configuration = UserFeignClient.EnableHystrixFeignConfig.class)
public interface UserFeignClient {

    @GetMapping("/ironMan/users/{id}")
    User findById(@PathVariable("id") Long id);

    class EnableHystrixFeignConfig {
        @Bean
        public HystrixFeign.Builder enableHystrix() {
            return HystrixFeign.builder();
        }

        @Bean
        public Logger.Level logger() {
            return Logger.Level.FULL;
        }
    }

    class DisableHystrixFeignConfig {
        @Bean
        public Feign.Builder disableHystrix() {
            return Feign.builder();
        }
    }
}
