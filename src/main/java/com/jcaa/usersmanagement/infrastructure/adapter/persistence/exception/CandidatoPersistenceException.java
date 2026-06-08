package com.jcaa.usersmanagement.infrastructure.adapter.persistence.exception;

public final class CandidatoPersistenceException extends RuntimeException {

  private static final String MESSAGE_SAVE = "Failed to save candidato with ID: '%s'.";
  private static final String MESSAGE_UPDATE = "Failed to update candidato with ID: '%s'.";
  private static final String MESSAGE_FIND = "Failed to find candidato with ID: '%s'.";
  private static final String MESSAGE_CORREO = "Failed to find candidato with correo: '%s'.";
  private static final String MESSAGE_ALL = "Failed to retrieve all candidatos.";
  private static final String MESSAGE_DELETE = "Failed to delete candidato with ID: '%s'.";

  private CandidatoPersistenceException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public static CandidatoPersistenceException becauseSaveFailed(final String candidatoId, final Throwable cause) {
    return new CandidatoPersistenceException(String.format(MESSAGE_SAVE, candidatoId), cause);
  }

  public static CandidatoPersistenceException becauseUpdateFailed(
      final String candidatoId, final Throwable cause) {
    return new CandidatoPersistenceException(String.format(MESSAGE_UPDATE, candidatoId), cause);
  }

  public static CandidatoPersistenceException becauseFindByIdFailed(
      final String candidatoId, final Throwable cause) {
    return new CandidatoPersistenceException(String.format(MESSAGE_FIND, candidatoId), cause);
  }

  public static CandidatoPersistenceException becauseFindByCorreoFailed(
      final String correo, final Throwable cause) {
    return new CandidatoPersistenceException(String.format(MESSAGE_CORREO, correo), cause);
  }

  public static CandidatoPersistenceException becauseFindAllFailed(final Throwable cause) {
    return new CandidatoPersistenceException(MESSAGE_ALL, cause);
  }

  public static CandidatoPersistenceException becauseDeleteFailed(
      final String candidatoId, final Throwable cause) {
    return new CandidatoPersistenceException(String.format(MESSAGE_DELETE, candidatoId), cause);
  }
}
