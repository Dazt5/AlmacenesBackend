package com.market.app.customers_products_providers.utils;

public final class Constants {

    public static final class User {
        public static final String DEFAULT_USER_USERNAME = "admin";
        public static final String DEFAULT_USER_PASSWORD = "password";
    }

    public static final class Validations {
        public static final String CONTENT_TYPE_CSV = "text/csv";
        public static final String CONTENT_TYPE_APPLICATION_CSV = "application/csv";
    }


    public static final class SuccessfulMessages {
        public static final String MESSAGE_RESOURCE_CREATED = "Registro creado satisfactoriamente";
        public static final String MESSAGE_RESOURCE_UPDATED = "Registro actualizado satisfactoriamente";
        public static final String MESSAGE_RESOURCE_DELETED = "Registro eliminado satisfactoriamente";
    }

    public static final class ErrorMessages {
        public static final String MESSAGE_RESOURCE_NOT_FOUND = "El registro al que hace referencia no existe";
        public static final String MESSAGE_RESOURCE_CONFLICT = "El registro con ese id ya se encuentra inscrito";
        public static final String MESSAGE_INTERNAL_SERVER_ERROR = "ERROR INTERNO EN EL SERVIDOR EXCEPCIÓN DE TIPO: ";
        public static final String MESSAGE_FILE_NOT_ACCEPTED = "Ha intentado enviar un archivo no válido";
        public static final String MESSAGE_FILE_EMPTY = "El archivo está vacio.";
    }

    public static final class JWTConfig {
        public static final String AUTHORIZATION_HEADER_NAME = "Authorization";
        public static final String BEARER_PREFIX_HEADER = "Bearer ";
        public static final String SECRET = "MySecretSuperSecret";
    }
}
