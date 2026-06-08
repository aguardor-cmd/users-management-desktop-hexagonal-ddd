package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.domain.exception.CandidatoNotFoundException;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.CandidatoController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class DeleteCandidatoHandler implements OperationHandler {

  private final CandidatoController candidatoController;
  private final ConsoleIO console;

  @Override
  public void handle() {
    final String id = console.readRequired("ID del Candidato a eliminar     : ");
    try {
      candidatoController.delete(id);
      console.println("\n  Candidato eliminado exitosamente.");
    } catch (final CandidatoNotFoundException exception) {
      console.println("  Error: " + exception.getMessage());
    } catch (final Exception exception) {
      console.println("  Error: " + exception.getMessage());
    }
  }
}
