package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.domain.exception.CandidatoNotFoundException;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.CandidatoResponsePrinter;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.CandidatoController;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CandidatoResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class FindCandidatoByIdHandler implements OperationHandler {

  private final CandidatoController candidatoController;
  private final ConsoleIO console;
  private final CandidatoResponsePrinter printer;

  @Override
  public void handle() {
    final String id = console.readRequired("ID del Candidato a buscar       : ");
    try {
      final CandidatoResponse found = candidatoController.getById(id);
      printer.print(found);
    } catch (final CandidatoNotFoundException exception) {
      console.println("  Error: " + exception.getMessage());
    } catch (final Exception exception) {
      console.println("  Error: " + exception.getMessage());
    }
  }
}
