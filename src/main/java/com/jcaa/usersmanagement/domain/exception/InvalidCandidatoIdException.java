package com.jcaa.usersmanagement.domain.exception;

public final class InvalidCandidatoIdException extends DomainException {

  private static final String MESSAGE_EMPTY = "The candidato id must not be empty.";

  private InvalidCandidatoIdException(final String message) {
    super(message);
  }

  public static InvalidCandidatoIdException becauseValueIsEmpty() {
    return new InvalidCandidatoIdException(MESSAGE_EMPTY);
  }
}
