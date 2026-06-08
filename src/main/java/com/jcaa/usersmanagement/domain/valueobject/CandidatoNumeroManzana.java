package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidCandidatoNumeroManzanaException;
import java.util.Objects;
import java.util.regex.Pattern;

public record CandidatoNumeroManzana(String value) {

  private static final Pattern NUMERO_MANZANA_PATTERN = Pattern.compile("^[A-Za-z0-9\\-]{1,10}$");

  public CandidatoNumeroManzana {
    final String normalizedValue =
        Objects.requireNonNull(value, "CandidatoNumeroManzana cannot be null").trim();
    validateNotEmpty(normalizedValue);
    validateFormat(normalizedValue);
    value = normalizedValue;
  }

  private static void validateNotEmpty(final String normalizedValue) {
    if (normalizedValue.isEmpty()) {
      throw InvalidCandidatoNumeroManzanaException.becauseValueIsEmpty();
    }
  }

  private static void validateFormat(final String normalizedValue) {
    if (!NUMERO_MANZANA_PATTERN.matcher(normalizedValue).matches()) {
      throw InvalidCandidatoNumeroManzanaException.becauseFormatIsInvalid(normalizedValue);
    }
  }

  @Override
  public String toString() {
    return value;
  }
}
