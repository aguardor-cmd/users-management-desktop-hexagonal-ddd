package com.jcaa.usersmanagement.application.service.mapper;

import com.jcaa.usersmanagement.application.service.dto.command.CreateCandidatoCommand;
import com.jcaa.usersmanagement.application.service.dto.command.DeleteCandidatoCommand;
import com.jcaa.usersmanagement.application.service.dto.command.UpdateCandidatoCommand;
import com.jcaa.usersmanagement.application.service.dto.query.GetCandidatoByIdQuery;
import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoApellido;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoBarrio;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoCiudad;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoCorreo;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoId;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoNombre;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoNumeroCasa;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoNumeroManzana;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoPais;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoTelefono;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CandidatoApplicationMapper {

  public CandidatoModel fromCreateCommandToModel(final CreateCandidatoCommand command) {
    return CandidatoModel.create(
        new CandidatoId(command.id()),
        new CandidatoNombre(command.nombre()),
        new CandidatoApellido(command.apellido()),
        new CandidatoPais(command.pais()),
        new CandidatoCiudad(command.ciudad()),
        new CandidatoBarrio(command.barrio()),
        new CandidatoNumeroManzana(command.numeroManzana()),
        new CandidatoNumeroCasa(command.numeroCasa()),
        new CandidatoTelefono(command.telefono()),
        new CandidatoCorreo(command.correo()));
  }

  public CandidatoModel fromUpdateCommandToModel(final UpdateCandidatoCommand command) {
    return new CandidatoModel(
        new CandidatoId(command.id()),
        new CandidatoNombre(command.nombre()),
        new CandidatoApellido(command.apellido()),
        new CandidatoPais(command.pais()),
        new CandidatoCiudad(command.ciudad()),
        new CandidatoBarrio(command.barrio()),
        new CandidatoNumeroManzana(command.numeroManzana()),
        new CandidatoNumeroCasa(command.numeroCasa()),
        new CandidatoTelefono(command.telefono()),
        new CandidatoCorreo(command.correo()));
  }

  public CandidatoId fromGetCandidatoByIdQueryToCandidatoId(final GetCandidatoByIdQuery query) {
    return new CandidatoId(query.id());
  }

  public CandidatoId fromDeleteCommandToCandidatoId(final DeleteCandidatoCommand command) {
    return new CandidatoId(command.id());
  }
}
