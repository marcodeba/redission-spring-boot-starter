package com.springboot.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@EnableConfigurationProperties(RedissonProperties.class)
@ConditionalOnClass(Redisson.class)
public class RedissonAutoConfiguration {
    @Bean
    public RedissonClient redissonClient(RedissonProperties redissonProperties) {
        Config config = new Config();
        String prefix = StringUtils.isEmpty(redissonProperties.isSsl()) ? "redis://" : "rediss://";
        config.useSingleServer().
                setAddress(prefix + redissonProperties.getHost() + ":" + redissonProperties.getPort()).
                setConnectTimeout(redissonProperties.getTimeOut());

        return Redisson.create(config);
    }
}
