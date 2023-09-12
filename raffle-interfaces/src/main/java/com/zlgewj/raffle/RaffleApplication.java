package com.zlgewj.raffle;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * 启动类
 *
 * @Author zlgewj
 * @Since 2023/9/5
 */
@SpringBootApplication
@Configuration
@EnableDubbo
public class RaffleApplication {
    public static void main(String[] args) {
        SpringApplication.run(RaffleApplication.class, args);
    }
}
