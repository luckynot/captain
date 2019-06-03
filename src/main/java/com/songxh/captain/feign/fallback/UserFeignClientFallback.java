package com.songxh.captain.feign.fallback;

import com.songxh.captain.feign.UserFeignClient;
import com.songxh.captain.model.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * user feign client回调（hystrix断熔方法）
 *
 * @author hexiaosong
 * @date 2019-04-21
 */
@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        return new User(null, "default", "default", 10, new BigDecimal(0));
    }
}
