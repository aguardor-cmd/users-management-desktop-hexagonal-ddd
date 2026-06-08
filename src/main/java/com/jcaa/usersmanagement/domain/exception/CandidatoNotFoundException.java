package com.jcaa.usersmanagement.domain.exception;

public final class CandidatoNotFoundException extends DomainException {

  private static final String MESSAGE_BY_ID = "The candidato with id '%s' was not found.";

  private CandidatoNotFoundException(final String message) {
    super(message);
  }

  public static CandidatoNotFoundException becauseIdWasNotFound(final String candidatoId) {
    return new CandidatoNotFoundException(String.format(MESSAGE_BY_ID, candidatoId));
  }
}
