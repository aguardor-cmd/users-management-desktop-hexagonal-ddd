package com.jcaa.usersmanagement.domain.exception;

public final class InvalidCandidatoTelefonoException extends DomainException {

  private static final String MESSAGE_EMPTY = "The candidato telefono must not be empty.";
  private static final String MESSAGE_INVALID_FORMAT =
      "The candidato telefono format is invalid: '%s'.";

  private InvalidCandidatoTelefonoException(final String message) {
    super(message);
  }

  public static InvalidCandidatoTelefonoException becauseValueIsEmpty() {
    return new InvalidCandidatoTelefonoException(MESSAGE_EMPTY);
  }

  public static InvalidCandidatoTelefonoException becauseFormatIsInvalid(final String telefono) {
    return new InvalidCandidatoTelefonoException(String.format(MESSAGE_INVALID_FORMAT, telefono));
  }
}
