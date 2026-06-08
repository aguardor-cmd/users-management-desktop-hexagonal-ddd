package com.jcaa.usersmanagement.domain.exception;

public final class InvalidCandidatoCiudadException extends DomainException {

  private static final String MESSAGE_EMPTY = "The candidato ciudad must not be empty.";
  private static final String MESSAGE_TOO_SHORT = "The candidato ciudad must have at least %d characters.";

  private InvalidCandidatoCiudadException(final String message) {
    super(message);
  }

  public static InvalidCandidatoCiudadException becauseValueIsEmpty() {
    return new InvalidCandidatoCiudadException(MESSAGE_EMPTY);
  }

  public static InvalidCandidatoCiudadException becauseLengthIsTooShort(final int minimumLength) {
    return new InvalidCandidatoCiudadException(String.format(MESSAGE_TOO_SHORT, minimumLength));
  }
}
