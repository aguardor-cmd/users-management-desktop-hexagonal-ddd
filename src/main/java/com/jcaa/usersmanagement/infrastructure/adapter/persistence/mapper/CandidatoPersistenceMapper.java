package com.jcaa.usersmanagement.infrastructure.adapter.persistence.mapper;

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
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.dto.CandidatoPersistenceDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CandidatoPersistenceMapper {

  public CandidatoPersistenceDto fromModelToDto(final CandidatoModel model) {
    return new CandidatoPersistenceDto(
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

  public CandidatoModel fromResultSetToModel(final ResultSet resultSet) throws SQLException {
    return CandidatoModel.create(
        new CandidatoId(resultSet.getString("id")),
        new CandidatoNombre(resultSet.getString("nombre")),
        new CandidatoApellido(resultSet.getString("apellido")),
        new CandidatoPais(resultSet.getString("pais")),
        new CandidatoCiudad(resultSet.getString("ciudad")),
        new CandidatoBarrio(resultSet.getString("barrio")),
        new CandidatoNumeroManzana(resultSet.getString("numero_manzana")),
        new CandidatoNumeroCasa(resultSet.getString("numero_casa")),
        new CandidatoTelefono(resultSet.getString("telefono")),
        new CandidatoCorreo(resultSet.getString("correo")));
  }

  public List<CandidatoModel> fromResultSetToModelList(final ResultSet resultSet) throws SQLException {
    final List<CandidatoModel> models = new ArrayList<>();
    while (resultSet.next()) {
      models.add(fromResultSetToModel(resultSet));
    }
    return models;
  }
}
