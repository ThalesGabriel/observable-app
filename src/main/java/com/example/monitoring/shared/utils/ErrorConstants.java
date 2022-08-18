package com.example.monitoring.shared.utils;

public class ErrorConstants {

  public static final String STRING_SHOULD_NOT_BE_NULL = "'{}' SHOULD NOT BE NULL.";
  public static final String STRING_SHOULD_NOT_BE_BLANK = "'{}' SHOULD NOT BE BLANK.";
  public static final String CPF_INVALID_FORMAT = "CPF INVALID FORMAT '{}'.";
  public static final String CPF_INVALID = "CPF IS INVALID '{}'.";
  public static final String USER_DOES_NOT_EXISTS = "USER WITH CPF {} NOT FOUND.";
  public static final String NAME_LENGTH_INVALID = "'NAME' MUST BE BETWEEN 3 AND 30 CHARACTERS.";
  public static final String COMPANY_DOES_NOT_EXISTS = "COMPANY WITH TICKER '{}' NOT FOUND.";
  public static final String COMPANY_NOT_DELETED_BC_IT_DOES_NOT_EXIST = "COMPANY WITH TICKER '{}' NOT DELETE BECAUSE IT WAS NOT FOUND.";
  public static final String GATEWAY_DELETE_STR = "COULD NOT DELETE OBJECT {}";
  public static final String GATEWAY_FIND_STR = "COULD NOT FIND OBJECT {}";
  public static final String GATEWAY_UPDATE_STR = "COULD NOT UPDATE OBJECT {}";
  public static final String GATEWAY_ERROR_STR = "GATEWAY ERROR.";
  public static final String USER_ALREADY_EXISTS = "USER WITH CPF: {} ALREADY EXISTS.";
  public static final String TICKER_LENGTH_INVALID = "'TICKER' MUST BE BETWEEN 5 AND 7 CHARACTERS.";
  public static final String GATEWAY_INSERT_STR = "COULD NOT INSERT OBJECT {}";
  public static final String COMPANY_ALREADY_EXISTS = "COMPANY WITH TICKER: {} ALREADY EXISTS.";
  public static final String PARSE_ERROR = "COULD NOT PARSE OBJECT WHEN SENDING EVENT. WE GONNA RETRY IT LATER.";
  public static final String YOU_NEED_A_MODIFIER = "YOU NEED TO EXPLICITLY DEFINE A MODIFIER(UPDATE, ACTIVATE OR DEACTIVATE) BEFORE EXECUTE METHOD.";
  public static final String COMPANY_NOT_UPDATED = "COMPANY TICKER '{}' NOT UPDATED BECAUSE SOMETHING IS WRONG WITH THIS REQUEST '{}'";
  public static final String PRICE_INVALID = "'PRICE' MUST BE BIGGER THAN 0.";
  public static final String USER_VALIDATION_ERRORS = "OBJECT USER '{}' VALIDATED BUT RETURNED WITH ERRORS: {}.";
}
