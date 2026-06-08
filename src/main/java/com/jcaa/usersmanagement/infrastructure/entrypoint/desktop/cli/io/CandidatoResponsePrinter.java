package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io;

import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CandidatoResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class CandidatoResponsePrinter {

  private static final String SEPARATOR = "-".repeat(52);
  private static final String ROW_FORMAT = "  %-15s : %s%n";

  private final ConsoleIO console;

  public void print(final CandidatoResponse response) {
    console.println(SEPARATOR);
    console.printf(ROW_FORMAT, "ID", response.id());
    console.printf(ROW_FORMAT, "Nombre", response.nombre());
    console.printf(ROW_FORMAT, "Apellido", response.apellido());
    console.printf(ROW_FORMAT, "País", response.pais());
    console.printf(ROW_FORMAT, "Ciudad", response.ciudad());
    console.printf(ROW_FORMAT, "Barrio", response.barrio());
    console.printf(ROW_FORMAT, "N° Manzana", response.numeroManzana());
    console.printf(ROW_FORMAT, "N° Casa", response.numeroCasa());
    console.printf(ROW_FORMAT, "Teléfono", response.telefono());
    console.printf(ROW_FORMAT, "Correo", response.correo());
    console.println(SEPARATOR);
  }

  public void printList(final List<CandidatoResponse> candidatos) {
    if (candidatos.isEmpty()) {
      console.println("  No se encontraron candidatos.");
      return;
    }
    console.printf("%n  Total: %d candidato(s)%n", candidatos.size());
    candidatos.forEach(this::print);
  }
}
