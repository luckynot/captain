package com.songxh.captain.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * captain配置类
 *
 * @author hexiaosong
 * @date 2019-04-23
 */
@Configuration
@Getter
public class CaptainConfig {

    @Value("${env}")
    private String env;
}
