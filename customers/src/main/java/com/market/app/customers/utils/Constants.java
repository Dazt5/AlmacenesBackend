package com.market.app.customers.utils;

public final class Constants {

	public static final class SuccessFulMessages {
		public static final String MESSAGE_RESOURCE_CREATED = "Registro creado satisfactoriamente";
		public static final String MESSAGE_RESOURCE_UPDATED = "Registro actualizado satisfacoriamente";
		public static final String MESSAGE_RESOURCE_DELETED = "Registro eliminado satisfactoriamente";
	}
	
	public static final class ErrorMessages {
		public static final String MESSAGE_RESOURCE_NOT_FOUND = "El registro al que hace referencia no existe";
		public static final String MESSAGE_RESOURCE_CONFLICT = "El registro con ese id ya se encuentra inscrito";
		public static final String MESSAGE_INTERNAL_SERVER_ERROR = "ERROR INTERNO EN EL SERVIDOR, EXCEPCION DE TIPO: ";
	}
	
	public static final class JWTConfig {
		public static final String AUTHORIZATION_HEADER_NAME = "Authorization";
		public static final String BEARER_PREFIX_HEADER = "Bearer ";
		public static final String SECRET = "MySecretSuperSecret";
	}
}
