package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.mapper;

import com.jcaa.usersmanagement.application.service.dto.command.CreateCandidatoCommand;
import com.jcaa.usersmanagement.application.service.dto.command.UpdateCandidatoCommand;
import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CandidatoResponse;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CreateCandidatoRequest;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.UpdateCandidatoRequest;
import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CandidatoDesktopMapper {

  public CreateCandidatoCommand fromRequestToCreateCommand(final CreateCandidatoRequest request) {
    return new CreateCandidatoCommand(
        request.id(),
        request.nombre(),
        request.apellido(),
        request.pais(),
        request.ciudad(),
        request.barrio(),
        request.numeroManzana(),
        request.numeroCasa(),
        request.telefono(),
        request.correo());
  }

  public UpdateCandidatoCommand fromRequestToUpdateCommand(final UpdateCandidatoRequest request) {
    return new UpdateCandidatoCommand(
        request.id(),
        request.nombre(),
        request.apellido(),
        request.pais(),
        request.ciudad(),
        request.barrio(),
        request.numeroManzana(),
        request.numeroCasa(),
        request.telefono(),
        request.correo());
  }

  public CandidatoResponse fromModelToResponse(final CandidatoModel model) {
    return new CandidatoResponse(
        model.getId().value(),
        model.getNombre().value(),
        model.getApellido().value(),
        model.getPais().value(),
        model.getCiudad().value(),
        model.getBarrio().value(),
        model.getNumeroManzana().value(),
        model.getNumeroCasa().value(),
        model.getTelefono().value(),
        model.getCorreo().value());
  }

  public List<CandidatoResponse> fromModelListToResponseList(final List<CandidatoModel> models) {
    return models.stream().map(CandidatoDesktopMapper::fromModelToResponse).collect(Collectors.toList());
  }
}
