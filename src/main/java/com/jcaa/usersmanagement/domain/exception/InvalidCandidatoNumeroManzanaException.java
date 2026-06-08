package com.jcaa.usersmanagement.domain.exception;

public final class InvalidCandidatoNumeroManzanaException extends DomainException {

  private static final String MESSAGE_EMPTY = "The candidato numero manzana must not be empty.";
  private static final String MESSAGE_INVALID_FORMAT =
      "The candidato numero manzana format is invalid: '%s'.";

  private InvalidCandidatoNumeroManzanaException(final String message) {
    super(message);
  }

  public static InvalidCandidatoNumeroManzanaException becauseValueIsEmpty() {
    return new InvalidCandidatoNumeroManzanaException(MESSAGE_EMPTY);
  }

  public static InvalidCandidatoNumeroManzanaException becauseFormatIsInvalid(
      final String numeroManzana) {
    return new InvalidCandidatoNumeroManzanaException(
        String.format(MESSAGE_INVALID_FORMAT, numeroManzana));
  }
}
