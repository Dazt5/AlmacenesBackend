package com.market.app.authentication.utils;

import com.market.app.authentication.entity.Subsidiary;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Constants {

    public static final class User {
        public static final String DEFAULT_USER_USERNAME = "admin";
        public static final String DEFAULT_USER_PASSWORD = "password";
    }

    public static final List<Subsidiary> defaultSubsidaries = Stream.of(
            new Subsidiary("1", "Bogotá", null),
            new Subsidiary("2", "Medellin", null),
            new Subsidiary("3", "Cali", null)
    ).collect(Collectors.toList());


    public static final class SuccessfulMessages {
        public static final String MESSAGE_RESOURCE_CREATED = "Registro creado satisfactoriamente";
        public static final String MESSAGE_RESOURCE_UPDATED = "Registro actualizado satisfactoriamente";
        public static final String MESSAGE_RESOURCE_DELETED = "Registro eliminado satisfactoriamente";
    }

    public static final class ErrorMessages {
        public static final String MESSAGE_RESOURCE_NOT_FOUND = "El registro al que hace referencia no existe";
        public static final String MESSAGE_RESOURCE_CONFLICT = "El registro con ese id ya se encuentra inscrito";
        public static final String MESSAGE_INTERNAL_SERVER_ERROR = "ERROR INTERNO EN EL SERVIDOR EXCEPCIÓN DE TIPO: ";
    }

    public static final class JWTConfig {
        public static final String AUTHORIZATION_HEADER_NAME = "Authorization";
        public static final String BEARER_PREFIX_HEADER = "Bearer ";
        public static final String SECRET = "MySecretSuperSecret";
    }
}

