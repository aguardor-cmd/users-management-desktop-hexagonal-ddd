package com.jcaa.usersmanagement.application.service.dto.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateCandidatoCommand(
    @NotBlank(message = "id must not be blank") String id,
    @NotBlank(message = "nombre must not be blank") String nombre,
    @NotBlank(message = "apellido must not be blank") String apellido,
    @NotBlank(message = "pais must not be blank") String pais,
    @NotBlank(message = "ciudad must not be blank") String ciudad,
    @NotBlank(message = "barrio must not be blank") String barrio,
    @NotBlank(message = "numeroManzana must not be blank") String numeroManzana,
    @NotBlank(message = "numeroCasa must not be blank") String numeroCasa,
    @NotBlank(message = "telefono must not be blank") String telefono,
    @NotBlank(message = "correo must not be blank")
    @Email(message = "correo must be a valid email address") String correo) {
}
