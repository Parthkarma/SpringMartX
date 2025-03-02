package com.ecommerce.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync  // ✅ Enables Async Methods Globally
public class AsyncConfig {

 @Bean(name = "asyncExecutor")
 public Executor asyncExecutor() {
  ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
  executor.setCorePoolSize(5);
  executor.setMaxPoolSize(10);
  executor.setQueueCapacity(100);
  executor.setThreadNamePrefix("AsyncThread-");
  executor.initialize();
  return executor;
 }
}
