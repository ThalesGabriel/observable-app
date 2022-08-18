package com.example.monitoring.shared.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log implements ILog  {

  private final Logger log;

  public Log(Class clazz) {
    this.log = LoggerFactory.getLogger(clazz);
  }

  @Override
  public void info(String info) {
    this.log.info(info);
  }

  @Override
  public void info(String message, Object... arguments) {
    this.log.info(message, arguments);
  }

  @Override
  public void error(String message) {
    this.log.error(message);
  }
}
