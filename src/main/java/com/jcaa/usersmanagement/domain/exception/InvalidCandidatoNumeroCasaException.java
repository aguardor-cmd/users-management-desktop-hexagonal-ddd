package com.jcaa.usersmanagement.domain.exception;

public final class InvalidCandidatoNumeroCasaException extends DomainException {

  private static final String MESSAGE_EMPTY = "The candidato numero casa must not be empty.";
  private static final String MESSAGE_INVALID_FORMAT =
      "The candidato numero casa format is invalid: '%s'.";

  private InvalidCandidatoNumeroCasaException(final String message) {
    super(message);
  }

  public static InvalidCandidatoNumeroCasaException becauseValueIsEmpty() {
    return new InvalidCandidatoNumeroCasaException(MESSAGE_EMPTY);
  }

  public static InvalidCandidatoNumeroCasaException becauseFormatIsInvalid(
      final String numeroCasa) {
    return new InvalidCandidatoNumeroCasaException(
        String.format(MESSAGE_INVALID_FORMAT, numeroCasa));
  }
}
