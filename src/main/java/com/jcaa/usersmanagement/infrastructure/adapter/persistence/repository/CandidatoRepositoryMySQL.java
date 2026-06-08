package com.jcaa.usersmanagement.infrastructure.adapter.persistence.repository;

import com.jcaa.usersmanagement.application.port.out.DeleteCandidatoPort;
import com.jcaa.usersmanagement.application.port.out.GetAllCandidatosPort;
import com.jcaa.usersmanagement.application.port.out.GetCandidatoByCorreoPort;
import com.jcaa.usersmanagement.application.port.out.GetCandidatoByIdPort;
import com.jcaa.usersmanagement.application.port.out.SaveCandidatoPort;
import com.jcaa.usersmanagement.application.port.out.UpdateCandidatoPort;
import com.jcaa.usersmanagement.domain.exception.CandidatoNotFoundException;
import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoCorreo;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoId;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.dto.CandidatoPersistenceDto;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.exception.CandidatoPersistenceException;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.mapper.CandidatoPersistenceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Log
@RequiredArgsConstructor
public final class CandidatoRepositoryMySQL
    implements SaveCandidatoPort,
        UpdateCandidatoPort,
        GetCandidatoByIdPort,
        GetCandidatoByCorreoPort,
        GetAllCandidatosPort,
        DeleteCandidatoPort {

  private static final String SQL_INSERT =
      "INSERT INTO candidatos "
      + "(id, nombre, apellido, pais, ciudad, barrio, numero_manzana, numero_casa, telefono, correo) "
      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

  private static final String SQL_UPDATE =
      "UPDATE candidatos SET nombre = ?, apellido = ?, pais = ?, ciudad = ?, barrio = ?, numero_manzana = ?, numero_casa = ?, telefono = ?, correo = ? "
      + "WHERE id = ?";

  private static final String SQL_SELECT_BY_ID =
      "SELECT id, nombre, apellido, pais, ciudad, barrio, numero_manzana, numero_casa, telefono, correo "
      + "FROM candidatos "
      + "WHERE id = ? LIMIT 1";

  private static final String SQL_SELECT_BY_CORREO =
      "SELECT id, nombre, apellido, pais, ciudad, barrio, numero_manzana, numero_casa, telefono, correo "
      + "FROM candidatos "
      + "WHERE correo = ? LIMIT 1";

  private static final String SQL_SELECT_ALL =
      "SELECT id, nombre, apellido, pais, ciudad, barrio, numero_manzana, numero_casa, telefono, correo "
      + "FROM candidatos "
      + "ORDER BY nombre ASC";

  private static final String SQL_DELETE =
        "DELETE FROM candidatos "
        + "WHERE id = ?";

  private final Connection connection;

  @Override
  public CandidatoModel save(final CandidatoModel candidato) {
    final CandidatoPersistenceDto dto = CandidatoPersistenceMapper.fromModelToDto(candidato);
    executeSave(dto);
    return findByIdOrFail(candidato.getId());
  }

  @Override
  public CandidatoModel update(final CandidatoModel candidato) {
    final CandidatoPersistenceDto dto = CandidatoPersistenceMapper.fromModelToDto(candidato);
    executeUpdate(dto);
    return findByIdOrFail(candidato.getId());
  }

  @Override
  public Optional<CandidatoModel> getById(final CandidatoId candidatoId) {
    try (final PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
      statement.setString(1, candidatoId.value());
      final ResultSet resultSet = statement.executeQuery();
      if (!resultSet.next()) {
        return Optional.empty();
      }
      return Optional.of(CandidatoPersistenceMapper.fromResultSetToModel(resultSet));
    } catch (final SQLException exception) {
      throw CandidatoPersistenceException.becauseFindByIdFailed(candidatoId.value(), exception);
    }
  }

  @Override
  public Optional<CandidatoModel> getByCorreo(final CandidatoCorreo correo) {
    try (final PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_CORREO)) {
      statement.setString(1, correo.value());
      final ResultSet resultSet = statement.executeQuery();
      if (!resultSet.next()) {
        return Optional.empty();
      }
      return Optional.of(CandidatoPersistenceMapper.fromResultSetToModel(resultSet));
    } catch (final SQLException exception) {
      throw CandidatoPersistenceException.becauseFindByCorreoFailed(correo.value(), exception);
    }
  }

  @Override
  public List<CandidatoModel> getAll() {
    try (final PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL)) {
      final ResultSet resultSet = statement.executeQuery();
      return CandidatoPersistenceMapper.fromResultSetToModelList(resultSet);
    } catch (final SQLException exception) {
      throw CandidatoPersistenceException.becauseFindAllFailed(exception);
    }
  }

  @Override
  public void delete(final CandidatoId candidatoId) {
    try (final PreparedStatement statement = connection.prepareStatement(SQL_DELETE)) {
      statement.setString(1, candidatoId.value());
      statement.executeUpdate();
    } catch (final SQLException exception) {
      throw CandidatoPersistenceException.becauseDeleteFailed(candidatoId.value(), exception);
    }
  }

  private void executeSave(final CandidatoPersistenceDto dto) {
    try (final PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
      statement.setString(1, dto.id());
      statement.setString(2, dto.nombre());
      statement.setString(3, dto.apellido());
      statement.setString(4, dto.pais());
      statement.setString(5, dto.ciudad());
      statement.setString(6, dto.barrio());
      statement.setString(7, dto.numeroManzana());
      statement.setString(8, dto.numeroCasa());
      statement.setString(9, dto.telefono());
      statement.setString(10, dto.correo());
      statement.executeUpdate();
    } catch (final SQLException exception) {
      throw CandidatoPersistenceException.becauseSaveFailed(dto.id(), exception);
    }
  }

  private void executeUpdate(final CandidatoPersistenceDto dto) {
    try (final PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
      statement.setString(1, dto.nombre());
      statement.setString(2, dto.apellido());
      statement.setString(3, dto.pais());
      statement.setString(4, dto.ciudad());
      statement.setString(5, dto.barrio());
      statement.setString(6, dto.numeroManzana());
      statement.setString(7, dto.numeroCasa());
      statement.setString(8, dto.telefono());
      statement.setString(9, dto.correo());
      statement.setString(10, dto.id());
      statement.executeUpdate();
    } catch (final SQLException exception) {
      throw CandidatoPersistenceException.becauseUpdateFailed(dto.id(), exception);
    }
  }

  private CandidatoModel findByIdOrFail(final CandidatoId candidatoId) {
    return getById(candidatoId)
        .orElseThrow(() -> CandidatoNotFoundException.becauseIdWasNotFound(candidatoId.value()));
  }
}
