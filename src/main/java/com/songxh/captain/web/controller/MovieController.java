package com.songxh.captain.web.controller;

import com.songxh.captain.config.CaptainConfig;
import com.songxh.captain.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * movie controller
 *
 * @author hexiaosong
 * @date 2019-04-09
 */
@RequestMapping(value = "/movie")
@RestController
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private CaptainConfig captainConfig;

    @GetMapping(value = "/user/{id}")
    public Object findUserById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    @GetMapping(value = "/env")
    public Object getEnv() {
        return captainConfig.getEnv();
    }
}
