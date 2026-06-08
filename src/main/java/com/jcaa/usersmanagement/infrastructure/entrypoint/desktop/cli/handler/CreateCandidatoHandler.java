package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.domain.exception.CandidatoAlreadyExistsException;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.CandidatoResponsePrinter;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.CandidatoController;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CreateCandidatoRequest;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CandidatoResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class CreateCandidatoHandler implements OperationHandler {

  private final CandidatoController candidatoController;
  private final ConsoleIO console;
  private final CandidatoResponsePrinter printer;

  @Override
  public void handle() {
    final String id = console.readRequired("ID (ej. UUID)                   : ");
    final String nombre = console.readRequired("Nombre                          : ");
    final String apellido = console.readRequired("Apellido                        : ");
    final String pais = console.readRequired("País                            : ");
    final String ciudad = console.readRequired("Ciudad                          : ");
    final String barrio = console.readRequired("Barrio                          : ");
    final String numeroManzana = console.readRequired("Número de Manzana               : ");
    final String numeroCasa = console.readRequired("Número de Casa                  : ");
    final String telefono = console.readRequired("Teléfono                        : ");
    final String correo = console.readRequired("Correo electrónico              : ");

    try {
      final CandidatoResponse created =
          candidatoController.create(
              new CreateCandidatoRequest(
                  id, nombre, apellido, pais, ciudad, barrio, numeroManzana, numeroCasa, telefono, correo));
      console.println("\n  Candidato creado exitosamente.");
      printer.print(created);
    } catch (final CandidatoAlreadyExistsException exception) {
      console.println("  Error: " + exception.getMessage());
    } catch (final Exception exception) {
      console.println("  Error: " + exception.getMessage());
    }
  }
}
