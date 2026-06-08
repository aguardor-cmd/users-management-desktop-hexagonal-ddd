package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller;

import com.jcaa.usersmanagement.application.port.in.CreateCandidatoUseCase;
import com.jcaa.usersmanagement.application.port.in.DeleteCandidatoUseCase;
import com.jcaa.usersmanagement.application.port.in.GetAllCandidatosUseCase;
import com.jcaa.usersmanagement.application.port.in.GetCandidatoByIdUseCase;
import com.jcaa.usersmanagement.application.port.in.UpdateCandidatoUseCase;
import com.jcaa.usersmanagement.application.service.dto.command.CreateCandidatoCommand;
import com.jcaa.usersmanagement.application.service.dto.command.DeleteCandidatoCommand;
import com.jcaa.usersmanagement.application.service.dto.command.UpdateCandidatoCommand;
import com.jcaa.usersmanagement.application.service.dto.query.GetCandidatoByIdQuery;
import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CandidatoResponse;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CreateCandidatoRequest;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.UpdateCandidatoRequest;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.mapper.CandidatoDesktopMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CandidatoController {

  private final CreateCandidatoUseCase createCandidatoUseCase;
  private final UpdateCandidatoUseCase updateCandidatoUseCase;
  private final DeleteCandidatoUseCase deleteCandidatoUseCase;
  private final GetCandidatoByIdUseCase getCandidatoByIdUseCase;
  private final GetAllCandidatosUseCase getAllCandidatosUseCase;

  public CandidatoResponse create(final CreateCandidatoRequest request) {
    final CreateCandidatoCommand command = CandidatoDesktopMapper.fromRequestToCreateCommand(request);
    final CandidatoModel createdCandidato = createCandidatoUseCase.execute(command);
    return CandidatoDesktopMapper.fromModelToResponse(createdCandidato);
  }

  public CandidatoResponse update(final UpdateCandidatoRequest request) {
    final UpdateCandidatoCommand command = CandidatoDesktopMapper.fromRequestToUpdateCommand(request);
    final CandidatoModel updatedCandidato = updateCandidatoUseCase.execute(command);
    return CandidatoDesktopMapper.fromModelToResponse(updatedCandidato);
  }

  public void delete(final String id) {
    final DeleteCandidatoCommand command = new DeleteCandidatoCommand(id);
    deleteCandidatoUseCase.execute(command);
  }

  public CandidatoResponse getById(final String id) {
    final GetCandidatoByIdQuery query = new GetCandidatoByIdQuery(id);
    final CandidatoModel model = getCandidatoByIdUseCase.execute(query);
    return CandidatoDesktopMapper.fromModelToResponse(model);
  }

  public List<CandidatoResponse> getAll() {
    final List<CandidatoModel> models = getAllCandidatosUseCase.execute();
    return CandidatoDesktopMapper.fromModelListToResponseList(models);
  }
}
