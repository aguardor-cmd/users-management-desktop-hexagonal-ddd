package com.jcaa.usersmanagement.domain.exception;

public final class CandidatoAlreadyExistsException extends DomainException {

  private static final String MESSAGE_CORREO_EXISTS =
      "A candidato with correo '%s' already exists.";

  private CandidatoAlreadyExistsException(final String message) {
    super(message);
  }

  public static CandidatoAlreadyExistsException becauseCorreoAlreadyExists(final String correo) {
    return new CandidatoAlreadyExistsException(String.format(MESSAGE_CORREO_EXISTS, correo));
  }
}
