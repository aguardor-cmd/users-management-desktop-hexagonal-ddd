package com.jcaa.usersmanagement.domain.exception;

public final class InvalidCandidatoPaisException extends DomainException {

  private static final String MESSAGE_EMPTY = "The candidato pais must not be empty.";
  private static final String MESSAGE_TOO_SHORT = "The candidato pais must have at least %d characters.";

  private InvalidCandidatoPaisException(final String message) {
    super(message);
  }

  public static InvalidCandidatoPaisException becauseValueIsEmpty() {
    return new InvalidCandidatoPaisException(MESSAGE_EMPTY);
  }

  public static InvalidCandidatoPaisException becauseLengthIsTooShort(final int minimumLength) {
    return new InvalidCandidatoPaisException(String.format(MESSAGE_TOO_SHORT, minimumLength));
  }
}
