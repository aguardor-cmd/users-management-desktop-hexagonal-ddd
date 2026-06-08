package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidCandidatoCorreoException;
import java.util.Objects;
import java.util.regex.Pattern;

public record CandidatoCorreo(String value) {

  private static final Pattern CORREO_PATTERN =
      Pattern.compile("^[a-zA-Z0-9._%+\\-]+@[a-zA-Z0-9.\\-]+\\.[a-zA-Z]{2,}$");

  public CandidatoCorreo {
    final String normalizedValue =
        Objects.requireNonNull(value, "CandidatoCorreo cannot be null").trim().toLowerCase();
    validateNotEmpty(normalizedValue);
    validateFormat(normalizedValue);
    value = normalizedValue;
  }

  private static void validateNotEmpty(final String normalizedValue) {
    if (normalizedValue.isEmpty()) {
      throw InvalidCandidatoCorreoException.becauseValueIsEmpty();
    }
  }

  private static void validateFormat(final String normalizedValue) {
    if (!CORREO_PATTERN.matcher(normalizedValue).matches()) {
      throw InvalidCandidatoCorreoException.becauseFormatIsInvalid(normalizedValue);
    }
  }

  @Override
  public String toString() {
    return value;
  }
}
