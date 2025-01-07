package com.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class C_AyscThreadPoolExecutor {

    @Bean("AsyncExecutor")
    public Executor AsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.setThreadNamePrefix(" AsyncExecutor:-");
        taskExecutor.setAwaitTerminationSeconds(60);
        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.initialize();
        return taskExecutor;
    }


}
