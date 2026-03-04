package com.sagar.threadscale.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
@Configuration
@EnableAsync
@Slf4j
public class AsyncThreadPoolConfig {

    @Value("${com.cod.async.microservice.corepoolsize:10}")
    private int corePoolSize;

    @Value("${com.cod.async.microservice.maxpoolsize:20}")
    private int maxPoolSize;

    @Bean(name = "otcServiceAsyncTaskExecutor")
    public Executor asyncTaskExecutor() {
        log.info("Creating Async Task Executor");

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setThreadNamePrefix("asyncexe-");
        executor.initialize();

        return executor;
    }
}