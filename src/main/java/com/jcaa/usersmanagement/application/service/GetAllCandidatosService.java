package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.GetAllCandidatosUseCase;
import com.jcaa.usersmanagement.application.port.out.GetAllCandidatosPort;
import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public final class GetAllCandidatosService implements GetAllCandidatosUseCase {

  private final GetAllCandidatosPort getAllCandidatosPort;

  @Override
  public List<CandidatoModel> execute() {
    return getAllCandidatosPort.getAll();
  }
}
