package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidCandidatoNumeroCasaException;
import java.util.Objects;
import java.util.regex.Pattern;

public record CandidatoNumeroCasa(String value) {

  private static final Pattern NUMERO_CASA_PATTERN = Pattern.compile("^[A-Za-z0-9\\-]{1,10}$");

  public CandidatoNumeroCasa {
    final String normalizedValue =
        Objects.requireNonNull(value, "CandidatoNumeroCasa cannot be null").trim();
    validateNotEmpty(normalizedValue);
    validateFormat(normalizedValue);
    value = normalizedValue;
  }

  private static void validateNotEmpty(final String normalizedValue) {
    if (normalizedValue.isEmpty()) {
      throw InvalidCandidatoNumeroCasaException.becauseValueIsEmpty();
    }
  }

  private static void validateFormat(final String normalizedValue) {
    if (!NUMERO_CASA_PATTERN.matcher(normalizedValue).matches()) {
      throw InvalidCandidatoNumeroCasaException.becauseFormatIsInvalid(normalizedValue);
    }
  }

  @Override
  public String toString() {
    return value;
  }
}
