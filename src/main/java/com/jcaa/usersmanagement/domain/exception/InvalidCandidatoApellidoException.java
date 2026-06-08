package com.jcaa.usersmanagement.domain.exception;

public final class InvalidCandidatoApellidoException extends DomainException {

  private static final String MESSAGE_EMPTY = "The candidato apellido must not be empty.";
  private static final String MESSAGE_TOO_SHORT = "The candidato apellido must have at least %d characters.";

  private InvalidCandidatoApellidoException(final String message) {
    super(message);
  }

  public static InvalidCandidatoApellidoException becauseValueIsEmpty() {
    return new InvalidCandidatoApellidoException(MESSAGE_EMPTY);
  }

  public static InvalidCandidatoApellidoException becauseLengthIsTooShort(final int minimumLength) {
    return new InvalidCandidatoApellidoException(String.format(MESSAGE_TOO_SHORT, minimumLength));
  }
}
