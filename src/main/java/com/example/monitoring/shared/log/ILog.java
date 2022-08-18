package com.example.monitoring.shared.log;

public interface ILog {
  void info(String info);
  void info(String message, Object... args);
  void error(String message);
}
