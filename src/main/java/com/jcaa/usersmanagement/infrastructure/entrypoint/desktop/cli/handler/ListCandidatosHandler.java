package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.CandidatoResponsePrinter;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.CandidatoController;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CandidatoResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class ListCandidatosHandler implements OperationHandler {

  private final CandidatoController candidatoController;
  private final CandidatoResponsePrinter printer;

  @Override
  public void handle() {
    try {
      final List<CandidatoResponse> list = candidatoController.getAll();
      printer.printList(list);
    } catch (final Exception exception) {
      System.out.println("  Error: " + exception.getMessage());
    }
  }
}
