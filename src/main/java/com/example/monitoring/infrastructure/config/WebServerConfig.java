package com.example.monitoring.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.example"})
public class WebServerConfig {
  public WebServerConfig() {
  }
}