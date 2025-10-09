package co.edu.uco.nose.crosscuting.messagescatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	
	USER_ERROR_SQLCONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada vacía", 
			"La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está vacía."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada nula", 
			"La conexión requerida para llevar a cabo la operación contra la base de datos llegó nula."),
	
	USER_ERROR_SQLCONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada", 
			"La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está cerrada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada", 
			"La conexión requerida para llevar a cabo la operación contra la base de datos está cerrada."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexión contra la fuente de datos deseada", 
			"Se ha presentado un problema inesperado tratando de validar el estado de la conexión requerida para llevar a cabo la la operación contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexión contra la base de datos estaba abierta", 
			"Se presentó un error de tipo SQLException al validar si la conexión contra la base de datos estaba o no abierta."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado.");
	
	private String title;
	private String content;
	
	private MessagesEnum(final String title, final String content) {
		setTitle(title);
		setContent(content);
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(final String title) {
		this.title = TextHelper.getDefaultWithTrim(title);
	}

	public String getContent() {
		return content;
	}

	private void setContent(final String content) {
		this.content = TextHelper.getDefaultWithTrim(content);
	}
	
	
	
}
