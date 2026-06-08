package com.jcaa.usersmanagement.domain.exception;

public final class InvalidCandidatoCorreoException extends DomainException {

  private static final String MESSAGE_EMPTY = "The candidato correo must not be empty.";
  private static final String MESSAGE_INVALID_FORMAT = "The candidato correo format is invalid: '%s'.";

  private InvalidCandidatoCorreoException(final String message) {
    super(message);
  }

  public static InvalidCandidatoCorreoException becauseValueIsEmpty() {
    return new InvalidCandidatoCorreoException(MESSAGE_EMPTY);
  }

  public static InvalidCandidatoCorreoException becauseFormatIsInvalid(final String correo) {
    return new InvalidCandidatoCorreoException(String.format(MESSAGE_INVALID_FORMAT, correo));
  }
}
