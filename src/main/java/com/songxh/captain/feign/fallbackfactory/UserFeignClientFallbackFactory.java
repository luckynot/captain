package com.songxh.captain.feign.fallbackfactory;

import com.songxh.captain.feign.UserFeignClient;
import com.songxh.captain.model.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * user feign client fallback factory
 *
 * @author hexiaosong
 * @date 2019-04-21
 */
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        return id -> {
            LOGGER.error("[hystrix] UserFeignClient.findById({id}) error", id, throwable);
            return new User(null, "default", "default", 10, new BigDecimal(0));
        };
    }
}
