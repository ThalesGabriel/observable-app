package com.example.monitoring.domain.user.cpf;


import com.example.monitoring.shared.notification.INotification;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

import static com.example.monitoring.shared.utils.Constants.CPF_STR;
import static com.example.monitoring.shared.utils.Constants.USER_STR;
import static com.example.monitoring.shared.utils.ErrorConstants.*;

// https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097
public class CpfValidator implements ICpfValidator {

  public String removePunctuation(String cpf) {
    return cpf.trim().replaceAll("[^\\d ]", "");
  }

  public static boolean isCPF(String CPF) {
    // considera-se erro CPF's formados por uma sequencia de numeros iguais
    if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
      return (false);

    char dig10, dig11;
    int sm, i, r, num, peso;

    // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
    try {
      // Calculo do 1o. Digito Verificador
      sm = 0;
      peso = 10;
      for (i = 0; i < 9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
        num = (int) (CPF.charAt(i) - 48);
        sm = sm + (num * peso);
        peso = peso - 1;
      }

      r = 11 - (sm % 11);
      if ((r == 10) || (r == 11))
        dig10 = '0';
      else dig10 = (char) (r + 48); // converte no respectivo caractere numerico

      // Calculo do 2o. Digito Verificador
      sm = 0;
      peso = 11;
      for (i = 0; i < 10; i++) {
        num = (int) (CPF.charAt(i) - 48);
        sm = sm + (num * peso);
        peso = peso - 1;
      }

      r = 11 - (sm % 11);
      if ((r == 10) || (r == 11))
        dig11 = '0';
      else dig11 = (char) (r + 48);

      // Verifica se os digitos calculados conferem com os digitos informados.
      if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
        return (true);
      else return (false);
    } catch (InputMismatchException erro) {
      return (false);
    }
  }

  @Override
  public void validate(ICpf cpf, INotification notification) {
    String cpf_str = cpf.getValue();

    if (cpf_str == null) {
      notification.append(STRING_SHOULD_NOT_BE_NULL.replace("{}", CPF_STR), USER_STR);
      return;
    } else if (cpf_str.isEmpty()) {
      notification.append(STRING_SHOULD_NOT_BE_BLANK.replace("{}", CPF_STR), USER_STR);
    }

    cpf_str = this.removePunctuation(cpf_str);

    Pattern pattern = Pattern.compile(CPF_REGEX, Pattern.CASE_INSENSITIVE);
    if (!pattern.matcher(cpf_str).find())
      notification.append(CPF_INVALID_FORMAT.replace("{}", cpf_str), USER_STR);

    boolean isCpf = isCPF(cpf_str);
    if (!isCpf)
      notification.append(CPF_INVALID.replace("{}", cpf_str), USER_STR);
  }
}
