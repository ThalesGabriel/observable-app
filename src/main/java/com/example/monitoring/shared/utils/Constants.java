package com.example.monitoring.shared.utils;

public class Constants {
  public static final String USER_STR = "USER";
  public static final String COMPANY_STR = "COMPANY";
  public static final String STOCK_STR = "STOCK";
  public static final String CPF_STR = "CPF";
  public static final String NAME_STR = "NAME";
  public static final String EXCHANGE_STR = "EXCHANGE";
  public static final String TICKER_STR = "TICKER";
  public static final String PRICE_STR = "PRICE";
  public static final String LERO_LERO = """
      Todavia, a estrutura atual da organização exige a
      precisão e a definição dos métodos utilizados na avaliação de resultados."""; //https://lerolero.com/
  public static final Integer MAX_NAME_LEN = 30;
  public static final Integer MIN_NAME_LEN = 3;
  public static final Integer MAX_TICKER_LEN = 7;
  public static final Integer MIN_TICKER_LEN = 5;
  public static final String NO_RECORDS_FOUND_FOR_TOPIC = "NO RECORDS FOUND FOR TOPIC.";
  public static final String COMPANY_EVENT = "COMPANY_EVENT";
  public static final Integer KAFKA_TIMEOUT = 5000;
}
