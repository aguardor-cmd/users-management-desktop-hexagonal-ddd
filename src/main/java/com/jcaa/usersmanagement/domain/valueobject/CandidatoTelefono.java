package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidCandidatoTelefonoException;
import java.util.Objects;
import java.util.regex.Pattern;

public record CandidatoTelefono(String value) {

  private static final Pattern TELEFONO_PATTERN = Pattern.compile("^[0-9]{7,15}$");

  public CandidatoTelefono {
    final String normalizedValue =
        Objects.requireNonNull(value, "CandidatoTelefono cannot be null").trim();
    validateNotEmpty(normalizedValue);
    validateFormat(normalizedValue);
    value = normalizedValue;
  }

  private static void validateNotEmpty(final String normalizedValue) {
    if (normalizedValue.isEmpty()) {
      throw InvalidCandidatoTelefonoException.becauseValueIsEmpty();
    }
  }

  private static void validateFormat(final String normalizedValue) {
    if (!TELEFONO_PATTERN.matcher(normalizedValue).matches()) {
      throw InvalidCandidatoTelefonoException.becauseFormatIsInvalid(normalizedValue);
    }
  }

  @Override
  public String toString() {
    return value;
  }
}
