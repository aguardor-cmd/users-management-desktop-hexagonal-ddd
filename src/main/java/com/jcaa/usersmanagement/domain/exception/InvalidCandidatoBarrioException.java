package com.jcaa.usersmanagement.domain.exception;

public final class InvalidCandidatoBarrioException extends DomainException {

  private static final String MESSAGE_EMPTY = "The candidato barrio must not be empty.";
  private static final String MESSAGE_TOO_SHORT = "The candidato barrio must have at least %d characters.";

  private InvalidCandidatoBarrioException(final String message) {
    super(message);
  }

  public static InvalidCandidatoBarrioException becauseValueIsEmpty() {
    return new InvalidCandidatoBarrioException(MESSAGE_EMPTY);
  }

  public static InvalidCandidatoBarrioException becauseLengthIsTooShort(final int minimumLength) {
    return new InvalidCandidatoBarrioException(String.format(MESSAGE_TOO_SHORT, minimumLength));
  }
}
