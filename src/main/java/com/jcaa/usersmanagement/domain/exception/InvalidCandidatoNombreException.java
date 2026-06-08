package com.jcaa.usersmanagement.domain.exception;

public final class InvalidCandidatoNombreException extends DomainException {

  private static final String MESSAGE_EMPTY = "The candidato nombre must not be empty.";
  private static final String MESSAGE_TOO_SHORT = "The candidato nombre must have at least %d characters.";

  private InvalidCandidatoNombreException(final String message) {
    super(message);
  }

  public static InvalidCandidatoNombreException becauseValueIsEmpty() {
    return new InvalidCandidatoNombreException(MESSAGE_EMPTY);
  }

  public static InvalidCandidatoNombreException becauseLengthIsTooShort(final int minimumLength) {
    return new InvalidCandidatoNombreException(String.format(MESSAGE_TOO_SHORT, minimumLength));
  }
}
